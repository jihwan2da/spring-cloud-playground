package com.msa.user.security.jwt.payload.factory;

import com.msa.user.security.jwt.payload.AccessPayload;
import com.msa.user.security.jwt.payload.Payload;
import io.jsonwebtoken.Claims;

import static com.msa.user.security.jwt.constant.Constant.SUB;

public class AccessPayloadFactory extends PayloadFactory {
    @Override
    public Payload createPayload(Claims claims) {
        String sub = claims.get(SUB, String.class);
        return AccessPayload.of(sub);
    }
}
