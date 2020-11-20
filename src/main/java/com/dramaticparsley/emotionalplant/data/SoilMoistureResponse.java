package com.dramaticparsley.emotionalplant.data;

import lombok.Data;

@Data
public class SoilMoistureResponse {
  private Boolean needsWater;

  public SoilMoistureResponse(Boolean needsWater) {
    this.needsWater = needsWater;
  }
}
