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
                case 1 -> handleListAllVehicles();
                case 2 -> handleSearchByPrice();
                case 3 -> handleSearchByMakeModel();
                case 4 -> handleSearchByYear();
                case 5 -> handleSearchByColor();
                case 6 -> handleSearchByMileage();
                case 7 -> handleSearchByType();
                case 99 -> {
                    running = false;
                    System.out.println("Goodbye! ");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n=== Dealership Menu ===");
        System.out.println("1 - List ALL vehicles");
        System.out.println("2 - Search by price range");
        System.out.println("3 - Search by make & model");
        System.out.println("4 - Search by year range");
        System.out.println("5 - Search by color");
        System.out.println("6 - Search by mileage range");
        System.out.println("7 - Search by vehicle type");
        System.out.println("99 - Quit");
        System.out.print("Choose an option: ");
    }

    private void handleListAllVehicles() {
        List<Vehicle> vehicles = dealership.getVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            vehicles.forEach(System.out::println);
        }
    }

    private void handleSearchByPrice() {
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        printResults(results);
    }

    private void handleSearchByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        printResults(results);
    }

    private void handleSearchByYear() {
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByYear(min, max);
        printResults(results);
    }

    private void handleSearchByColor() {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByColor(color);
        printResults(results);
    }

    private void handleSearchByMileage() {
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        printResults(results);
    }

    private void handleSearchByType() {
        System.out.print("Enter vehicle type (e.g., SUV, Truck): ");
        String type = scanner.nextLine();

        List<Vehicle> results = dealership.getVehiclesByType(type);
        printResults(results);
    }

    private void printResults(List<Vehicle> results) {
        if (results.isEmpty()) {
            System.out.println("No matching vehicles found.");
        } else {
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }
}
