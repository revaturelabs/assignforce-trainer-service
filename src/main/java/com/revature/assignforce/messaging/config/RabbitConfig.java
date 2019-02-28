package com.revature.assignforce.messaging.config;

//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.RabbitConnectionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.service.messaging.RabbitConnectionFactoryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.jboss.logging.Logger;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

//import java.util.Properties;

@Configuration
public class RabbitConfig {

	Logger log = Logger.getLogger(RabbitConfig.class);

	@Bean
	RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setConfirmCallback( (correlationData, ack, cause) -> {
			if(ack) log.debug("Message confirmed");
			else log.error("Confirmation failure");
		});
		return rabbitTemplate;
	}
	
}
