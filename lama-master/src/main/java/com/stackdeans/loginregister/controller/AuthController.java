package com.stackdeans.loginregister.controller;

import com.stackdeans.loginregister.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
  @PostMapping("/auth")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        return authService.authenticateUser(loginRequest);
        return ResponseEntity.ok("it is very good");
  }

//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signUpRequest) {
//        return authService.signupUser(signUpRequest);
//    }

}
