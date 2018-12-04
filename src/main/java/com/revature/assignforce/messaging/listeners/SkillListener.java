package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.beans.SkillMessage;
import com.revature.assignforce.repos.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(SkillListener.class);

	private TrainerService trainerService;
	private SkillRepository skillRepository;
	private final String trainerQueue;

	@Autowired
	public SkillListener(TrainerService trainerService,
			@Value("${spring.rabbitmq.batch-queue:trainer-queue}") String trainerQueue,
						 SkillRepository skillRepository) {
		super();
		this.trainerService = trainerService;
		this.trainerQueue = trainerQueue;
		this.skillRepository = skillRepository;
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "trainer-queue", durable = "true"), exchange = @Exchange(value = "assignforce", ignoreDeclarationExceptions = "true"), key = "assignforce.skill"))
	public void receiveMessage(final SkillMessage skillMessage, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {

		try {
			logger.info(String.format("Received message to %s skill %d", skillMessage.getContext(), skillMessage.getSkillId()));
			channel.basicAck(tag, false);
		} catch (IOException e) {
			logger.warn("Error while processing skill message " + skillMessage.getSkillId());
			e.printStackTrace();
		}
	}
}
