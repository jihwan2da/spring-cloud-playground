package com.msa.user.security.jwt;

import com.msa.user.security.jwt.payload.Payload;
import com.msa.user.security.jwt.payload.factory.AccessPayloadFactory;
import com.msa.user.security.jwt.payload.factory.PayloadFactory;
import com.msa.user.security.jwt.payload.factory.RefreshPayloadFactory;
import com.msa.user.security.jwt.type.TokenType;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.msa.user.security.jwt.constant.Constant.TYPE;

@Component
@RequiredArgsConstructor
public class JwtTokenExtractor {

    private final JwtTokenProperties jwtTokenProperties;

    public String extractSub(String token) {
        Payload payload = extractPayload(token);
        return payload.getSub();
    }

    public Payload extractPayload(String token) {
        Claims claims = getClaims(token);

        TokenType type = TokenType.valueOf(claims.get(TYPE, String.class));
        PayloadFactory payloadFactory = getPayloadFactory(type);
        return payloadFactory.createPayload(claims);
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtTokenProperties.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private PayloadFactory getPayloadFactory(TokenType type) {
        if (type.isAccess()) {
            return new AccessPayloadFactory();
        } else if (type.isRefresh()) {
            return new RefreshPayloadFactory();
        } else {
            throw new RuntimeException("TOKEN TYPE INVALID");
        }
    }
}
