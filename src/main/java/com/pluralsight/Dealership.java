package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {


    private String name;
    private String address;
    private String phone;
    private List<Vehicle> vehicles;

    public Dealership(String name, String address, String phone, List<Vehicle> vehicles) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
