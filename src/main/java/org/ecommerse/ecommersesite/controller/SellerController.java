package org.ecommerse.ecommersesite.controller;

import org.ecommerse.ecommersesite.entity.Seller;
import org.ecommerse.ecommersesite.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@PostMapping("/register")
	public String registerSeller(@RequestBody Seller seller)
	{
		Object obj=sellerService.registerSeller(seller.getEmail());
		
		if(obj!=null)
		{
			return "Seller Register successfully";
		}
		else
		{
			return "Please register as user first";
		}
	}
}
