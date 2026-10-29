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
                System.out.println(row);
            }

        } catch (IOException e) {
            System.out.println("Could not read the products file. Try again!");
        }

        return products;
    }
}