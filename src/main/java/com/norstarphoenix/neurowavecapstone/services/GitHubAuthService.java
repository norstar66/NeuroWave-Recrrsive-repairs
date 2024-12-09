package com.norstarphoenix.neurowavecapstone.services;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class GitHubAuthService {

    @Autowired
    private RestTemplate restTemplate;

    public String exchangeCodeForToken(String code) {
        String url = "https://github.com/login/oauth/access_token";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", System.getenv("GITHUB_CLIENT_ID"));
        body.add("client_secret", System.getenv("GITHUB_CLIENT_SECRET"));
        body.add("code", code);
        body.add("redirect_uri", "http://localhost:8080/auth/github/callback");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        String accessToken = (String) response.getBody().get("access_token");
        if (accessToken == null) {
            throw new RuntimeException("Failed to retrieve access token");
        }
        return accessToken;
    }
}