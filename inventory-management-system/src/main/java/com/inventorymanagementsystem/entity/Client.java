package com.inventorymanagementsystem.entity;

public class Client {
    private int id;
    private String nom;
    private String telephone;
    private String adresse;
    private String prenom;

    public Client(int id, String name,String prenom, String telephone, String address ) {
        this.id = id;
        this.nom = name;
        this.telephone = telephone;
        this.adresse = address;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setName(String name) {
        this.nom = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String phoneNumber) {
        this.telephone = phoneNumber;
    }
    
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String address) {
		this.adresse = address;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
