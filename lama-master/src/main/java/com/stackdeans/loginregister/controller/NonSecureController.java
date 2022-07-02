package com.stackdeans.loginregister.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class NonSecureController {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureController.class);

    @GetMapping(value = "/api/v1/nonsecure")
    public Mono<ResponseEntity<?>> nonsecure() {
        return Mono.fromSupplier(() -> {
            LOG.info("Received request: /api/v1/nonsecure");
            return ResponseEntity.ok().build();
        });
    }
}