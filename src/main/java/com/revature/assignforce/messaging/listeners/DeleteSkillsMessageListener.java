package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.SkillMessage;
import com.revature.assignforce.beans.SkillIdHolder;
import com.revature.assignforce.repos.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
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
    @SqsListener(value="${app.sqs.queues.del-skill-queue}", deletionPolicy= SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message) throws Exception{
//        LOG.info("Delete skill id reference -- " + skillMessage.getSkillId());
//        SkillIdHolder s = new SkillIdHolder(skillMessage.getSkillId());
//        skillRepository.delete(s);
    }
}
