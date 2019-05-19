package com.iotsensor.webservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SensorDataSearchDto {

	private String deviceId;
	private String serviceId;
	private String sensorCode;
	
}
