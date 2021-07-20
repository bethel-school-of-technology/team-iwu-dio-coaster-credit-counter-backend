package com.danharding.coastercreditcounter.Controllers;

import com.danharding.coastercreditcounter.Services.DataAccess.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import com.danharding.coastercreditcounter.Constants.Status;
import com.danharding.coastercreditcounter.Models.User;
import com.danharding.coastercreditcounter.Services.MySQLUserDetailsService;

import java.util.List;
import java.util.Optional;


@RestController
@EnableWebSecurity
public class UserController {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	MySQLUserDetailsService mySQLUserDetailsService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {
		Optional<User> userOptional = userDao.findById(userId);
		return userOptional
				.map(u -> updateUserDetails(u, userDetails))
				.map(u -> userDao.save(u))
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
		List<User> users = userDao.findAll();
		
		System.out.println("New user: " + newUser.toString());
		
		for (User user : users) {
			System.out.println("Registered user: " +  newUser.toString());
			
			if (user.equals(newUser)) {
				return Status.FAILURE;
			}
		}
		
		mySQLUserDetailsService.Save(newUser);
			return Status.SUCCESS;
	}
	
	@PostMapping("/users/login")
	public Status loginUser(@Valid @RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		List<User> users = userDao.findAll();
		
		for (User other : users) {
			if (other.getUsername().equals
			(user.getUsername()) && 
			passwordEncoder.matches(user.getPassword(),
			other.getPassword())) {
				user.setLoggedIn(true);
				userDao.save(user);
				return Status.SUCCESS;
			}
		}
		
		return Status.FAILURE;
	}
	
	@PostMapping("/users/logout")
	public Status logUserOut(@Valid @RequestBody User user) {
		List<User> users = userDao.findAll();
		
		for (User other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(false);
				userDao.save(user);
				return Status.SUCCESS;
			}
		}
		
		return Status.FAILURE;
	}
	

}
