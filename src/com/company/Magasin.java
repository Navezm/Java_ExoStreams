package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Magasin {
    Scanner scan = new Scanner(System.in);

    List<Produit> inventaire = new ArrayList<>();
    public int totalProduct = 0;

    public void launchProgram() {
        int choice = 0;
        boolean continueProgram = true;
        System.out.println("Bienvenue dans ton programme d'inventaire !");
        System.out.println("Tu as le choix entre différentes fonctionnalités.");
        while (continueProgram) {
            System.out.print("1. Rajouter un produit \n" +
                    "2. Supprimer un produit \n" +
                    "3. Rajouter du stock à un produit \n" +
                    "4. Afficher une liste triée de l'inventaire \n" +
                    "5. Faire une recherche dans l'inventaire \n" +
                    "6. Voir les produits associés à une marque \n" +
                    "7. Voir les produits dont le stocks est faible (moins de 10 unités) \n");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    addStock();
                    break;
                case 4:
                    sort();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    searchBrand();
                    break;
                case 7:
                    showProduct();
                    break;
            }
            System.out.println("Veux tu continuer à utiliser le programme ? (true / false)");
            String answer = scan.nextLine();
            if (Objects.equals(answer, "false")) {
                continueProgram = false;
                System.out.println("Merci d'avoir utilisé ce programme");
            }
        }
    }

    public void addProduct() {
        System.out.println("Quel est le nom du produit ?");
        String nom = scan.nextLine();

        System.out.println("Quel sera son prix ?");
        int prix = scan.nextInt();
        scan.nextLine();

        System.out.println("Quelle sera sa marque ?");
        String marque = scan.nextLine();

        System.out.println("Quel sera son type ? " + Arrays.toString(Types.values()));
        Types type = Types.COMESTIBLE; // Comment mettre le type via l'énum ?

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

        List<Produit> produit = inventaire.stream()
                .filter((product) -> Objects.equals(product.getNom(), name))
                .collect(Collectors.toList()); // Find le produit dans le magasin

        totalProduct -= produit.get(0).getStock();
        inventaire.remove(produit.get(0));

        System.out.println("Success");
    }

    public void addStock() {
        System.out.println("Quel est le nom du produit auquel tu veux ajouter du stock ?");
        String name = scan.nextLine();
        System.out.println("Quel est le nombre que tu veux rajouter a ce stock ?");
        int nbr = scan.nextInt();

        if (totalProduct + nbr <= 1000) {
            List<Produit> produit = inventaire.stream()
                    .filter((product) -> Objects.equals(product.getNom(), name))
                    .collect(Collectors.toList()); // Find le produit dans le magasin

            int index = inventaire.indexOf(produit.get(0));
            inventaire.get(index).setStock(inventaire.get(index).getStock() + nbr);

            System.out.println("Success");
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
        System.out.println("Il est possible de faire des recherches dans le magasin. Selon des critères de prix (min/max), de type et/ou de nom.");
        System.out.println("Les possibilités : prix min / prix max / type / nom");
        String typeOfSearch = scan.nextLine();
        switch (typeOfSearch) {
            case "prix min":

                break;
            case "prix max":

                break;
            case "type":

                break;
            case "nom":

                break;
            default:
                System.out.println("Tu n'as pas entré une commande correcte");
                break;
        }

        // Faire la recherche en fonction du critère sélectionné + les afficher
    }

    public void searchBrand() {
        // Récup les brands et les afficher
        System.out.println("Voici les différentes marques présentes dans le magasin :");
        inventaire.stream()
                .map(Produit::getMarque) // Ne faire apparaître chaque marque qu'une fois
                .forEach(System.out::println);

        // Quand l'utilisateur à choisi la brand faire la recherche là-dessus
        System.out.println("Quel est la marque dont tu veux voir les produits associés ?");
        String brandName = scan.nextLine();
        inventaire.stream()
                .filter((product) -> Objects.equals(product.getMarque(), brandName))
                .forEach(System.out::println);
    }

    public void showProduct() {
        System.out.println("Vérification s'il existe un produit avec moins de 10 unités en stock");
        // Vérifier si le produit existe
        boolean rslt = inventaire.stream()
                .anyMatch((product) -> product.getStock() < 10);

        // Utiliser les streams pour afficher ces produits
        if (rslt) {
            System.out.println("Il y a ce(s) produit(s) dans l'inventaire :");
            inventaire.stream()
                    .filter((product) -> product.getStock() < 10)
                    .forEach(System.out::println);
        } else {
            System.out.println("Il n'y a pas de produit avec un petit stock");
        }
    }

}
