package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.revature.assignforce.config.SecurityConfig;



public class SecurityConfigTest {
	

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	public void testSecurityConfig1() throws Exception {
		SecurityConfig securityConfig = new SecurityConfig();
		//securityConfig.
		//Mockito.mock(SecurityConfig.class);
		//Mockito.doNothing().when(securityConfig).configure(null);
		//SecurityConfig t1 = new SecurityConfig();
		
		//HttpSecurity http = Mockito.mock(HttpSecurity.class);
		@SuppressWarnings("unchecked")
		ObjectPostProcessor<Object> objectPostProcessor = Mockito.mock(ObjectPostProcessor.class);
		
		AuthenticationManagerBuilder authenticationBuilder = Mockito.mock(AuthenticationManagerBuilder.class);
		
		Map<Class<? extends Object>, Object> sharedObjects = Mockito.mock(Map.class);
		
		HttpSecurity http = new HttpSecurity(objectPostProcessor,authenticationBuilder,sharedObjects);
		securityConfig.configure(http);
		
		
		verify(objectPostProcessor , times(1));
		//verify(authenticationBuilder , times(1));
		//verify(sharedObjects , times(1));
	};
}
