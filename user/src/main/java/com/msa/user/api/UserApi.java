package com.msa.user.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserApi {

    @GetMapping("/health_check")
    public String healthCheck(HttpServletRequest request) {
        return String.format("It's Working in User Service on Port %s", request.getServerPort());
    }
}
