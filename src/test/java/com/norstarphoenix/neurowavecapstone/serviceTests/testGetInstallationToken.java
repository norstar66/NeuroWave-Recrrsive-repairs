package com.norstarphoenix.neurowavecapstone.serviceTests;

import com.norstarphoenix.neurowavecapstone.config.GitHubAppJwt;
import com.norstarphoenix.neurowavecapstone.services.GitHubApiService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GitHubApiServiceTest {

    @Test
    void testGetInstallationToken() throws Exception {
        // Mock dependencies
        GitHubAppJwt jwtGenerator = mock(GitHubAppJwt.class);
        RestTemplate restTemplate = mock(RestTemplate.class);

        // Mock JWT generation
        when(jwtGenerator.generateJwt()).thenReturn("mocked_jwt");

        // Mock API response
        String installationId = "123";
        String installationToken = "mocked_token";
        Map<String, String> responseBody = Map.of("token", installationToken);

        ResponseEntity<Map> mockResponse = new ResponseEntity<>(responseBody, HttpStatus.OK);
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(Map.class),
                eq(installationId)
        )).thenReturn(mockResponse);

        // Test the service
        GitHubApiService service = new GitHubApiService(jwtGenerator, restTemplate);
        String token = service.getInstallationToken(installationId);

        // Verify
        assertEquals(installationToken, token);
        verify(jwtGenerator).generateJwt();
        verify(restTemplate).exchange(
                anyString(),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                eq(Map.class),
                eq(installationId)
        );
    }
}