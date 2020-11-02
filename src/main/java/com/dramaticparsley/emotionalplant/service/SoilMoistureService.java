package com.dramaticparsley.emotionalplant.service;


import com.dramaticparsley.emotionalplant.data.SoilMoisture;
import com.dramaticparsley.emotionalplant.data.SoilMoistureStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class SoilMoistureService {

  public static final Integer NEEDS_WATER_THRESHOLD = 380;

  public Boolean needsWater(SoilMoisture record) {
    return record.getValue() > NEEDS_WATER_THRESHOLD;
  }

  public Boolean isConnected(SoilMoisture record) {
    Calendar yesterday  = Calendar.getInstance();
    yesterday.add(Calendar.DATE, -1);
    Calendar tomorrow   = Calendar.getInstance();
    tomorrow.add(Calendar.DATE, 1);

    return record.getTimestamp().after(yesterday.getTime()) &&
      record.getTimestamp().before(tomorrow.getTime());
  }
}
