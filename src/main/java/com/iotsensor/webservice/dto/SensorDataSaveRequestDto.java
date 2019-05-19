package com.iotsensor.webservice.dto.sensordata;

import com.iotsensor.webservice.domain.SensorData;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
