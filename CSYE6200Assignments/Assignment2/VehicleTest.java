/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 * A special class used to test the Vehicle class
 * @author Dongyue Li
 * ID: 001632075
 *
 */
public class VehicleTest {
    private Vehicle minivan;
    private Vehicle sportscar;
    private VehicleTaxation vehicleTaxation;
    private static final String lookup1 = "li.dongy";
    private static final String lookup2 = "Emily";
    
    public VehicleTest() {
        minivan = new Vehicle("li.dongy", "0001", "HONDA", "ODYSSEY", 2017, 7, 21, 19.0, 29850.0);
        sportscar = new Vehicle("m.munson", "0002", "TOYOTA", "86", 2017, 4, 28, 23.0, 26255.0);
        vehicleTaxation = new VehicleTaxation();
    }
    
    private void run() {
        minivan.print();
        sportscar.print();
        vehicleTaxation.addVehicle(minivan);
        vehicleTaxation.addVehicle(sportscar);
        vehicleTaxation.addVehicle(minivan);
        vehicleTaxation.printVehicleTax();
        vehicleTaxation.findFromListAndPrint(lookup1);
        vehicleTaxation.findFromListAndPrint(lookup2);
        vehicleTaxation.findFromMapAndPrint(lookup1);
        vehicleTaxation.findFromMapAndPrint(lookup2);
        
    }

    public static void main(String[] args) {
        VehicleTest vt = new VehicleTest();
        vt.run();
    }    
}
