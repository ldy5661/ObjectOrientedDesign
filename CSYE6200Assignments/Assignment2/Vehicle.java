/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author Dongyue Li
 * ID: 001632075
 *
 */
public class Vehicle {
    private String ownerID;
    private String vehicleID;
    private String make;
    private String model;
    private int modelYear;
    private int passengers;
    private int fuelCap;
    private double kpl;
    private double value;
// Note - in the lecture, we switched from using Miles Per Gallon (MPG) to using Kilometers Per Liter (KPL).

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

//    Vehicle() {
//    }

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
        
    
    public double calcRange() {
        return fuelCap * kpl;
    }
    
    public double calcTax() {
        return 2.10 * (value / 1000);
    }
    
    public void print() {
        System.out.println("Owner ID: " + ownerID);
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Model Year: " + modelYear);
        System.out.println("Seating: " + passengers + " Passengers");
        System.out.println("Fuel Tank: " + fuelCap + " l");
        System.out.println("Estimated KPL: " + kpl + " kpl");
        System.out.println("Value: $" + value);
        System.out.println("Estimated Range: " + calcRange() + " km");
        System.out.println("***********************************************");
        
    }
    
    
    
    
}
