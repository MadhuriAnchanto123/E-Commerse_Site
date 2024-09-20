package org.ecommerse.ecommersesite.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ecommerse.ecommersesite.dao.UserRepository;
import org.ecommerse.ecommersesite.dto.UserDTO;
import org.ecommerse.ecommersesite.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {
	
	private ObjectMapper objectMapper;
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository,ObjectMapper objectMapper) {
		this.userRepository = userRepository;
		this.objectMapper=objectMapper;
	}
	
	//covert value from user to userDTO
	public UserDTO getUserDTO(User user)
	{
		return objectMapper.convertValue(user, UserDTO.class);
	}

	public void registerUser(User user)
	{
		 userRepository.save(user);
	}
	
	public List<User> viewUser()
	{
		List<User> users =userRepository.findAll();
		return users;
	}
	
	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
}
