package com.stackdeans.loginregister.controller;

import com.stackdeans.loginregister.dto.LoginRequest;
import com.stackdeans.loginregister.dto.SignupRequest;
import com.stackdeans.loginregister.service.Dao;
import com.stackdeans.loginregister.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"*"}, maxAge = 3600, allowCredentials="false")
public class NonSecureController {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureController.class);
//    @Autowired
//    Dao dao;
    @Autowired
    DataService dataService;

    @PostMapping(value = "/api/token")
//    @ResponseStatus(HttpStatus.CREATED)
//    @CrossOrigin(methods = { RequestMethod.POST },
//            allowedHeaders = { "Access-Control-Request-Method" },
//            exposedHeaders = { "Access-Control-Request-Headers" }
//    )
//    @CrossOrigin(origins = "http://localhost:3002")
    public ResponseEntity<?> nonsecure(@Valid @RequestBody LoginRequest loginRequest) {
        return  dataService.getData(loginRequest);
    }

    @PostMapping(value = "/api/v1/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
//        dao.addNewUser(signupRequest);
        return ResponseEntity.ok(signupRequest);
    }
}