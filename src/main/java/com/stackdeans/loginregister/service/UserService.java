package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.ERole;
import com.stackdeans.loginregister.models.Role;
import com.stackdeans.loginregister.models.User;
import com.stackdeans.loginregister.repository.RoleRepository;
import com.stackdeans.loginregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User get(String username) {
        return userRepository.findByUsername(username);
    }

    public User persist(final User user) {
        Role role = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
        return userRepository.getById(user.getId());
    }

    public List<User> delete(String username) {
        userRepository.deleteByUsername(username);
        return userRepository.findAll();
    }

    public List<User> put(String username, User user) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
            userRepository.save(user);
        }
        return userRepository.findAll();
    }
}
