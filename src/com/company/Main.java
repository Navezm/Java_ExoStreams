package com.company;

public class Main {

    public static void main(String[] args) {
        Produit prod = new Produit("chocolat", 10, "Cote d'or", Types.COMESTIBLE, 20);
        Produit prod1 = new Produit("lait", 10, "Cote d'or", Types.COMESTIBLE, 10);
        Produit prod2 = new Produit("bonbon", 10, "Cote d'or", Types.COMESTIBLE, 20);
        Produit prod3 = new Produit("chocolat", 10, "Cha", Types.COMESTIBLE, 20);
        Produit prod4 = new Produit("chocolat", 10, "Deluxe", Types.COMESTIBLE, 20);

//        System.out.println(prod);

        Magasin magasin = new Magasin();
        magasin.inventaire.add(prod);
        magasin.inventaire.add(prod1);
        magasin.inventaire.add(prod2);
        magasin.inventaire.add(prod3);
        magasin.inventaire.add(prod4);

//        magasin.addStock();

//        magasin.inventaire.forEach(System.out::println);

//        magasin.searchBrand();

//        magasin.showProduct();
        magasin.launchProgram();
    }
}
