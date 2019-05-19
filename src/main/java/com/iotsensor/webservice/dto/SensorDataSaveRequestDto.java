package com.iotsensor.webservice.dto;

import com.iotsensor.webservice.model.SensorData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * SensorDataSaveRequestDto.java
 * @description 
 * SensorData save request 을 위한 DTO
 * 
 * @author SY
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class SensorDataSaveRequestDto {
	
	private String deviceId;
	private String serviceId;
	private String sensorCode;
	
	public SensorData toEntity() {
		return SensorData.builder()
				.deviceId(deviceId)
				.serviceId(serviceId)
				.sensorCode(sensorCode)
				.build();
	}
}
