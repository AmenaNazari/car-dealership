package com.pluralsight;

import java.io.*;
import java.util.List;

public class DealershipFileManager {

    private static final String FILE_NAME = "inventory.txt";

    public Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();
            String[] dealerParts = line.split("\\|");

            String name = dealerParts[0];
            String address = dealerParts[1];
            String phone = dealerParts[2];

            Dealership dealership = new Dealership(name, address, phone);

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String type = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

            reader.close();
            return dealership;

        } catch (IOException e) {
            System.out.println("Error reading inventory file.");
            e.printStackTrace();
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, false));

            // Write dealership info
            writer.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());

            // Write vehicle list
            List<Vehicle> vehicles = dealership.getVehicles();
            for (Vehicle v : vehicles) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        v.getVin(),
                        v.getYear(),
                        v.getMake(),
                        v.getModel(),
                        v.getVehicleType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice());
            }

            writer.close();
            System.out.println("Inventory saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving dealership inventory.");
            e.printStackTrace();
        }
    }
}







