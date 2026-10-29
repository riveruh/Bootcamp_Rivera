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

            System.out.println("\n1. Search Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Search will go here.");
                    break;
                case "2":
                    System.out.println("Adding to cart will go here.");
                    break;
                case "3":
                    browsing = false;
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 3.");
            }
        }
    }
}