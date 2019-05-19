package com.iotsensor.webservice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.iotsensor.webservice.domain.SensorData;
import com.iotsensor.webservice.domain.SensorDataRepository;
import com.iotsensor.webservice.filter.AccessLogFilter;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
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
	 * AccessLog Filter 생성
	 * @return bean
	 */
	@Bean
	public FilterRegistrationBean accessLogFilterBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new AccessLogFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
}
