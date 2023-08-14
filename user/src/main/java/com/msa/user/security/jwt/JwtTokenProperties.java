package com.msa.user.security.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@ConfigurationProperties(prefix = "jwt")
@Getter
public class JwtTokenProperties {
    private final Key key;

    public JwtTokenProperties(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }
}
