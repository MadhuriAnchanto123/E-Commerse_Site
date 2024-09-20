package org.ecommerse.ecommersesite.dao;

import org.ecommerse.ecommersesite.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
