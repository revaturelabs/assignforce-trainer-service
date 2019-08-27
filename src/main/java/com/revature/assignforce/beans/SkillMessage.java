package com.revature.assignforce.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkillMessage {
    private String context;
    @JsonProperty(value="skillId")
    private int id;

    public SkillMessage() {
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
