package com.msa.product.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-service")
public class ProductApi {

    @GetMapping("/health_check")
    public String healthCheck(HttpServletRequest request) {
        return String.format("It's Working in Product Service on Port %s", request.getServerPort());
    }
}
