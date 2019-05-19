package com.iotsensor.webservice.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepository extends JpaRepository<SensorData, Long>{

	public List<SensorData> findByDeviceId(String deviceId);
	
	public List<SensorData> findByServiceId(String serviceId);
	
	public List<SensorData> findByCreatedDateBetween(LocalDateTime before, LocalDateTime now);
	
}
