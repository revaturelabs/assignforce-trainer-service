package com.revature.assignforce.service;

import com.revature.assignforce.beans.SkillIdHolder;

public interface SkillsMessageListener {
    void receive(SkillIdHolder skillMessage);
}
