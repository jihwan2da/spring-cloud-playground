package com.msa.user.users.presentation;

import com.msa.user.users.application.UserService;
import com.msa.user.users.presentation.dto.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static com.msa.user.users.presentation.dto.UserRequest.*;
import static com.msa.user.users.presentation.dto.UserResponse.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service/api/v1/users")
public class UserApi {

    private final UserService userService;

    @GetMapping("/health_check")
    public Mono<String> healthCheck(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();
        return Mono.just(String.format("It's Working in User Service on Port %s", request.getURI().getPort()));
    }

    @PostMapping("/signup")
    public Mono<ResponseEntity<UserInfo>> signUp(@RequestBody Mono<SignUp> request) {
        return userService.signUp(request);
    }
}
