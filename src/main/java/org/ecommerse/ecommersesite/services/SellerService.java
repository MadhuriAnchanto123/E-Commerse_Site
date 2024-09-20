package org.ecommerse.ecommersesite.services;

import java.util.Optional;

import org.ecommerse.ecommersesite.dao.SellerRepository;
import org.ecommerse.ecommersesite.dto.UserDTO;
import org.ecommerse.ecommersesite.entity.Seller;
import org.ecommerse.ecommersesite.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
	
	
	SellerRepository sellerRepository;
	
	UserService userService;

	@Autowired
	public SellerService(SellerRepository sellerRepository,	UserService userService) {
		this.sellerRepository = sellerRepository;
		this.userService= userService;
	}
	
	public Seller registerSeller(String email)
	{
		User user=userService.findByEmail(email);
		
		if(user!=null) {
			Seller seller=new Seller(user,user.getEmail());
            return  sellerRepository.save(seller);
         
		}
		else
		{
			return null;
		}
	}
}
