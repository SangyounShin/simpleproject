package com.iotsensor.webservice.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iotsensor.webservice.dto.SensorDataSaveRequestDto;
import com.iotsensor.webservice.dto.SensorDataSearchDto;
import com.iotsensor.webservice.service.SensorDataService;

import lombok.AllArgsConstructor;

/**
 * 
 * WebRestController.java
 * @description 
 * Webservice 처리를 위한 controller
 * 
 * @author SY
 *
 */
@RestController
@AllArgsConstructor
public class WebRestController {

	private SensorDataService sensorDataService;
	
	@GetMapping("/")
	public String main() {
		return "Main page";
	}
	
	/**
	 * Sensor data 삽입
	 * 
	 * SensorDataSaveRequestDto(deviceId, serviceId, sensorCode)로 호출 
	 * 
	 * @param dto
	 */
	@PostMapping("/api/addData")
	public void saveRatings(@RequestBody SensorDataSaveRequestDto dto) {
		getSensorDataService().saveSensorData(dto.toEntity());
	}
	
	/**
	 * 
	 * @description
	 * Device ID 로 SensorData 조회
	 *
	 * @param deviceId
	 * @return List<SensorDataSearchDto>
	 */
	@GetMapping("/api/search/deviceId/{deviceId}")
	public List<SensorDataSearchDto> searchDataByDeviceId(@PathVariable("deviceId") String deviceId)
	{
		return getSensorDataService().findByDeviceId(deviceId);
	}
	
	/**
	 * 
	 * @description
	 * Service ID 로 SensorData 조회
	 *
	 * @param serviceId
	 * @return List<SensorDataSearchDto>
	 */
	@GetMapping("/api/search/serviceId/{serviceId}")
	public List<SensorDataSearchDto> searchDataByServiceId(@PathVariable("serviceId") String serviceId)
	{
		return getSensorDataService().findByServiceId(serviceId);
	}
	
	/**
	 * 
	 * @description
	 * 생성 날짜 기준으로 SensorData 조회
	 *
	 * @param date
	 * @return List<SensorDataSearchDto>
	 */
	@GetMapping("/api/search/date/{date}")
	public List<SensorDataSearchDto> searchDataByDate(@PathVariable("date") String date)
	{
		return getSensorDataService().findByCreatedDateBetween(date);
	}

	public SensorDataService getSensorDataService() {
		return sensorDataService;
	}

	public void setSensorDataService(SensorDataService sensorDataService) {
		this.sensorDataService = sensorDataService;
	}
	
}
