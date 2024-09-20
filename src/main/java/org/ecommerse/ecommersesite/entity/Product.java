package org.ecommerse.ecommersesite.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column//(nullable = false,columnDefinition = "varchar (255) default 'DEFAULT'")
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private Seller seller;

    public Product() {
    }

    public Product(int id, String name, int price, int quantity, Seller seller) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
