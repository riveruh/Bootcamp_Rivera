package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Products loaded: " + StoreFileManager.loadProducts().size());

        System.out.println("----- ONLINE STORE -----");
        System.out.println("1. Display Products");
        System.out.println("2. Display Cart");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }
}