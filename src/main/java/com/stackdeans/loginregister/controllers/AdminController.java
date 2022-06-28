package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.dto.UserDto;
import com.stackdeans.loginregister.payload.request.SignupRequest;
import com.stackdeans.loginregister.payload.response.MessageResponse;
import com.stackdeans.loginregister.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/create-user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addNewUser(@Valid @RequestBody SignupRequest adminCreateNewUser) {

        return adminService.addNewUser(adminCreateNewUser);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(path = "/add-permission")
    public ResponseEntity<MessageResponse> addPermission(@Valid @RequestBody UserDto userDto) {
        return adminService.addPermission(userDto);
    }
}









