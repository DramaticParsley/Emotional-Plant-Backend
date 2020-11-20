package com.dramaticparsley.emotionalplant.controller;


import com.dramaticparsley.emotionalplant.data.SoilMoisturePayload;
import com.dramaticparsley.emotionalplant.data.SoilMoistureResponse;
import com.dramaticparsley.emotionalplant.repository.SoilMoistureRepository;
import com.dramaticparsley.emotionalplant.service.SoilMoistureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SoilMoistureController {
  @Autowired
  private SoilMoistureRepository soilMoistureRepository;

  @PostMapping(path = "/soilmoisture")
  @ResponseBody
  public ResponseEntity<SoilMoistureResponse> addSensorValue(@RequestBody SoilMoisturePayload soilMosisturePayload) {
    soilMoistureRepository.saveValue(soilMosisturePayload.getValue(), soilMosisturePayload.getName());
    SoilMoistureResponse soilMoistureResponse = new SoilMoistureResponse(SoilMoistureService.needsWater(soilMosisturePayload.getValue()));
    return ResponseEntity.status(HttpStatus.OK).body(soilMoistureResponse);
  }

}
