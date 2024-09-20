package org.ecommerse.ecommersesite.controller;

import org.ecommerse.ecommersesite.entity.Product;
import org.ecommerse.ecommersesite.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{Cid}/{Pid}/{quantity}")
    public String addProductToCart(@PathVariable int Cid,@PathVariable int Pid, @PathVariable int quantity)
    {
        boolean b=cartService.addProductToCart(Cid,Pid,quantity);
        if (b)
        {
            return "product added to cart";
        }
        else
        {
            return "product faild to add";
        }
    }

    @GetMapping("/view/{Cid}")
    public List<Product> viewCartProduct(@PathVariable int Cid)
    {
        return cartService.viewCartProduct(Cid);
    }

    @DeleteMapping("/delete/{Cid}/{Pid}")
    public String deleteCartProduct(@PathVariable int Cid,@PathVariable int Pid)
    {
        boolean b=cartService.deleteProductFromCart(Cid, Pid);
        if (b)
        {
            return "product deleted from cart";
        }
        else {
            return "product not deleted";
        }
    }
}
