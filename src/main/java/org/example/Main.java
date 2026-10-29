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
                    System.out.println("\n----- PRODUCTS -----");

                    for (Product product : products) {
                        System.out.printf("%s | %s | $%.2f | %s%n",
                                product.getSku(),
                                product.getName(),
                                product.getPrice(),
                                product.getStoreDepartment());
                    }

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
}