package com.pluralsight;
import java.io.*;
import java.util.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"));

            String line = reader.readLine();  // First line = dealership info
            String[] dealerParts = line.split("\\|");

            String name = dealerParts[0];
            String address = dealerParts[1];
            String phone = dealerParts[2];

            Dealership dealership = new Dealership(name, address, phone);

            // Now read vehicle lines
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
            System.out.println("Error reading inventory file: " + e.getMessage());
            return null;
        }

        // We’ll fill this in below!
        return null;
    }
}






