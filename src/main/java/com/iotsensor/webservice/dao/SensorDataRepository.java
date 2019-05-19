package com.iotsensor.webservice.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iotsensor.webservice.model.SensorData;

/**
 * 
 * SensorDataRepository.java
 * @description 
 * SensorData 객체의 Respository Interface
 * 
 * @author SY
 *
 */
public interface SensorDataRepository extends JpaRepository<SensorData, Long>{

	/**
	 * 
	 * @description
	 * Device ID 로 SensorData 조회
	 *
	 * @param deviceId
	 * @return List<SensorData>
	 */
	public List<SensorData> findByDeviceId(String deviceId);
	
	/**
	 * 
	 * @description
	 * Service ID 로 SensorData 조회
	 *
	 * @param serviceId
	 * @return List<SensorData>
	 */
	public List<SensorData> findByServiceId(String serviceId);
	
	/**
	 * 
	 * @description
	 * 생성 날짜 기준으로 SensorData 조회
	 *
	 * @param before
	 * @param now
	 * @return List<SensorData>
	 */
	public List<SensorData> findByCreatedDateBetween(LocalDateTime before, LocalDateTime now);
	
}
