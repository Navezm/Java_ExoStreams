package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Magasin {
    Scanner scan = new Scanner(System.in);

    List<Produit> inventaire = new ArrayList<>();
    public int totalProduct = 0;

    public void addProduct() {
        System.out.println("Quel est le nom du produit ?");
        String nom = scan.nextLine();

        System.out.println("Quel sera son prix ?");
        int prix = scan.nextInt();

        System.out.println("Quelle sera sa marque ?");
        String marque = scan.nextLine();

        System.out.println("Quel sera son type ? " + Arrays.toString(Types.values()));
        Types type = (Types)scan.nextLine(); // Comment mettre le type via l'énum ?

        System.out.println("Quel sera sont stock");
        int stock = scan.nextInt();

        Produit produit = new Produit(nom,prix,marque,type,stock);

        if (totalProduct + produit.getStock() <= 1000) {
            inventaire.add(produit);
        } else {
            System.out.println("Vous ne pouvez pas rajouter ce produit par manque de stock disponible");
        }
        totalProduct += produit.getStock();
    }

    public void deleteProduct() {
        System.out.println("Quel est le nom de produit que tu souhaites supprimer ?");
        String name = scan.nextLine();

        Produit produit; // Find le produit dans le magasin
        totalProduct -= produit.getStock();
        inventaire.remove(produit);
    }

    public void addStock() {
        System.out.println("Quel est le nom du produit que auquel tu veux ajouter du stock ?");
        String name = scan.nextLine();
        System.out.println("Quel est le nombre que tu veux rajouter au stock ?");
        int nbr = scan.nextInt();

        if (totalProduct + nbr <= 1000) {
            inventaire.stream()
                    .filter(element -> element.getNom().equals(name));
//                    .map(produit -> produit.setStock(produit.getStock()+nbr));
        }
    }

    public void sort() {
        System.out.println("De quel type veux-tu faire ta recherche ? (prix, type, quantité)");
        String typeOfSort = scan.nextLine();
        List<Produit> productSorted = null;
        switch (typeOfSort){
            case "prix":
                productSorted = inventaire.stream()
                        .sorted(Comparator.comparing(Produit::getPrix))
                        .collect(Collectors.toList());
                break;
            case "type":
                productSorted = inventaire.stream()
                        .sorted(Comparator.comparing(Produit::getType))
                        .collect(Collectors.toList());
                break;
            case "quantité":
                productSorted = inventaire.stream()
                        .sorted(Comparator.comparing(Produit::getStock))
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Mauvais type entré");
                break;
        }
        assert productSorted != null;
        productSorted.forEach(System.out::println);
    }

    public void search() {
        // Proposer les critères

        // Faire la recherche en fonction du critère sélectionné + les afficher
    }

    public void searchBrand() {
        // Récup les brands et les afficher

        // Quand l'utilisateur à choisi la brand faire la recherche là-dessus
    }

    public void showProduct() {
        // Vérifier si le produit existe (findAny)

        // Utiliser les streams pour afficher ces produits
    }

}
