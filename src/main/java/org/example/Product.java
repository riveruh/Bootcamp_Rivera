package org.example;

public class Product {
    private String sku;
    private String name;
    private double price;
    private String storeDepartment;

    public Product (String sku, String name, double price, String storeDepartment) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.storeDepartment = storeDepartment;
    }
}
