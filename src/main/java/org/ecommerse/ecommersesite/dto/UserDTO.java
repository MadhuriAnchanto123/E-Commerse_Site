package org.ecommerse.ecommersesite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	
	@JsonProperty("user_id")
	private int id;
	
	@JsonProperty("user_email")
	private String email;
	
	public UserDTO() {
	}
	
	public UserDTO(int id, String email) {
		this.id = id;
		this.email = email;
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
}
