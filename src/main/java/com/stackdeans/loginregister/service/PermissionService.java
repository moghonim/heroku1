package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Permission;
import com.stackdeans.loginregister.models.User;
import com.stackdeans.loginregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Service
public class PermissionService {
    @Autowired
    UserRepository userRepository;


    public User getTheCurrentUser(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        return userRepository.findByUsername(username);
    }

    public boolean checkThePermission(User user, String permission) {
        Set<Permission> permissions = userRepository.findByUsername(user.getUsername()).getPermissions();
        for (Permission p : permissions) {

            //                return ResponseEntity.ok(new MessageResponse("permissions and roles is okay!"));
            //                return ResponseEntity
            //                        .badRequest()
            //                        .body(new MessageResponse("Error: permissions and roles is not okay!"));
            return p.getName().toString().equals(permission);

        }
        return false;
    }

}
