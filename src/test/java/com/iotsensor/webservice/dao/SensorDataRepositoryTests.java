package com.iotsensor.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iotsensor.webservice.domain.SensorData;
import com.iotsensor.webservice.domain.SensorDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorDataRepositoryTests {
	
	@Autowired
	SensorDataRepository sensorDataRepository;

	@After
	public void cleanup() {
		
		sensorDataRepository.deleteAll();
	}
	
	@Test
	public void save() {
		
		//given
		sensorDataRepository.save(SensorData.builder()
				.deviceId("D0001")
				.serviceId("S0001")
				.sensorCode("123456789aaa")
				.build());
		
        //when
        List<SensorData> ratingsList = sensorDataRepository.findAll();

        //then
        SensorData ratings = ratingsList.get(0);
        assertThat(ratings.getDeviceId(), is("D0001"));
        assertThat(ratings.getSensorCode(), is("123456789aaa"));
        
	}
	
	@Test
	public void dateEntitySave() {
		
		//given
		LocalDateTime now = LocalDateTime.now();
		sensorDataRepository.save(SensorData.builder()
				.deviceId("D0001")
				.serviceId("S0001")
				.sensorCode("123456789aaa")
				.build());
		
		//when
		List<SensorData> sensorDataList = sensorDataRepository.findAll();
		
		//then
		SensorData sensorData = sensorDataList.get(0);
		assertTrue(sensorData.getCreatedDate().isAfter(now));
		assertTrue(sensorData.getModifiedDate().isAfter(now));
	}
}
