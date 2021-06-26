package com.danharding.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import javax.validation.Valid;

import java.util.Arrays;
import java.util.List;


@RestController
@EnableWebSecurity
public class UserController extends WebSecurityConfigurerAdapter{
	private static final String SIGN_UP_URL = "/users/register";
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users/register")
	@CrossOrigin(origins = "http://localhost:3000")
	public Status registerUser(@Valid @RequestBody User newUser) {
		List<User> users = userRepository.findAll();
		
		System.out.println("New user: " + newUser.toString());
		
		for (User user : users) {
			System.out.println("Registered user: " +  newUser.toString());
			
			if (user.equals(newUser)) {
				System.out.println("User already exists!");
				return Status.USER_ALREADY_EXISTS;
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
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and()
		.csrf().disable()
		.authorizeRequests().antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
		.anyRequest().authenticated();
		
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.applyPermitDefaultValues();
		corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
}
