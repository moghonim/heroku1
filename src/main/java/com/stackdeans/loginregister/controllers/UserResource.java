package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.User;
import com.stackdeans.loginregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/{username}")
	public User get(@PathVariable("username") String username) {
		return userRepository.findByUsername(username);
	}

	@PostMapping(value = "/add")
	public User persist(@RequestBody final User user) {
		userRepository.save(user);
		return userRepository.getById(user.getId());
	}

	@DeleteMapping(value = "/delete")
	public List<User> delete(@PathVariable String username) {
		userRepository.deleteByUsername(username);
		return userRepository.findAll();
	}

	@PutMapping(value = "/{username}/put")
	public List<User> put(@PathVariable String username, @RequestBody User user) {
		if (userRepository.existsByUsername(username)) {
			userRepository.deleteByUsername(username);
			userRepository.save(user);
		}

		return userRepository.findAll();
	}
}
