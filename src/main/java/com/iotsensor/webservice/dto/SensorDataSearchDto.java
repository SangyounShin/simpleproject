package com.iotsensor.webservice.dto;

import com.iotsensor.webservice.model.SensorData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * SensorDataSearchDto.java
 * @description 
 * SensorData 조회용 DTO
 * 
 * @author SY
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class SensorDataSearchDto {

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
	
	public SensorDataSearchDto(String deviceId, String serviceId, String sensorCode) {
		this.deviceId = deviceId;
		this.serviceId = serviceId;
		this.sensorCode = sensorCode;
	}
}
