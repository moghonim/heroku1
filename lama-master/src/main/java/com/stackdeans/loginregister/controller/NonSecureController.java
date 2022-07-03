package com.stackdeans.loginregister.controller;


import com.stackdeans.loginregister.dto.LoginRequest;
import com.stackdeans.loginregister.dto.SignupRequest;
import com.stackdeans.loginregister.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class NonSecureController {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureController.class);

    @Autowired
    DataService dataService;
    @PostMapping(value = "/api/token")
    public Mono<ResponseEntity<?>> nonsecure(@RequestBody LoginRequest loginRequest) {

     return   dataService.getData(loginRequest);

    }

    @PostMapping(value = "/api/v1/signup")
    public Mono<ResponseEntity<?>> signup(@RequestBody SignupRequest signupRequest) {

        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setEmail("1212");
        loginRequest.setPassword("asdasda");
        return Mono.fromSupplier(() -> {
            LOG.info("Received request: /api/v1/nonsecure");


            return ResponseEntity.ok(loginRequest);
        });
    }
}