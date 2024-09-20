package org.ecommerse.ecommersesite.services;

import org.ecommerse.ecommersesite.dao.CartRepository;
import org.ecommerse.ecommersesite.dao.CustomerRepository;
import org.ecommerse.ecommersesite.entity.Cart;
import org.ecommerse.ecommersesite.entity.Customer;
import org.ecommerse.ecommersesite.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	
	CustomerRepository customerRepository;
	UserService userService;
	CartRepository cartRepository;
	
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository, UserService userService,CartRepository cartRepository) {
		super();
		this.customerRepository = customerRepository;
		this.userService = userService;
		this.cartRepository=cartRepository;
	}



	public Customer registerCustomer(String email)
	{
		User user=userService.findByEmail(email);
		System.out.println(user);
		if(user!=null)
		{
			Customer customer=new Customer(user,user.getEmail());
			customer.setUser(user);
			Cart cart=new Cart();

			//customerRepository.save(customer);
			cartRepository.save(cart);
			System.out.println(cart);
			customer.setCart(cart);
			return customerRepository.save(customer);
		}
		else
		{
			return null;
		}
	}

}
