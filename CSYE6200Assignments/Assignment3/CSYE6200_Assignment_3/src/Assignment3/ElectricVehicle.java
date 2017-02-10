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
public class ElectricVehicle extends Vehicle {
    private int batteryCapacity;  // Watt-Hours
    private double rangeEfficiency;  // Kilometers per WH

    public ElectricVehicle(String ownerID, String vehicleID, String make, String model, int modelYear, int passengers, double value, String fuelType, int batteryCapacity, double rangeEfficiency) {
        super(ownerID, vehicleID, make, model, modelYear, passengers, value, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.rangeEfficiency = rangeEfficiency;
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
        return batteryCapacity * rangeEfficiency;
    } 

    @Override
    public void print() {
        super.print();
        System.out.println(String.format("%-20s %-20s","Battery Capacity: ", batteryCapacity + "Wh"));
        System.out.println(String.format("%-20s %1.4f %s","Range Efficiency: ", rangeEfficiency, "kpWh"));
        System.out.println(String.format("%-20s %1.2f %s", "Estimated Range: ", calcRange(), "km"));
        System.out.println("***********************************************");
    }
    
}
