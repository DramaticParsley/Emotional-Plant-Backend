package com.dramaticparsley.emotionalplant.controller;


import com.dramaticparsley.emotionalplant.data.SoilMoisture;
import com.dramaticparsley.emotionalplant.data.SoilMoistureStatus;
import com.dramaticparsley.emotionalplant.repository.SoilMoistureRepository;
import com.dramaticparsley.emotionalplant.service.SoilMoistureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoilMoistureController {
  @Autowired
  private SoilMoistureRepository soilMoistureRepository;
  @Autowired
  private SoilMoistureService soilMoistureService;

  @PostMapping(path = "/soilmoisture")
  public void addSensorValue(@RequestParam Integer value) {
    soilMoistureRepository.saveValue(value);
  }

  @DeleteMapping(path = "/soilmoisture", consumes = "application/json")
  public void deleteSensorValue(@RequestBody SoilMoisture soilMoisture) {
    soilMoistureRepository.delete(soilMoisture);
  }

  @GetMapping(path = "/soilmoisture/all")
  public List<SoilMoisture> getAllRecords() {
    return soilMoistureRepository.findAll();
  }

  @GetMapping(path = "/soilmoisture/status/connected")
  public Boolean getConnectedStatus() {
    return soilMoistureService.isConnected(soilMoistureRepository.findTopByOrderByIdDesc());
  }

  @GetMapping(path = "/soilmoisture/status/water")
  public Boolean getWaterStatus() {
    return soilMoistureService.needsWater(soilMoistureRepository.findTopByOrderByIdDesc());
  }
}
