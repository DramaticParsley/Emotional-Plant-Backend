package com.dramaticparsley.emotionalplant.repository;

import com.dramaticparsley.emotionalplant.data.SoilMoisture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SoilMoistureRepository extends JpaRepository<SoilMoisture, Long> {
  SoilMoisture save(SoilMoisture soilMoisture);

  List<SoilMoisture> findAll();

  void delete(SoilMoisture soilMoisture);

  @Modifying
  @Query(value = "insert into soil_moisture (timestamp, value) value(CURRENT_TIMESTAMP(), :input)", nativeQuery = true)
  @Transactional
  void saveValue( @Param("input") Integer value) ;


  SoilMoisture findTopByOrderByIdDesc();
}
