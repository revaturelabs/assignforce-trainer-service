package com.revature.assignforce.service;

import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.repos.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class DeleteSkillsMessageListener implements SkillsMessageListener {
    private static final String name = "DeleteSkillMessageListener";
    private static final Logger LOG = LoggerFactory.getLogger(name);
    private SkillRepository skillRepository;

    @Autowired
    public DeleteSkillsMessageListener(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    @SqsListener("${app.sqs.queues.del-skill-queue}")
    public void receive(SkillIdHolder skillMessage) {
        LOG.info("Creating new skill id reference -- " + skillMessage.getSkillId());
        skillRepository.delete(skillMessage);
    }
}
