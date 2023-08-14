package com.msa.user.security.jwt.payload.factory;

import com.msa.user.security.jwt.payload.Payload;
import com.msa.user.security.jwt.payload.RefreshPayload;
import io.jsonwebtoken.Claims;

import static com.msa.user.security.jwt.constant.Constant.ACCESS_TOKEN;
import static com.msa.user.security.jwt.constant.Constant.SUB;


public class RefreshPayloadFactory extends PayloadFactory {
    @Override
    public Payload createPayload(Claims claims) {
        String sub = claims.get(SUB, String.class);
        String accessToken = claims.get(ACCESS_TOKEN, String.class);
        return RefreshPayload.of(sub, accessToken);
    }
}
