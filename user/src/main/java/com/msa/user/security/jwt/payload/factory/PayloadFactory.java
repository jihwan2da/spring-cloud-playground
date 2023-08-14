package com.msa.user.security.jwt.payload.factory;

import com.msa.user.security.jwt.payload.Payload;
import io.jsonwebtoken.Claims;

public abstract class PayloadFactory {

    abstract public Payload createPayload(Claims claims);
}
