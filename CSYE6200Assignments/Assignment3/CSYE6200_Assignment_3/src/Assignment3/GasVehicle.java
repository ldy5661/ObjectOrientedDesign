/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

/**
 *
 * @author dongyueli
 */
public class GasVehicle extends Vehicle{
    private int fuelCap;  // Liters
    private double kpl; // Kilometers per liter

    public GasVehicle(String ownerID, String vehicleID, String make, String model, int modelYear, int passengers, double value, String fuelType, int fuelCap, double kpl) {
        super(ownerID, vehicleID, make, model, modelYear, passengers, value, fuelType);
        this.fuelCap = fuelCap;
        this.kpl = kpl;
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
    
    //  Calculate the vehicle range
    @Override
    public double calcRange() {
        return fuelCap * kpl;
    } 

    @Override
    public void print() {
        super.print(); 
        System.out.println(String.format("%-20s %-20s","Fuel Tank: ", fuelCap + " l"));
        System.out.println(String.format("%-20s %1.2f %s","Estimated KPL: ", kpl, "kpl"));
        System.out.println(String.format("%-20s %1.2f %s", "Estimated Range: ", calcRange(), "km"));
        System.out.println("***********************************************");
    }
}
