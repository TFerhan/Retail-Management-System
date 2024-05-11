package com.inventorymanagementsystem.entity;

public class Product {
    private int id;
    private int quantity;
    private double price;
    private String nom;

    public Product(int id,String nom,int quantity, double price) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}
