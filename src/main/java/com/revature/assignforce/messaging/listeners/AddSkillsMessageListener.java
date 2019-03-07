package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.repos.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class AddSkillsMessageListener implements SkillsMessageListener {
    private static final String name = "AddSkillMessageListener";
    private static final Logger LOG = LoggerFactory.getLogger(name);
    private SkillRepository skillRepository;

    @Autowired
    public AddSkillsMessageListener(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    @SqsListener("${app.sqs.queues.add-skill-queue}")
    public void receive(String message, final @NotificationMessage SkillIdHolder skillMessage) throws Exception{
        LOG.info("Received -- " + message);
        LOG.info("Creating new skill id reference -- " + skillMessage.getSkillId());
        skillRepository.delete(skillMessage);
    }
}
