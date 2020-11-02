package com.dramaticparsley.emotionalplant.data;

import lombok.Data;

@Data
public class SoilMoistureStatus {
  private Boolean isOnline;
  private Boolean needsWater;
}
