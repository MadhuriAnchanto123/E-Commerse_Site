package org.ecommerse.ecommersesite.dao;

import org.ecommerse.ecommersesite.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
	


}
