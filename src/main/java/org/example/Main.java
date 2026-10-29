package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Products loaded: " + StoreFileManager.loadProducts().size());
    }
}