package com.msa.orders.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class OrderApi {

    @GetMapping("/health_check")
    public String healthCheck(HttpServletRequest request) {
        return String.format("It's Working in Order Service on Port %s", request.getServerPort());
    }
}
