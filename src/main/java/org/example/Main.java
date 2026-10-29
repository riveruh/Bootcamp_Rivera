package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = StoreFileManager.loadProducts();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n----- ONLINE STORE -----");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showProductsMenu(products, scanner);
                    break;
                case "2":
                    System.out.println("Your cart will go here.");
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }

    public static void displayProducts(ArrayList<Product> products) {
        System.out.println("\n----- PRODUCTS -----");

        for (Product product : products) {
            System.out.printf("%s | %s | $%.2f | %s%n",
                    product.getSku(),
                    product.getName(),
                    product.getPrice(),
                    product.getStoreDepartment());
        }
    }

    public static void showProductsMenu(ArrayList<Product> products, Scanner scanner) {
        boolean browsing = true;

        while (browsing) {
            displayProducts(products);

            System.out.println("\n1. Search by Name");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Go Back");
            System.out.println("4. Search by Department");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchByName(products, scanner);
                    break;
                case "2":
                    System.out.println("Adding to cart will go here.");
                    break;
                case "3":
                    browsing = false;
                    break;
                case "4":
                    searchByDepartment(products, scanner);
                    break;
                default:
                    System.out.println("Please enter 1, 2, 3, or 4.");
            }
        }
    }

    public static void searchByName(ArrayList<Product> products, Scanner scanner) {
        System.out.print("Enter a product name: ");
        String search = scanner.nextLine().trim();

        if (search.isEmpty()) {
            System.out.println("Please enter a name.");
            return;
        }

        ArrayList<Product> matches = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                matches.add(product);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No products found.");
        } else {
            displayProducts(matches);
        }

        System.out.print("Press Enter to return to the products menu.");
        scanner.nextLine();
    }

    public static void searchByDepartment(ArrayList<Product> products, Scanner scanner) {
        System.out.print("Enter a department: ");
        String search = scanner.nextLine().trim();

        if (search.isEmpty()) {
            System.out.println("Please enter a department.");
            return;
        }

        ArrayList<Product> matches = new ArrayList<>();

        for (Product product : products) {
            if (product.getStoreDepartment().equalsIgnoreCase(search)) {
                matches.add(product);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No products found.");
        } else {
            displayProducts(matches);
        }

        System.out.print("Press Enter to return to the products menu.");
        scanner.nextLine();
    }
}