package org.ecommerse.ecommersesite.services;

import org.ecommerse.ecommersesite.dao.CartRepository;
import org.ecommerse.ecommersesite.dao.CustomerRepository;
import org.ecommerse.ecommersesite.dao.ProductRepository;
import org.ecommerse.ecommersesite.entity.Cart;
import org.ecommerse.ecommersesite.entity.Customer;
import org.ecommerse.ecommersesite.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public boolean addProductToCart(int Cid,int Pid,int quantity)
    {
        //check customer
        Customer customer=customerRepository.findById(Cid).orElseThrow();

        //fetch cart associated with customer
        Cart cart= customer.getCart();

        //fetch product  to add
        Product product=productRepository.findById(Pid).orElseThrow();

        //check if product already present
        if(cart.getProducts().containsKey(product))
        {
            int preQty=cart.getProducts().get(product);
            cart.getProducts().put(product,preQty+quantity);
        }
        else
        {
            cart.getProducts().put(product,quantity);
        }
        cartRepository.save(cart);
        return true;
    }

    public List<Product> viewCartProduct(int Cid)
    {
        Customer customer=customerRepository.findById(Cid).orElseThrow();
        Cart cart=customer.getCart();
        if (cart==null)
        {
           throw new RuntimeException("product not found");
        }

        List<Product> product =new ArrayList<>();
        for(Map.Entry<Product,Integer> entry:cart.getProducts().entrySet())
        {
            Product product1=entry.getKey();
           // int quantity=entry.getValue();
            product1.setQuantity(entry.getValue());
            product.add(product1);

        }
        return product;
    }

    public boolean deleteProductFromCart(int Cid,int Pid)
    {
        Customer customer=customerRepository.findById(Cid).orElseThrow();
        Cart cart=customer.getCart();
        if (cart==null)
        {
            throw new RuntimeException("cart not present");
        }

        Product removeProduct=productRepository.findById(Pid).orElseThrow();

        if (cart.getProducts().containsKey(removeProduct))
        {
            cart.getProducts().remove(removeProduct);
            cartRepository.save(cart);
            return true;
        }
        else
        {
            throw new RuntimeException("product not found in cart");
        }

    }
}
