package com.norstarphoenix.neurowavecapstone.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GitHubAuthController {

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getUserDetails(
            @AuthenticationPrincipal OAuth2User oAuth2User) {
        return ResponseEntity.ok(oAuth2User.getAttributes()); // Return user details
    }

    @GetMapping("/codespaces")
    public ResponseEntity<Object> getUserCodespaces(
            @RegisteredOAuth2AuthorizedClient("github") OAuth2AuthorizedClient authorizedClient) {

        // Access token for GitHub API
        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        // Fetch codespaces data from GitHub API
        Map<String, Object> codespaces = fetchGitHubCodespaces(accessToken);
        return ResponseEntity.ok(codespaces);
    }

    private Map<String, Object> fetchGitHubCodespaces(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/user/codespaces";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);
        return response.getBody();
    }
}