package com.msa.user.presentation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user-service")
public class UserApi {

    @GetMapping("/health_check")
    public Mono<String> healthCheck(HttpServletRequest request) {
        return Mono.just(String.format("It's Working in User Service on Port %s", request.getServerPort()));
    }
}
