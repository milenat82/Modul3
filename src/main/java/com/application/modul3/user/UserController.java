package com.application.modul3.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // face ca acest controller sa fie primul nivel din schema noastra si sa stie ca
				// frontend-ul va comunica cu acest prim nivel
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/list")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
	}
}