package com.iotsensor.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class SensorData{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String deviceId;

	private String serviceId;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String sensorCode;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime modifiedDate;
	
	@Builder
	public SensorData(String deviceId, String serviceId, String sensorCode) {
		this.deviceId = deviceId;
		this.serviceId = serviceId;
		this.sensorCode = sensorCode;
	}
	
	@Builder
	public SensorData(String deviceId, String serviceId, String sensorCode, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.deviceId = deviceId;
		this.serviceId = serviceId;
		this.sensorCode = sensorCode;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
}
