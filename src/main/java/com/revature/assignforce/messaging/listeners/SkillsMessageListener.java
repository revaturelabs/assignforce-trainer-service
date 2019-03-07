package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.beans.SkillIdHolder;

public interface SkillsMessageListener {
    void receive(String message, SkillIdHolder skillMessage) throws Exception;
}
