package com.iotsensor.webservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * SensorData.java
 * @description 
 * 어플리케이션에서 사용할 SensorData Entity 명세
 * 
 * @author SY
 *
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class SensorData{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) // 생성 시 Auto generate
	private Long id;
	
	@Column(nullable = false)
	private String deviceId;

	private String serviceId;
	
	@Column(nullable = false)
	private String sensorCode;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
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
