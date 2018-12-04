package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.beans.SkillIdHolder;
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

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "trainer-queue", durable = "true"), exchange = @Exchange(value = "assignforce", ignoreDeclarationExceptions = "true"), key = "assignforce.skill.delete"))
	public void receiveMessage(final Integer skillId, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {

		try {
			logger.info("Received message to delete skill " + skillId);
			channel.basicAck(tag, false);
		} catch (IOException e) {
			logger.warn("Error while processing delete skill message " + skillId);
			e.printStackTrace();
		}

		List<Trainer> trainers = trainerService.getAll();

		trainers.forEach(
				trainer -> trainer.getSkills().removeIf(skillIdHolder -> skillIdHolder.getSkillId() == skillId));

		trainers.forEach(trainer -> trainerService.update(trainer));
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "trainer-queue", durable = "true"), exchange = @Exchange(value = "assignforce", ignoreDeclarationExceptions = "true"), key = "assignforce.skill.deactivate"))
	public void receiveDeactivateMessage(final Integer skillId, Channel channel,
			@Header(AmqpHeaders.DELIVERY_TAG) long tag) {

		try {
			logger.info("Deactivation message received for skill " + skillId);
			channel.basicAck(tag, false);
		} catch (IOException e) {
			logger.warn("Exception will processing deactivation message for skill " + skillId);
			logger.warn(e.getMessage());
		}
	}

	@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "trainer-queue", durable = "true"), exchange = @Exchange(value = "assignforce", ignoreDeclarationExceptions = "true"), key = "assignforce.skill.create"))
	public void receiveCreateMessage(final Integer skillId, Channel channel,
										 @Header(AmqpHeaders.DELIVERY_TAG) long tag) {

		try {
			logger.info("Create message received for skill " + skillId);
			SkillIdHolder skillIdHolder = new SkillIdHolder();
			skillIdHolder.setSkillId(skillId);
			skillRepository.save(skillIdHolder);
			channel.basicAck(tag, false);
		} catch (IOException e) {
			logger.warn("Exception will processing create message for skill " + skillId);
			logger.warn(e.getMessage());
		}
	}
}
