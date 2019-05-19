package com.iotsensor.webservice.service;

import java.util.List;

import com.iotsensor.webservice.dto.SensorDataSearchDto;
import com.iotsensor.webservice.model.SensorData;

/**
 * 
 * SensorDataService.java
 * @description 
 * SensorData 처리를 위한 Service Interface
 * Modelmapper를 통해 model -> dto 변환 처리
 * 
 * @author SY
 *
 */
public interface SensorDataService {
	
	/**
	 * 
	 * @description
	 * SensorData 저장
	 *
	 * @param data
	 */
	public void saveSensorData(SensorData data);
	
	/**
	 * 
	 * @description
	 * Device ID 로 SensorData 조회 후 SensorDataSearchDto 로 변환
	 *
	 * @param deviceId
	 * @return List<SensorDataSearchDto>
	 */
	public List<SensorDataSearchDto> findByDeviceId(String deviceId);
	
	/**
	 * 
	 * @description
	 * Service ID 로 SensorData 조회 후 SensorDataSearchDto 로 변환
	 *
	 * @param SeviceId
	 * @return List<SensorDataSearchDto>
	 */
	public List<SensorDataSearchDto> findByServiceId(String SeviceId);
	
	/**
	 * 
	 * @description
	 * 생성 날짜 기준으로 SensorData 조회
	 * parameter 가 "default" 인 경우 현재 날짜로부터 5일전 데이터 까지 조회
	 *
	 * @param date
	 * @return List<SensorDataSearchDto>
	 */
	public List<SensorDataSearchDto> findByCreatedDateBetween(String date);

}
