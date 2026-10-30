package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreFileManager {

    public static ArrayList<Product> loadProducts() {
        ArrayList<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/main/resources/products.csv"))) {

            reader.readLine(); // skip ur header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] parts = row.split("\\|");

                String sku = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String storeDepartment = parts[3];

                Product product = new Product(sku, name, price, storeDepartment);
                products.add(product);
            }
        } catch (IOException e) {
            System.out.println("Could not read the products file.");
        }

        return products;
    }
}