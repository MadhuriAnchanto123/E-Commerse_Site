package org.ecommerse.ecommersesite.dto;

public class SellerDTO {
	
	private int id;
	private String email;
	
	public SellerDTO() {
	}
	
	public SellerDTO(int id, String email) {
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
