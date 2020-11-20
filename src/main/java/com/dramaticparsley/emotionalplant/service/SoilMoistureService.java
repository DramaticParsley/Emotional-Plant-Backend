package com.dramaticparsley.emotionalplant.service;

public class SoilMoistureService {
  private static final Integer NEEDS_WATER_TRIGGER_VALUE = 450;


  public static Boolean needsWater(Integer sensorValue) {
    return sensorValue > NEEDS_WATER_TRIGGER_VALUE;
  }
}
