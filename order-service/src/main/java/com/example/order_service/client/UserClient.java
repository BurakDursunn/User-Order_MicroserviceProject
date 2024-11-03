package com.example.order_service.client;

import com.example.user_service.model.User; // Modeli doğru bir şekilde import ettiğinizden emin olun
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service") // Bu anotasyonun doğru olduğundan emin olun
public interface UserClient {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);
}
