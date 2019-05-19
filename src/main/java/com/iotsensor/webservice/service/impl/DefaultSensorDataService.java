package com.iotsensor.webservice.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotsensor.webservice.dao.SensorDataRepository;
import com.iotsensor.webservice.dto.SensorDataSearchDto;
import com.iotsensor.webservice.model.SensorData;
import com.iotsensor.webservice.service.SensorDataService;

/**
 * 
 * DefaultSensorDataService.java
 * @description 
 * SensorDataService 구현체
 * 
 * @author SY
 *
 */
@Service("SersorDataService")
public class DefaultSensorDataService implements SensorDataService{

	@Autowired
	private SensorDataRepository sensorDataRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void saveSensorData(SensorData data) {
		
		getSensorDataRepository().save(data);
	
	}

	@Override
	public List<SensorDataSearchDto> findByDeviceId(String deviceId) {
		
		return getSensorDataRepository().findByDeviceId(deviceId)
				.stream().map(sensorData -> getModelMapper().map(sensorData, SensorDataSearchDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public List<SensorDataSearchDto> findByServiceId(String serviceId) {
		
		return getSensorDataRepository().findByServiceId(serviceId)
				.stream().map(sensorData -> getModelMapper().map(sensorData, SensorDataSearchDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public List<SensorDataSearchDto> findByCreatedDateBetween(String date) {
		
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime before = StringUtils.equals(date, "default") ? now.minusDays(5) : LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0,0,0));
				
		return getSensorDataRepository().findByCreatedDateBetween(before, now)
				.stream().map(sensorData -> getModelMapper().map(sensorData, SensorDataSearchDto.class)).collect(Collectors.toList());
	}

	public SensorDataRepository getSensorDataRepository() {
		return sensorDataRepository;
	}

	public void setSensorDataRepository(SensorDataRepository sensorDataRepository) {
		this.sensorDataRepository = sensorDataRepository;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}
