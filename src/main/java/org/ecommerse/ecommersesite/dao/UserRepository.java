package org.ecommerse.ecommersesite.dao;


import java.util.Optional;

import org.ecommerse.ecommersesite.dto.UserDTO;
import org.ecommerse.ecommersesite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email); 
}
