package com.company;

public class Main {

    public static void main(String[] args) {
        Produit prod = new Produit("chocolat", 10, "Cote d'or", Types.COMESTIBLE, 20);

        System.out.println(prod);

        Magasin magasin = new Magasin();
        magasin.inventaire.add(prod);

        magasin.addStock();

        magasin.inventaire.forEach(System.out::println);
    }
}
