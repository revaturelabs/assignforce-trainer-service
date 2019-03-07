package com.revature.assignforce.messaging.listeners;

import com.revature.assignforce.beans.SkillIdHolder;

public interface SkillsMessageListener {
    void receive(SkillIdHolder skillMessage);
}
