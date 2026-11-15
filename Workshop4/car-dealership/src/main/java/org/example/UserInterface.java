package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    public void display() {
        init();

        boolean running = true;

        while (running) {
            System.out.println("\n===== " + dealership.getName() + " =====");
            System.out.println("1 - Find vehicles by price range");
            System.out.println("2 - Find vehicles by make and model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "99":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.printf(
                "%-8s %-6s %-12s %-12s %-8s %-10s %-10s %12s%n",
                "VIN", "Year", "Make", "Model",
                "Type", "Color", "Mileage", "Price"
        );

        for (Vehicle vehicle : vehicles) {
            System.out.printf(
                    "%-8d %-6d %-12s %-12s %-8s %-10s %-10d %12.2f%n",
                    vehicle.getVin(),
                    vehicle.getYear(),
                    vehicle.getMake(),
                    vehicle.getModel(),
                    vehicle.getVehicleType(),
                    vehicle.getColor(),
                    vehicle.getOdometer(),
                    vehicle.getPrice()
            );
        }
    }

    public void processGetByPriceRequest() {
    }

    public void processGetByMakeModelRequest() {
        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine().trim();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    public void processGetByYearRequest() {
        try {
            System.out.print("Enter minimum year: ");
            int min = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter maximum year: ");
            int max = Integer.parseInt(scanner.nextLine().trim());

            if (min > max) {
                System.out.println("Minimum year cannot exceed maximum year.");
                return;
            }

            List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
            displayVehicles(vehicles);

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid whole numbers for years.");
        }
    }

    public void processGetByColorRequest() {
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine().trim();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    public void processGetByMileageRequest() {
        try {
            System.out.print("Enter minimum mileage: ");
            int min = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter maximum mileage: ");
            int max = Integer.parseInt(scanner.nextLine().trim());

            if (min < 0 || max < 0) {
                System.out.println("Mileage cannot be negative.");
                return;
            }

            if (min > max) {
                System.out.println(
                        "Minimum mileage cannot exceed maximum mileage."
                );
                return;
            }

            List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
            displayVehicles(vehicles);

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid whole numbers for mileage.");
        }
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.nextLine().trim();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddVehicleRequest() {
    }

    public void processRemoveVehicleRequest() {
    }
}