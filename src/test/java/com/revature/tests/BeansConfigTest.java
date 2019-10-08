package com.revature.tests;
import com.revature.assignforce.config.BeansConfig;
import com.revature.assignforce.service.TrainerService;
import com.revature.assignforce.service.TrainerServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;

public class BeansConfigTest {
	
	@Test
	public void TestTrainerServicObject() {
		BeansConfig beanConfig = new BeansConfig();
		TrainerService TrainerService = beanConfig.trainerService();
		assertNotNull(TrainerService);
		
	}
	
	@Test
	public void TestForqueueMessageHandlerFactory() {
		BeansConfig beanConfig = new BeansConfig();
		QueueMessageHandlerFactory Factory = beanConfig.queueMessageHandlerFactory();
		assertNotNull(Factory);
	}
}
