package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.User;
import com.stackdeans.loginregister.payload.response.MessageResponse;
import com.stackdeans.loginregister.repository.PermissionRepository;
import com.stackdeans.loginregister.repository.UserRepository;
import com.stackdeans.loginregister.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

  @Autowired
  UserRepository userRepository;
  @Autowired
  PermissionRepository permissionRepository;

  @Autowired
  PermissionService permissionService;

  @GetMapping("/all")
  @PreAuthorize("hasRole('VENDOR')")
  public String allAccess() {
    return "Vendor content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

//  @GetMapping("/admin")
//  @PreAuthorize("hasRole('ADMIN')")
//  public ResponseEntity<?> adminAccess(HttpServletRequest request) {
//    String username=request.getUserPrincipal().getName();
//    Set<Permission> permissions=  userRepository.findByUsername(username).getPermissions();
//    for (Permission p : permissions){
//
//      if(p.getName().toString().equals("all")){
//
//        return ResponseEntity.ok(new MessageResponse("admin permission and roles is okay!"));
//      }
//      else{
//        return  ResponseEntity
//                .badRequest()
//                .body(new MessageResponse("Error: permission needed!"));
//      }
//    }
//
//    return  ResponseEntity
//            .badRequest()
//            .body(new MessageResponse("Error: permission needed!"));
//
//  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> adminAccess(HttpServletRequest request) {
    User user = permissionService.getTheCurrentUser(request);
    if (permissionService.checkThePermission(user, "no")) {
      return ResponseEntity.ok(new MessageResponse("admin permission and roles is okay!"));
    } else {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: permission needed!"));
    }


  }
}
