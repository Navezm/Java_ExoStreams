package com.company;

import java.util.Objects;

public class Produit {

    private String nom;
    private double prix;
    private String marque;
    private Types type;
    private int stock;

    public Produit(String nom, double prix, String marque, Types type, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.marque = marque;
        this.type = type;
        this.stock = stock;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                ", marque='" + marque + '\'' +
                ", type=" + type +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Double.compare(produit.prix, prix) == 0 && stock == produit.stock && Objects.equals(nom, produit.nom) && Objects.equals(marque, produit.marque) && type == produit.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prix, marque, type, stock);
    }
}
