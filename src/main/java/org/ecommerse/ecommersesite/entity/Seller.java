package org.ecommerse.ecommersesite.entity;

import org.ecommerse.ecommersesite.dto.UserDTO;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Table(name="Seller")
public class Seller {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    @Column( unique=true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "seller",cascade={CascadeType.ALL},orphanRemoval= true,fetch = FetchType.LAZY)
    private List<Product> products=new ArrayList<>(0);

    public Seller() {
    }

    public Seller(User user2,String email) {
    	 this.user = user2;
        this.email =email;
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

	@Override
	public String toString() {
		return "Seller [id=" + id + ", user=" + user + ", email=" + email + "]";
	} 
}
