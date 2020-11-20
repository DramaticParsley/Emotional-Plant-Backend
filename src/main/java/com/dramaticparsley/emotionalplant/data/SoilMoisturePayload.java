package com.dramaticparsley.emotionalplant.data;

import lombok.Data;

@Data
public class SoilMoisturePayload {
  private Integer value;
  private String  name;

  public SoilMoisturePayload(){};

}
