package apikey.lama.service;

import apikey.lama.dto.LoginRequest;
import apikey.lama.dto.LoginResponse;
import apikey.lama.dto.SignupRequest;
import apikey.lama.models.Auth;
import apikey.lama.models.CustomUser;
import apikey.lama.repository.AuthRepository;
import apikey.lama.repository.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private AuthRepository authRepository;
    private CustomUserRepository customUserRepository;
    private PasswordEncoder encoder;
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        if(checkEmailExists(loginRequest.getEmail())&& checkPasswordIsValid(loginRequest.getPassword(), loginRequest.getEmail())){
            LoginResponse res=new LoginResponse();
            Auth auth=authRepository.findByEmail(loginRequest.getEmail()).map(auth2 -> {
                        Auth auth1=new Auth();
                        auth1.setApi_key(auth2.getApi_key());
                        auth1.setUser_id(auth2.getUser_id());
                        auth1.setAuthorities(auth2.getAuthorities());
                        return auth1;
            }).block();
            ArrayList<String> authorities=new ArrayList<>();
            res.setToken(auth.getApi_key());
            Arrays.stream(auth.getAuthorities().split(","))
                    .map(regex -> authorities.add(regex))
                    .collect(Collectors.toList());
            res.setPermissions(authorities);
            return ResponseEntity.ok(res);
        }else return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<?> register(SignupRequest signUpRequest) {
        if (checkEmailExists(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest().body("ERROR : this Email is already in use!");
        }

        if (checkUsernameExistes(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("ERROR : this Username is already in use!");
        }

        // Create new user's account
        CustomUser user = new CustomUser(signUpRequest.getUsername(), signUpRequest.getEmail(),
                signUpRequest.getPassword(), signUpRequest.getAutherities());
        customUserRepository.save(user);

        Auth auth=new Auth(user.getId(), generateApiKey(),user.getUsername(),user.getAuths());
        authRepository.save(auth);
        return ResponseEntity.ok(user);
    }
    public Boolean checkEmailExists(String email){
       return customUserRepository.findByEmail(email).map(emailSample->{
            if( emailSample.getEmail().equals(email)){
                return true;
            }else return false;
        }).block();
    }
    public boolean checkUsernameExistes(String usernaem){
        return customUserRepository.findByUsername(usernaem).map(emailSample->{
            if( emailSample.getUsername().equals(usernaem)){
                return true;
            }else return false;
        }).block();
    }
    public boolean checkPasswordIsValid(String password,String email){
            return customUserRepository.findByEmail(email).map(emailSample->{
            if( emailSample.getPassword().equals(password)){
                return true;
            }else return false;
        }).block();
    }

    public String generateApiKey() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }


}
