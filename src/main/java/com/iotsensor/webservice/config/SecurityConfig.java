package com.iotsensor.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * SecurityConfig.java
 * @description 
 * Spring security 확장 config
 * 
 * @author SY
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * Spring security 설정 시 H2 console 접속을 위한 config
	 */
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
        	.antMatchers("/h2-console/**").permitAll();
 
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }
	
}
