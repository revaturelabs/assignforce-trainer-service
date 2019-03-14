package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.SkillMessage;
import com.revature.assignforce.beans.SkillIdHolder;

public interface SkillsMessageListener {
    void receive(String message) throws Exception;
}
