/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 * CSYE 6200 Vehicle class
 * 
 * @author Dongyue Li
 * ID: 001632075
 *
 */
public class Vehicle {
    private String ownerID;
    // Add a variable named vehicleID to unique identify a vehicle regitsted by a owner
    private String vehicleID;
    private String make;
    private String model;
    private int modelYear;
    private int passengers;
    private int fuelCap;
    private double kpl;
    private double value;

    public Vehicle(String ownerID, String vehicleID, String make, String model, int modelYear, int passengers, int fuelCap, double kpl, double value) {
        this.ownerID = ownerID;
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.passengers = passengers;
        this.fuelCap = fuelCap;
        this.kpl = kpl;
        this.value = value;
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

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getFuelCap() {
        return fuelCap;
    }

    public void setFuelCap(int fuelCap) {
        this.fuelCap = fuelCap;
    }

    public double getKpl() {
        return kpl;
    }

    public void setKpl(double kpl) {
        this.kpl = kpl;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
        
    //  Calculate the vehicle range
    public double calcRange() {
        return fuelCap * kpl;
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
        System.out.println(String.format("%-20s %-20s","Fuel Tank: ", fuelCap + " l"));
        System.out.println(String.format("%-20s %1.2f %s","Estimated KPL: ", kpl, "kpl"));
        System.out.println(String.format("%-20s %s %1.2f", "Value:", "$", value));
        System.out.println(String.format("%-20s %1.2f %s", "Estimated Range: ", calcRange(), "km"));
        System.out.println("***********************************************");
    }
}
