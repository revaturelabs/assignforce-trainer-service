package com.revature.assignforce.messaging.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.assignforce.beans.SkillMessage;

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

import java.util.Map;

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
    public void receive(String message) throws Exception{
        LOG.info("Received -- " + message);
        Map<String, String> messageMap = new ObjectMapper().readValue(message, Map.class);
        SkillMessage sm = new ObjectMapper().readValue(messageMap.get("Message"), SkillMessage.class);
        SkillIdHolder s = new SkillIdHolder(sm.getId());
        skillRepository.save(s);
    }
}
