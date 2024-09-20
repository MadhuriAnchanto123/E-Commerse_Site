package org.ecommerse.ecommersesite.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "User")
public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(unique=true, nullable=false)
	    private String userName;

	    @Column(unique=true, nullable=false)
	    private String email;

	    public User() {
	    }

	    public User(String userName, String password, String email) {
	        this.userName = userName;
	        this.email = email;
	       
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    @Override
	    public String toString() {
	        return "UserEntity{" +
	                "id=" + id +
	                ", userName='" + userName + '\'' +
	                ", email='" + email + '\'' +
	                '}';
	    }

}
