package org.ecommerse.ecommersesite.controller;

import org.ecommerse.ecommersesite.entity.Product;
import org.ecommerse.ecommersesite.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public String  createProduct(@RequestBody Product product)
    {
        boolean b=productService.createProduct(product);
        if(b)
        {
            return "product created successfully";
        }
        else
        {
            return "seller not valid";
        }
    }

    @DeleteMapping("/delete/{Pid}/{Sid}")
    public  String deleteProduct(@PathVariable int Pid ,@PathVariable int Sid)
    {
       boolean b= productService.deleteProduct(Pid,Sid);
       if (b)
       {
           return "product deleted";
       }
       else {
           return "not authorized to delete product";
       }
    }
}
