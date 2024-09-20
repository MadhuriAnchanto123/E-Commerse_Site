package org.ecommerse.ecommersesite.services;

import org.ecommerse.ecommersesite.dao.ProductRepository;
import org.ecommerse.ecommersesite.dao.SellerRepository;
import org.ecommerse.ecommersesite.entity.Product;
import org.ecommerse.ecommersesite.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private SellerRepository sellerRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,SellerRepository sellerRepository) {
        this.productRepository = productRepository;
        this.sellerRepository=sellerRepository;
    }

    public boolean createProduct(Product product)
    {
        Seller seller=sellerRepository.findById(product.getSeller().getId()).orElseThrow( RuntimeException::new);
        product.setSeller(seller);
        productRepository.save(product);

        return true;
    }

    public boolean deleteProduct(int Pid,int Sid)
    {
       Product product=productRepository.findById(Pid).orElseThrow();
       if(product.getSeller().getId()==Sid)
       {
           productRepository.delete(product);
           return true;
       }
       else {
           return false;
       }
    }
}
