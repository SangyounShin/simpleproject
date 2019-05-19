package com.iotsensor.webservice.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.iotsensor.webservice.dao.SensorDataRepository;
import com.iotsensor.webservice.filter.AccessLogFilter;
import com.iotsensor.webservice.model.SensorData;
import com.iotsensor.webservice.service.SensorDataService;

/**
 * 
 * AppConfig.java
 * @description 
 * Application 관련 config
 * 
 * @author SY
 *
 */
@Configuration
public class AppConfig {

	/**
	 * 초기 데이터 생성
	 * @author SY
	 *
	 */
	@Component
	public class DataLoader implements ApplicationRunner {

	    private SensorDataRepository repository;

	    @Autowired
	    public DataLoader(SensorDataRepository repository) {
	        this.repository = repository;
	    }

	    public void run(ApplicationArguments args) {
	        repository.save(SensorData.builder()
					.deviceId("D0001")
					.serviceId("S0001")
					.sensorCode("0000111001")
					.createdDate(LocalDateTime.of(LocalDate.of(2019,1,1), LocalTime.of(0,0,0)))
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,1,1), LocalTime.of(0,0,0)))
					.build());
	        
	        repository.save(SensorData.builder()
					.deviceId("D0002")
					.serviceId("S0001")
					.sensorCode("0000111022")
					.createdDate(LocalDateTime.of(LocalDate.of(2019,1,1), LocalTime.of(12,30,0)))
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,1,1), LocalTime.of(12,30,0)))
					.build());
	        
	        repository.save(SensorData.builder()
					.deviceId("D0002")
					.serviceId("S0001")
					.sensorCode("000011555")
					.createdDate(LocalDateTime.of(LocalDate.of(2019,1,1), LocalTime.of(12,40,0)))
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,1,1), LocalTime.of(12,40,0)))
					.build());
	        
	        repository.save(SensorData.builder()
					.deviceId("D0003")
					.serviceId("S0002")
					.sensorCode("0000111111")
					.createdDate(LocalDateTime.of(LocalDate.of(2019,1,8), LocalTime.of(0,0,0)))
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,1,8), LocalTime.of(0,0,0)))
					.build());
	        
	        repository.save(SensorData.builder()
					.deviceId("D0004")
					.serviceId("S0002")
					.sensorCode("0000111999")
					.createdDate(LocalDateTime.of(LocalDate.of(2019,1,11), LocalTime.of(3,0,0)))
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,1,11), LocalTime.of(3,0,0)))
					.build());
	        
	        repository.save(SensorData.builder()
					.deviceId("D0005")
					.serviceId("S0003")
					.sensorCode("22220111001")
					.createdDate(LocalDateTime.of(LocalDate.of(2019,2,1), LocalTime.of(0,0,0)))
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,2,1), LocalTime.of(0,0,0)))
					.build());
	        
	        repository.save(SensorData.builder()
					.deviceId("D0006")
					.serviceId("S0004")
					.sensorCode("990dasd111001")
					.createdDate(LocalDateTime.now())
					.modifiedDate(LocalDateTime.of(LocalDate.of(2019,2,1), LocalTime.of(0,0,0)))
					.build());
	    }
	}
	
	/**
	 * AccessLog Filter bean 등록 및 pattern 추가
	 * @return bean
	 */
	@Bean
	public FilterRegistrationBean<AccessLogFilter> accessLogFilterBean() {
		FilterRegistrationBean<AccessLogFilter> registrationBean = new FilterRegistrationBean<AccessLogFilter>(new AccessLogFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
	
	/**
	 * ModelMapper bean 등록
	 * @return
	 */
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
}
