package com.revature.assignforce.config;

import com.revature.assignforce.service.TrainerService;
import com.revature.assignforce.service.TrainerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public TrainerService trainerService() {
        return new TrainerServiceImpl();
    }
}
