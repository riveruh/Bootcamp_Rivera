package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class DealershipFileManager {

    public Dealership getDealership() {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("inventory.csv"))) {

            String firstLine = reader.readLine();

            if (firstLine == null) {
                throw new IllegalStateException("Inventory file is empty.");
            }

            String[] dealershipInfo = firstLine.split("\\|");

            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            Dealership dealership = new Dealership(name, address, phone);
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] vehicleInfo = line.split("\\|");

                int vin = Integer.parseInt(vehicleInfo[0]);
                int year = Integer.parseInt(vehicleInfo[1]);
                String make = vehicleInfo[2];
                String model = vehicleInfo[3];
                String vehicleType = vehicleInfo[4];
                String color = vehicleInfo[5];
                int odometer = Integer.parseInt(vehicleInfo[6]);
                BigDecimal price = new BigDecimal(vehicleInfo[7]);

                Vehicle vehicle = new Vehicle(
                        vin, year, make, model,
                        vehicleType, color, odometer, price
                );

                dealership.addVehicle(vehicle);
            }
            return dealership;

        } catch (IOException e) {
            throw new IllegalStateException("Unable to load inventory.csv.", e);
        }
    }

    public void saveDealership(Dealership dealership) {
        // we will implement saving laterrr
    }
}