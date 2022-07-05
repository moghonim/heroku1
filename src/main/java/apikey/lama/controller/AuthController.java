package apikey.lama.controller;

import apikey.lama.dto.LoginRequest;
import apikey.lama.dto.SignupRequest;
import apikey.lama.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    AuthService authService;


  @PostMapping("/token")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
     return  authService.authenticateUser(loginRequest);
  }

    @PostMapping("/register")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signUpRequest) {
        return authService.register(signUpRequest);
    }

    @GetMapping("/netty")
    public String getData(){
        return "daojuhd";
    }
}
