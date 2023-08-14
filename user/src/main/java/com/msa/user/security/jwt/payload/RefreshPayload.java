package com.msa.user.security.jwt.payload;

import com.msa.user.security.jwt.type.TokenType;
import lombok.Getter;

import java.util.Map;

import static com.msa.user.security.jwt.constant.Constant.ACCESS_TOKEN;


@Getter
public class RefreshPayload extends Payload {

    private final String accessToken;

    protected RefreshPayload(String sub, String accessToken) {
        super(sub, TokenType.REFRESH);
        this.accessToken = accessToken;
    }

    public static RefreshPayload of(String sub, String accessToken) {
        return new RefreshPayload(sub, accessToken);
    }

    @Override
    public Map<String, Object> createClaims() {
        Map<String, Object> claims = super.createClaims();
        claims.put(ACCESS_TOKEN, this.accessToken);
        return claims;
    }

    public void validate(String accessToken) {
        if (!this.accessToken.equals(accessToken)) {
            throw new RuntimeException();
        }
    }
}
