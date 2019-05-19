package com.iotsensor.webservice.web;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.iotsensor.webservice.dto.SensorDataSearchDto;
import com.iotsensor.webservice.service.SensorDataService;

@RunWith(SpringRunner.class)
@WebMvcTest(WebRestController.class)
public class WebRestControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	SensorDataService sensorDataService;
	
	@Test
	public void testSearchDataByDeviceId() throws Exception {
		
		//given
		List<SensorDataSearchDto> data = Arrays.asList(new SensorDataSearchDto("D0001", "S0001", "123123123"));
		
        //when
		when(sensorDataService.findByDeviceId("D0001")).thenReturn(data);
		
        final ResultActions actions = mvc.perform(get("/api/search/deviceId/{deviceId}", "D0001")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());
        
        //then
        actions
                .andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].deviceId").value("D0001"))
                .andExpect(jsonPath("$[0].serviceId").value("S0001"))
                .andExpect(jsonPath("$[0].sensorCode").value("123123123"));
	}
	
	@Test
	public void testSearchDataByServiceId() throws Exception {
		
		//given
		List<SensorDataSearchDto> data = Arrays.asList(new SensorDataSearchDto("D0001", "S0001", "123123123"));
		
        //when
		when(sensorDataService.findByServiceId("S0001")).thenReturn(data);
		
        final ResultActions actions = mvc.perform(get("/api/search/serviceId/{serviceId}", "S0001")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print());
        
        //then
        actions
                .andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].deviceId").value("D0001"))
                .andExpect(jsonPath("$[0].serviceId").value("S0001"))
                .andExpect(jsonPath("$[0].sensorCode").value("123123123"));
	}
	
}
