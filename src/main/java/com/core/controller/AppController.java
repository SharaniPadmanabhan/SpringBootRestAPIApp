package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.core.model.User;
import com.core.services.UserService;

@RestController
public class AppController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String hello() {
		return "This is Home page";
	}
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {
		User user = new User(username, firstname, lastname, age, password);
		userService.saveMyUser(user);
		return "User Saved";
	}
}
