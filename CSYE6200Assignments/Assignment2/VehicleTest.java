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
    private final Vehicle minivan1;
    private final Vehicle minivan2;
    private final Vehicle sportscar1;
    private final Vehicle sportscar2;
    private final Vehicle sportscar3;
    private final VehicleTaxation vehicleTaxation;
    // look up by ownerID
    private static final String lookup1 = "li.dongy";
    private static final String lookup2 = "Emily";
    private static final String lookup3 = "m.munson";
    
    public VehicleTest() {
        minivan1 = new Vehicle("li.dongy", "0001", "HONDA", "ODYSSEY", 2017, 7, 21, 27.0, 29850.0);
        minivan2 = new Vehicle("li.dongy", "0002", "Mercedes-Benz", "Metris", 2017, 7, 18, 23.0, 25995.0);
        sportscar1 = new Vehicle("m.munson", "0003", "TOYOTA", "86", 2017, 4, 13, 32.0, 26255.0);
        // sportscar2 is to test add repeat infomation.
        sportscar2 = new Vehicle("m.munson", "0003", "TOYOTA", "86", 2017, 4, 13, 32.0, 26255.0);
        sportscar3 = new Vehicle("m.munson", "0004", "BMW", "Z4", 2016, 2, 14, 33.0, 49700.0);
        vehicleTaxation = new VehicleTaxation();
    }
    
    private void run() {
        // 1. Test print method
        System.out.println("[Print Vehicle 0001 Information]");
        System.out.println();
        minivan1.print();
        System.out.println("[Print Vehicle 0003 Information]");
        System.out.println();
        sportscar1.print();
        // 2. Test add method to both ArrayList and HashMap
        System.out.println("[Add Information of Vehicles: 0001, 0002, 0003, 0003, 0004.]");
        System.out.println();
        vehicleTaxation.addVehicle(minivan1);
        vehicleTaxation.addVehicle(minivan2);
        vehicleTaxation.addVehicle(sportscar1);
        vehicleTaxation.addVehicle(sportscar2);
        vehicleTaxation.addVehicle(sportscar3);
        // 3. Test print Taxiation method
        System.out.println("[Print Taxiation Information]");
        System.out.println();
        vehicleTaxation.printVehicleTax();
        // 4. Test get method in ArrayList
        System.out.println("[Look up Vehicle Information by ownerID]");
        System.out.println();
        System.out.println("[Look up li.dongy Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup1);
        System.out.println("[Look up Emily Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup2);
        System.out.println("[Look up li.dongy Information.]");
        System.out.println();
        // 5. Test get method in HashMap
        vehicleTaxation.findFromMapAndPrint(lookup1);
        System.out.println("[Look up Emily Information.]");
        System.out.println();
        vehicleTaxation.findFromMapAndPrint(lookup2);
        System.out.println("[Delete Vehicle 0003]");
        System.out.println();
        // 6. Test remove method from both ArrayList and HashMap
        vehicleTaxation.removeVehicle("0003");
        System.out.println("[Look up m.munson Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup3);
        vehicleTaxation.findFromMapAndPrint(lookup3);
        System.out.println("[Delete Vehicle 0004]");
        System.out.println();
        vehicleTaxation.removeVehicle("0004");
        System.out.println("[Look up m.munson Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup3);
        vehicleTaxation.findFromMapAndPrint(lookup3);        
    }

    public static void main(String[] args) {
        VehicleTest vt = new VehicleTest();
        vt.run();
    }    
}
