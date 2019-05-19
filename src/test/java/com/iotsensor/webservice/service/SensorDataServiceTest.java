package com.iotsensor.webservice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iotsensor.webservice.dao.SensorDataRepository;
import com.iotsensor.webservice.dto.SensorDataSearchDto;
import com.iotsensor.webservice.model.SensorData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SensorDataServiceTest {
	
	@Autowired
	SensorDataService sensorDataService;
	
	@Autowired
	SensorDataRepository sensorDataRepository;

	@After
	public void cleanup() {
		
		sensorDataRepository.deleteAll();
	}
	
	@Test
	public void findByCreatedDateBetweenTest() {
		
		//given
		sensorDataRepository.save(SensorData.builder()
				.deviceId("D0001")
				.serviceId("S0001")
				.sensorCode("123456789aaa")
				.build());
		
        //when
        List<SensorDataSearchDto> dataList = sensorDataService.findByCreatedDateBetween("default");

        //then
        SensorDataSearchDto data = dataList.get(0);
        assertThat(data.getDeviceId(), is("D0001"));
        assertThat(data.getSensorCode(), is("123456789aaa"));
        
	}
	
}
