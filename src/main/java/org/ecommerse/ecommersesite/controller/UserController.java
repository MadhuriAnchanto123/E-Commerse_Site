package org.ecommerse.ecommersesite.controller;


import java.util.List;

import org.ecommerse.ecommersesite.dto.UserDTO;
import org.ecommerse.ecommersesite.entity.User;
import org.ecommerse.ecommersesite.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{email}")
	 public UserDTO getUser(@PathVariable String email) {
		User user=userService.findByEmail(email);
		return userService.getUserDTO(user);
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user)
	{
		 userService.registerUser(user);
		 return "User Register successfully";
	}

	@GetMapping("/view")
	public List<User>viewUser()
	{
		return userService.viewUser();
	}
}
