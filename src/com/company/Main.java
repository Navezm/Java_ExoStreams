package com.company;

public class Main {

    public static void main(String[] args) {
        Produit prod = new Produit("chocolat", 10, "Cote d'or", Types.COMESTIBLE, 150);
        Produit prod1 = new Produit("lait", 4, "Cote d'or", Types.COMESTIBLE, 200);
        Produit prod2 = new Produit("ordinateur", 720, "MSI", Types.PETIT, 8);
        Produit prod3 = new Produit("armoire", 150, "Ikea", Types.GROS, 46);
        Produit prod4 = new Produit("lunettes", 200, "Rayban", Types.PETIT, 150);

        Magasin magasin = new Magasin();
        magasin.inventaire.add(prod);
        magasin.inventaire.add(prod1);
        magasin.inventaire.add(prod2);
        magasin.inventaire.add(prod3);
        magasin.inventaire.add(prod4);

        magasin.launchProgram();
    }
}
