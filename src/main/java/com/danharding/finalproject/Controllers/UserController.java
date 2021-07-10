package com.danharding.finalproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.danharding.finalproject.Constants.Status;
import com.danharding.finalproject.Models.User;
import com.danharding.finalproject.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@RestController
@EnableWebSecurity
public class UserController{
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
		Optional<User> userOptional = userRepository.findById(userId);
		return userOptional
				.map(u -> updateUserDetails(u, userDetails))
				.map(u -> userRepository.save(u))
				.orElse(null);

		
	}

	private User updateUserDetails(User user, User userDetails) {
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUsername(userDetails.getUsername());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());

		return user;
	} 
	
	@PostMapping("/users/register")
	public Status registerUser(@Valid @RequestBody User newUser) {
		List<User> users = userRepository.findAll();
		
		System.out.println("New user: " + newUser.toString());
		
		for (User user : users) {
			System.out.println("Registered user: " +  newUser.toString());
			
			if (user.equals(newUser)) {
				return Status.FAILURE;
			}
		}
		
		userRepository.save(newUser);
			return Status.SUCCESS;
	}
	
	@PostMapping("/users/login")
	public Status loginUser(@Valid @RequestBody User user) {
		List<User> users = userRepository.findAll();
		
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(true);
				userRepository.save(user);
				return Status.SUCCESS;
			}
		}
		
		return Status.FAILURE;
	}
	
	@PostMapping("/users/logout")
	public Status logUserOut(@Valid @RequestBody User user) {
		List<User> users = userRepository.findAll();
		
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(false);
				userRepository.save(user);
				return Status.SUCCESS;
			}
		}
		
		return Status.FAILURE;
	}
	
	@DeleteMapping("users/all")
	public Status deleteUsers() {
		userRepository.deleteAll();
		return Status.SUCCESS;
	}
}
