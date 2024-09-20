package org.ecommerse.ecommersesite.dao;

import org.ecommerse.ecommersesite.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
