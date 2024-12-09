package com.norstarphoenix.neurowavecapstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public GitHubAppJwt gitHubAppJwt() {
        String appId = "your_app_id"; // Replace with your actual app ID
        String privateKey = "your_private_key"; // Replace with your actual private key
        return new GitHubAppJwt(appId, privateKey);
    }
}