package com.norstarphoenix.neurowavecapstone.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import com.norstarphoenix.neurowavecapstone.config.GitHubAppJwt;

import java.util.Map;

@Service
public class GitHubApiService {

    private final GitHubAppJwt jwtGenerator;
    private final RestTemplate restTemplate;
    private static final String INSTALLATION_TOKEN_URL = "https://api.github.com/app/installations/{installation_id}/access_tokens";

    public GitHubApiService(GitHubAppJwt jwtGenerator, RestTemplate restTemplate) {
        this.jwtGenerator = jwtGenerator;
        this.restTemplate = restTemplate;
    }

    public String getInstallationToken(String installationId) throws Exception {
        try {
            String jwt = jwtGenerator.generateJwt();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + jwt);
            headers.set("Accept", "application/vnd.github+json");

            HttpEntity<Void> request = new HttpEntity<>(headers);
            ResponseEntity<Map> response = restTemplate.exchange(
                    INSTALLATION_TOKEN_URL,
                    HttpMethod.POST,
                    request,
                    Map.class,
                    installationId
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                return (String) response.getBody().get("token");
            } else {
                throw new RuntimeException("Failed to fetch token: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during API call", e);
        }
    }
}