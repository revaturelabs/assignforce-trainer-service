package com.revature.assignforce.messaging.messengers;

import javax.inject.Inject;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrainerMessenger {
	private final RabbitTemplate rabbitTemplate;
	
	@Value("${spring.rabbitmq.exchange:assignforce}")
	private String exchange;
	
	@Value("${spring.rabbitmq.trainer-routing-delete:assignforce.trainer.delete")
	private String routingKey;
	
	@Inject
	public TrainerMessenger(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendDeletionMessage(int id) {
		rabbitTemplate.convertAndSend(exchange, routingKey, id);
	}
}
