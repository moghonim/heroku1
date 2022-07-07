package apikey.lama.controller;

import apikey.lama.dto.LoginRequest;
import apikey.lama.dto.SignupRequest;
import apikey.lama.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = {"*"}, maxAge = 3600, allowCredentials="false")
public class NonSecureController {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureController.class);
//    @Autowired
//    Dao dao;
//    @CrossOrigin(methods = { RequestMethod.POST },
//            allowedHeaders = { "Access-Control-Request-Method" },
//            exposedHeaders = { "Access-Control-Request-Headers" }
//    )
    @Autowired
DataService dataService;

    @PostMapping(value = "/token")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<?> nonsecure(@Valid @RequestBody LoginRequest loginRequest) {
        return  dataService.getData(loginRequest);
    }

    @PostMapping(value = "/api/v1/signup1")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(signupRequest);
    }
}