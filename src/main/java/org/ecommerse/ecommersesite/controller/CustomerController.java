package org.ecommerse.ecommersesite.controller;

import org.ecommerse.ecommersesite.entity.Customer;
import org.ecommerse.ecommersesite.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/register")
	//public String registerCustomer(@RequestBody Customer customer) {
			public String registerCustomer(@RequestParam("email") String email){
		System.out.println(email);
		Object obj=customerService.registerCustomer(email);
		
		if(obj!=null) {
		return "Customer register successfully";
		}
		else
		{
			return "Please register as user first";
		}
		
	}
	
	

}
