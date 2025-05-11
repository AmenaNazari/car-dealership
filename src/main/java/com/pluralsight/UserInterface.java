package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    handleListAllVehicles();
                    break;
                case 99:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n=== Dealership Menu ===");
        System.out.println("1 - List ALL vehicles");
        // You’ll add more options here soon
        System.out.println("99 - Quit");
        System.out.print("Choose an option: ");
    }

    private void handleListAllVehicles() {
        List<Vehicle> inventory = dealership.getAllVehicles();
        System.out.println("\n--- All Vehicles ---");
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle);

            private void handleSearchByPrice() {
                System.out.print("Enter minimum price: ");
                double min = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter maximum price: ");
                double max = Double.parseDouble(scanner.nextLine());

                List<Vehicle> matches = dealership.getVehiclesByPrice(min, max);

                if (matches.isEmpty()) {
                    System.out.println("No vehicles found in that price range.");
                } else {
                    System.out.println("\n--- Vehicles $" + min + " to $" + max + " ---");
                    for (Vehicle v : matches) {
                        System.out.println(v);

                        public List<Vehicle> getVehiclesByPrice(double min, double max) {
                            List<Vehicle> matches = new ArrayList<>();
                            for (Vehicle v : vehicles) {
                                if (v.getPrice() >= min && v.getPrice() <= max) {
                                    matches.add(v);
                                }
                            }
                            return matches;
                        }

                    }
                }
            }

        }
    }
}

