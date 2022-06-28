package com.stackdeans.loginregister.controllers;

import com.stackdeans.loginregister.models.User;
import com.stackdeans.loginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/all")
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping(value = "/{username}")
	public User get(@PathVariable("username") String username) {
		return userService.get(username);
	}

	@PostMapping(value = "/add")
	public User makeUserProfile(@RequestBody final User user) {
		return userService.persist(user);
	}

	@DeleteMapping(value = "/delete")
	public List<User> delete(@PathVariable String username) {
		return userService.delete(username);
	}
	@PutMapping(value = "/{username}/put")
	public List<User> put(@PathVariable String username, @RequestBody User user) {
		return userService.put(username, user);
	}
}
