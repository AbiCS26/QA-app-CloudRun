package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BackendApplication {
    public static void main(String[] args) {
        System.out.println("Listening on port: " + System.getenv("PORT"));
        SpringApplication.run(BackendApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Hello from Java backend!";
    }
}
