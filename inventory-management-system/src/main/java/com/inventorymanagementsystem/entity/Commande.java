package com.inventorymanagementsystem.entity;

public class Commande {
    private String NProduit;
    private int Quantite;
    private double Prix;
    private double Total;

    public Commande(String item_number, int quantity, double price, double total_amount) {
        this.NProduit = item_number;
        this.Quantite = quantity;
        this.Prix = price;
        this.Total = total_amount;
    }

    public String getNProduit() {
        return NProduit;
    }

    public void setNProduit(String item_number) {
        this.NProduit = item_number;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantity) {
        this.Quantite = quantity;
    }

    public double getPrix() {
        return Prix;
    }

    public void setPrix(double price) {
        this.Prix = price;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total_amount) {
        this.Total = total_amount;
    }
}
