package org.ecommerse.ecommersesite.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Customer")
public class Customer {

	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	    
	    @OneToOne
	    @JoinColumn(name = "user_id",referencedColumnName = "id")
	    private User user;

	    @Column(unique=true,nullable = false)
	    private String email;

	@OneToOne
	@JoinColumn(name = "cart_id",nullable = false,referencedColumnName = "id")
	private Cart cart;

	    public Customer() {
	    }

	    public Customer(User user, String email) {
	        this.user = user;
	       this.email=email;
	    }

	   

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
		public String toString() {
			return "Customer [id=" + id + ", user=" + user + ", email=" + email + "]";
		}
}
