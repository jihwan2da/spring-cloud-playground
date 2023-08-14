package com.msa.user.security.service.jwt;

import com.msa.user.security.jwt.JwtAuthentication;
import com.msa.user.security.jwt.JwtTokenExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JwtServerAuthenticationConverter implements ServerAuthenticationConverter {

    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    private final JwtTokenExtractor jwtTokenExtractor;

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return Mono.just(exchange)
                .flatMap(it -> Mono.just(extractTokenFrom(it)))
                .map(jwtTokenExtractor::extractSub)
                .map(it -> new JwtAuthentication(null, it));
    }

    private String extractTokenFrom(ServerWebExchange exchange) {
        String authorizationHeader = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION);
        validateAuthorizationHeader(authorizationHeader);
        return authorizationHeader.replace(BEARER, "");
    }

    private void validateAuthorizationHeader(String authorizationHeader) {
        validateAuthorizationHeaderBlank(authorizationHeader);
        validateAuthorizationHeaderForm(authorizationHeader);
    }

    private void validateAuthorizationHeaderBlank(String authorizationHeader) {
        if (authorizationHeader == null) {
            throw new RuntimeException();
        }
    }

    private void validateAuthorizationHeaderForm(String authorizationHeader) {
        if (!authorizationHeader.startsWith(BEARER)) {
            throw new RuntimeException();
        }
    }
}
