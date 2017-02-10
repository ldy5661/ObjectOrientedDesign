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
public class HybridVehicle extends Vehicle{
    private int fuelCap;
    private double kpl;
    private int batteryCapacity;  // Watt-Hours
    private double rangeEfficiency;  // Kilometers per WH

    public HybridVehicle(String ownerID, String vehicleID, String make, String model, int modelYear, int passengers, double value, String fuelType, int fuelCap, double kpl, int batteryCapacity,double rangeEfficiency) {
        super(ownerID, vehicleID, make, model, modelYear, passengers, value, fuelType);
        this.fuelCap = fuelCap;
        this.kpl = kpl;
        this.batteryCapacity = batteryCapacity;
        this.rangeEfficiency = rangeEfficiency;
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

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getRangeEfficiency() {
        return rangeEfficiency;
    }

    public void setRangeEfficiency(double rangeEfficiency) {
        this.rangeEfficiency = rangeEfficiency;
    }

    //  Calculate the vehicle range
    @Override
    public double calcRange() {
        return fuelCap * kpl + batteryCapacity * rangeEfficiency;
    } 
    
    @Override
    public void print() {
        super.print(); 
        System.out.println(String.format("%-20s %-20s","Fuel Tank: ", fuelCap + " l"));
        System.out.println(String.format("%-20s %1.2f %s","Estimated KPL: ", kpl, "kpl"));
        System.out.println(String.format("%-20s %-20s","Battery Capacity: ", batteryCapacity + "Wh"));
        System.out.println(String.format("%-20s %1.4f %s","Range Efficiency: ", rangeEfficiency, "kpWh"));
        System.out.println(String.format("%-20s %1.2f %s", "Estimated Range: ", calcRange(), "km"));
        System.out.println("***********************************************");
    }
}
