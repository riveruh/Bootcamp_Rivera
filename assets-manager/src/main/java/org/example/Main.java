package org.example;

import java.util.ArrayList;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House(
                "My house",
                "2020-06-15",
                new BigDecimal("250000"),
                "123 Maple Street",
                1,
                1500,
                4000
        ));

        assets.add(new House(
                "My vacation house",
                "2023-07-10",
                new BigDecimal("180000"),
                "456 Lake Drive",
                2,
                1200,
                3000
        ));
        assets.add(new Vehicle(
                "My car",
                "2022-05-20",
                new BigDecimal("25000"),
                "Honda Civic",
                2022,
                120000
        ));

        assets.add(new Vehicle(
                "Tom's truck",
                "2021-08-12",
                new BigDecimal("35000"),
                "Ford F-150",
                2021,
                130000
        ));
        for (Asset asset : assets) {
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date acquired: " + asset.getDateAcquired());
            System.out.printf("Original cost: $%,.2f%n", asset.getOriginalCost());
            System.out.printf("Current value: $%,.2f%n", asset.getValue());
            if (asset instanceof House) {
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Vehicle: " + vehicle.getYear()
                        + " " + vehicle.getMakeModel());
            }
            System.out.println();
        }
    }
}