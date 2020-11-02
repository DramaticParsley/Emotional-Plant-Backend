package com.dramaticparsley.emotionalplant.data;

import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "soil_moisture")
public class SoilMoisture {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Basic
  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;
  private Integer value;

  public SoilMoisture(){}
}
