package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.dto.UserDto;
import com.stackdeans.loginregister.models.ERole;
import com.stackdeans.loginregister.models.Role;
import com.stackdeans.loginregister.models.User;
import com.stackdeans.loginregister.payload.request.SignupRequest;
import com.stackdeans.loginregister.payload.response.MessageResponse;
import com.stackdeans.loginregister.repository.RoleRepository;
import com.stackdeans.loginregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;


    @PostMapping(value = "/create-user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody SignupRequest adminCreateNewUser) {
        if (userRepository.existsByUsername(adminCreateNewUser.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(adminCreateNewUser.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(adminCreateNewUser.getUsername(),
                adminCreateNewUser.getEmail(),
                encoder.encode(adminCreateNewUser.getPassword()));

        Set<String> strRoles = adminCreateNewUser.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);


                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    //in the request body
                    case "vendor":
                        Role vendorRole = roleRepository.findByName(ERole.ROLE_VENDOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(vendorRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });

        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User created successfully!"));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/add-permission")
    public ResponseEntity<MessageResponse> addPermission(@Valid @RequestBody UserDto userDto) {


        if (!userRepository.existsByUsername(userDto.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is not found in database!"));
        }


        User user = userRepository.findByUsername(userDto.getUsername());
        Set<String> strRoles = userDto.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
//            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
            throw new RuntimeException("Error: Role is not found please insert roles.");
//            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);


                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    case "vendor":
                        Role vendorRole = roleRepository.findByName(ERole.ROLE_VENDOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(vendorRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });

        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User permissions updated successfully!"));
    }


}









