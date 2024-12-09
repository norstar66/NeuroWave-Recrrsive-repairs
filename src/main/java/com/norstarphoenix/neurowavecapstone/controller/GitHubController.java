package com.norstarphoenix.neurowavecapstone.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.norstarphoenix.neurowavecapstone.services.GitHubApiService;

@RestController
@RequestMapping("/api/github")
public class GitHubController {

    private final GitHubApiService gitHubApiService;

    public GitHubController(GitHubApiService gitHubApiService) {
        this.gitHubApiService = gitHubApiService;
    }

    @GetMapping("/installation-token/{installationId}")
    public ResponseEntity<String> getInstallationToken(@PathVariable String installationId) {
        try {
            String token = gitHubApiService.getInstallationToken(installationId);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching installation token: " + e.getMessage());
        }
    }
}