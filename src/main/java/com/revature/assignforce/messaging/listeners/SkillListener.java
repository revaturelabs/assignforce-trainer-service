package com.revature.assignforce.messaging.listeners;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;

import com.rabbitmq.client.Channel;
import com.revature.assignforce.beans.Trainer;
import com.revature.assignforce.service.TrainerService;

@Component
public class SkillListener {
	private TrainerService trainerService;
	private final String trainerQueue;
	
	public SkillListener(TrainerService trainerService, @Value("${spring.rabbitmq.batch-queue:trainer-queue}") String trainerQueue) {
		super();
		this.trainerService = trainerService;
		this.trainerQueue = trainerQueue;
	}
	
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "trainer-queue", durable = "true"),
			exchange = @Exchange(value = "assignforce", ignoreDeclarationExceptions = "true"),
			key = "assignforce.skill.delete"))
	public void receiveMessage(final Integer skillId, Channel channel, 
			@Header(AmqpHeaders.DELIVERY_TAG) long tag) {
		
		try {
			channel.basicAck(tag, false);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		List<Trainer> trainers = trainerService.getAll();
		
		trainers.forEach(trainer -> trainer.getSkills().removeIf(skillIdHolder -> skillIdHolder.getSkillId() == skillId));
		
		trainers.forEach(trainer -> trainerService.update(trainer));
	}
}
