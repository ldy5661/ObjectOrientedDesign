/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.registry;

/**
 *
 * @author dongyueli
 */
public class Vehicle {
    private String ownerID;
    private String vehicleID; // Add a variable named vehicleID to unique identify a vehicle regitsted by a owner
    private String make;
    private String model;
    private int modelYear;
    private int passengers; // The number of legal passengers
    private double value; // The vehicle value in dollars
    private String fuelType; ///add Fuel Type

    public Vehicle(String ownerID, String vehicleID, String make, String model, int modelYear, int passengers, double value, String fuelType) {
        this.ownerID = ownerID;
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.passengers = passengers;
        this.value = value;
        this.fuelType = fuelType;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }
    
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    public double calcRange() {
        return 0.0;
    } 
    
    //  Calculate the annual tax ($2.10 per thousand)
    public double calcTax() {
        return 2.10 * (value / 1000);
    }
    
    public void print() {
        // Format output
        System.out.println(String.format("%-20s %-20s", "Owner ID: " , ownerID));
        System.out.println(String.format("%-20s %-20s", "Vehicle ID: " , vehicleID));
        System.out.println(String.format("%-20s %-20s", "Make: " , make));
        System.out.println(String.format("%-20s %-20s", "Model: " , model));
        System.out.println(String.format("%-20s %-20s", "Model Year: ", modelYear));
        System.out.println(String.format("%-20s %-20s", "Seating: ", passengers + " Passengers"));
        System.out.println(String.format("%-20s %s %1.2f", "Value:", "$", value));
        System.out.println(String.format("%-20s %-20s", "Fuel Type: " , fuelType));
    }   
}
