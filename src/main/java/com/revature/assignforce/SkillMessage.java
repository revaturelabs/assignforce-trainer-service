package com.revature.assignforce;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SkillMessage {
    private int skillId;

    public SkillMessage() {
        super();
    }

    @JsonCreator
    public SkillMessage(@JsonProperty("Message") String message) throws IOException {
        SkillMessage s = new ObjectMapper().readValue(message, SkillMessage.class);
        this.skillId = s.getSkillId();
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
