package com.norstarphoenix.neurowavecapstone.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

public class GitHubAppJwt {

    private final String appId;
    private final String privateKeyPem;

    public GitHubAppJwt(String appId, String privateKeyPem) {
        this.appId = appId;
        this.privateKeyPem = privateKeyPem;
    }

    public String generateJwt() throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyPem);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(spec);

        Instant now = Instant.now();
        return Jwts.builder()
                .setIssuer(appId)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(600))) // 10 minutes
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    @Bean
    public GitHubAppJwt gitHubAppJwt() {
        String appId = System.getenv("GITHUB_APP_ID");
        String privateKey = System.getenv("GITHUB_PRIVATE_KEY");
        return new GitHubAppJwt(appId, privateKey);
    }
}
