package com.inventorymanagementsystem.entity;

public class Livraison {
	private int id;
	private String date;
	private String num_facture;
	
	public Livraison(int id, String date, String num_facture) {
		this.id = id;
		this.date = date;
		this.num_facture = num_facture;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getNum_facture() {
		return num_facture;
	}
	
	public void setNum_facture(String num_facture) {
		this.num_facture = num_facture;
	}
	
	

}
