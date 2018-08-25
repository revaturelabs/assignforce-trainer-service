package com.revature.assignforce.messaging.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.jboss.logging.Logger;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitConfig {

	@Value("${VCAP_SERVICES:{}}")
	String uri;
	
	Logger log = Logger.getLogger(RabbitConfig.class);

	@Bean
	RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setConfirmCallback( (correlationData, ack, cause) -> {
			if(ack) log.debug("Message confirmed");
			else log.error("Confirmation failure");
		});
		System.out.println(uri);
		return rabbitTemplate;
	}
}
