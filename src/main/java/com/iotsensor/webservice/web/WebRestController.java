package com.iotsensor.webservice.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iotsensor.webservice.domain.SensorData;
import com.iotsensor.webservice.domain.SensorDataRepository;
import com.iotsensor.webservice.dto.sensordata.SensorDataSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private SensorDataRepository sensorDataRepository;
	
	@GetMapping("/")
	public String main() {
		return "Main page";
	}
	
	/**
	 * Sensor data 삽입
	 * 
	 * ex) 
	 * 
	 * @param dto
	 */
	@PostMapping("/api/addData")
	public void saveRatings(@RequestBody SensorDataSaveRequestDto dto) {
		sensorDataRepository.save(dto.toEntity());
	}
	
	@GetMapping("/api/search/deviceId/{deviceId}")
	public List<SensorData> searchDataByDeviceId(@PathVariable("deviceId") String deviceId)
	{
		return sensorDataRepository.findByDeviceId(deviceId);
	}
	
	@GetMapping("/api/search/serviceId/{serviceId}")
	public List<SensorData> searchDataByServiceId(@PathVariable("serviceId") String serviceId)
	{
		return sensorDataRepository.findByServiceId(serviceId);
	}
	
	@GetMapping("/api/search/date/{date}")
	public List<SensorData> searchDataByDate(@PathVariable("date") String date)
	{
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime before = StringUtils.equals(date, "default") ? now.minusDays(5) : LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE), LocalTime.of(0,0,0));
		
		return sensorDataRepository.findByCreatedDateBetween(before, now);
	}
}
