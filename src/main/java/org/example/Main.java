package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = StoreFileManager.loadProducts();
        ArrayList<Product> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n----- ONLINE STORE -----");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    showProductsMenu(products, cart, scanner);
                    break;
                case "2":
                    showCartMenu(cart, scanner);
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

    public static void showProductsMenu(ArrayList<Product> products,
                                        ArrayList<Product> cart,
                                        Scanner scanner) {
        boolean browsing = true;

        while (browsing) {
            displayProducts(products);

            System.out.println("\n1. Search by Name");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Go Back");
            System.out.println("4. Search by Department");
            System.out.println("5. Search by Price Range");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    searchByName(products, scanner);
                    break;
                case "2":
                    addToCart(products, cart, scanner);
                    break;
                case "3":
                    browsing = false;
                    break;
                case "4":
                    searchByDepartment(products, scanner);
                    break;
                case "5":
                    searchByPrice(products, scanner);
                    break;
                default:
                    System.out.println("Please enter 1, 2, 3, 4, or 5.");
            }
        }
    }

    public static void searchByName(ArrayList<Product> products, Scanner scanner) {
        System.out.print("Enter a product name: ");
        String search = scanner.nextLine().trim();

        if (search.isEmpty()) {
            System.out.println("Please enter a name.");
            return;
        }

        ArrayList<Product> matches = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                matches.add(product);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No products found.");
        } else {
            displayProducts(matches);
        }

        System.out.print("Press Enter to return to the products menu.");
        scanner.nextLine();
    }

    public static void searchByDepartment(ArrayList<Product> products,
                                          Scanner scanner) {
        System.out.print("Enter a department: ");
        String search = scanner.nextLine().trim();

        if (search.isEmpty()) {
            System.out.println("Please enter a department.");
            return;
        }

        ArrayList<Product> matches = new ArrayList<>();

        for (Product product : products) {
            if (product.getStoreDepartment().equalsIgnoreCase(search)) {
                matches.add(product);
            }
        }

        if (matches.isEmpty()) {
            System.out.println("No products found.");
        } else {
            displayProducts(matches);
        }

        System.out.print("Press Enter to return to the products menu.");
        scanner.nextLine();
    }

    public static void searchByPrice(ArrayList<Product> products, Scanner scanner) {
        try {
            System.out.print("Enter minimum price: ");
            double minimum = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter maximum price: ");
            double maximum = Double.parseDouble(scanner.nextLine().trim());

            if (!Double.isFinite(minimum) || !Double.isFinite(maximum)
                    || minimum < 0 || maximum < 0 || minimum > maximum) {
                System.out.println(
                        "Please use numbers 0 or higher and put the lower price first.");
                return;
            }

            ArrayList<Product> matches = new ArrayList<>();

            for (Product product : products) {
                if (product.getPrice() >= minimum && product.getPrice() <= maximum) {
                    matches.add(product);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No products found.");
            } else {
                displayProducts(matches);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter numbers without a dollar sign.");
        }

        System.out.print("Press Enter to return to the products menu.");
        scanner.nextLine();
    }

    public static void addToCart(ArrayList<Product> products,
                                 ArrayList<Product> cart,
                                 Scanner scanner) {
        System.out.print("Enter the SKU of the product: ");
        String sku = scanner.nextLine().trim();

        if (sku.isEmpty()) {
            System.out.println("Please enter a SKU.");
            return;
        }

        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                cart.add(product);
                System.out.println(product.getName() + " was added to your cart!");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public static void displayCart(ArrayList<Product> cart) {
        System.out.println("\n----- YOUR CART -----");

        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        for (Product product : cart) {
            System.out.printf("%s | %s | $%.2f%n",
                    product.getSku(),
                    product.getName(),
                    product.getPrice());
        }

        System.out.printf("Total: $%.2f%n", getCartTotal(cart));
    }

    public static double getCartTotal(ArrayList<Product> cart) {
        double total = 0;

        for (Product product : cart) {
            total += product.getPrice();
        }

        return total;
    }

    public static void showCartMenu(ArrayList<Product> cart, Scanner scanner) {
        boolean viewingCart = true;

        while (viewingCart) {
            displayCart(cart);

            System.out.println("\n1. Check Out");
            System.out.println("2. Remove Product");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println("Checkout isn't ready yet.");
                    break;
                case "2":
                    removeFromCart(cart, scanner);
                    break;
                case "3":
                    viewingCart = false;
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 3.");
            }
        }
    }

    public static void removeFromCart(ArrayList<Product> cart, Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.print("Enter the SKU of the product to remove: ");
        String sku = scanner.nextLine().trim();

        if (sku.isEmpty()) {
            System.out.println("Please enter a SKU.");
            return;
        }

        for (int i = 0; i < cart.size(); i++) {
            Product product = cart.get(i);

            if (product.getSku().equalsIgnoreCase(sku)) {
                cart.remove(i);
                System.out.println(product.getName() + " was removed from your cart!");
                return;
            }
        }

        System.out.println("That product isn't in your cart.");
    }
}