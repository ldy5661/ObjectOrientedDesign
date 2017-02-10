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
public class VehicleTest {
    private final Vehicle minivan_gas_1;
    private final Vehicle minivan_gas_2;
    private final Vehicle sportscar_gas_1;
    private final Vehicle electricCar_1;
    private final Vehicle sportscar_gas_2;
    private final Vehicle sportscar_gas_3;
    private final Vehicle hybridCar_1;
    private VehicleTaxation vehicleTaxation;
    private TaxRegistryIO taxRegistryIO;
    // look up by ownerID
    private static final String lookup1 = "li.dongy";
    private static final String lookup2 = "Emily";
    private static final String lookup3 = "m.munson";
    
    public VehicleTest() {
        // These 4 cars Info are already in the file. 
        minivan_gas_1 = new GasVehicle("li.dongy", "0001", "HONDA", "ODYSSEY", 2017, 7, 29850.0, "Gas", 21, 27.0);
        minivan_gas_2 = new GasVehicle("li.dongy", "0002", "Mercedes-Benz", "Metris", 2017, 7, 25995.0, "Gas", 18, 23.0);
        sportscar_gas_1 = new GasVehicle("m.munson", "0003", "TOYOTA", "86", 2017, 4, 26255.0, "Gas", 13, 32.0);
        electricCar_1 = new ElectricVehicle("m.munson", "0004", "Tesla", "Model S 60D", 2016, 7, 76300.0, "Electricity", 60000, 0.0068);
   
        // sportscar2 is to test add repeat infomation.
        sportscar_gas_2 = new GasVehicle("m.munson", "0003", "TOYOTA", "86", 2017, 4, 26255.0, "Gas", 13, 32.0);
        sportscar_gas_3 = new GasVehicle("m.munson", "0005", "BMW", "Z4", 2016, 2, 49700.0, "Gas", 14, 33.0);
        hybridCar_1 = new HybridVehicle("m.munson", "0006", "TOYOTA", "PRIUS Two", 2017, 5, 24685.0, "Hybrid", 11, 53.0, 8800, 0.0025);
        
        vehicleTaxation = new VehicleTaxation();
        taxRegistryIO = new TaxRegistryIO();
    }
    
    private void run() {
        // 0. code to create default test.txt file.
        System.out.println("<<<<<<<<<<< 0. Save some Vehicles to create default test.txt file for loading >>>>>>>>>>>>>");
        System.out.println();
        vehicleTaxation.addVehicle(minivan_gas_1);
        vehicleTaxation.addVehicle(minivan_gas_2);
        vehicleTaxation.addVehicle(sportscar_gas_1);
        vehicleTaxation.addVehicle(electricCar_1);
        taxRegistryIO.save(vehicleTaxation.getVehicleList() , "test.txt");

        // 1. Test load method
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 1. Test load method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Loading Vehicles Info from test.txt...]");
        System.out.println();
        vehicleTaxation = taxRegistryIO.load("test.txt");
        System.out.println();
        
        // 2. Test print method
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 2. Test print method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Printing Vehicles Taxiation Info...]");
        System.out.println();
        vehicleTaxation.printVehicleTax();
        System.out.println();
        System.out.println("[Printing Vehicle ID: 0005 Info...]");
        sportscar_gas_3.print();
        System.out.println();
        
        // 3. Test add method to both ArrayList and HashMap
        System.out.println("<<<<<<<<<<<<<<<<<<<<< 3. Test add method to both ArrayList and HashMap >>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Adding Information of Vehicles: 0003, 0005, 0006.]");
        System.out.println();
        vehicleTaxation.addVehicle(sportscar_gas_2);
        vehicleTaxation.addVehicle(sportscar_gas_3);
        vehicleTaxation.addVehicle(hybridCar_1);
        System.out.println();
        
        // 4. Test get method in ArrayList
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 4. Test get method in ArrayList >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Look up Vehicle Information by ownerID]");
        System.out.println();
        System.out.println("[Looking up li.dongy Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup1);
        System.out.println("[Looking up Emily Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup2);
        System.out.println();
        
        // 5. Test get method in HashMap
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 5. Test get method in HashMap >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Look up li.dongy Information.]");
        System.out.println();
        vehicleTaxation.findFromMapAndPrint(lookup1);
        System.out.println("[Look up Emily Information.]");
        System.out.println();
        vehicleTaxation.findFromMapAndPrint(lookup2);
        System.out.println();
        
        // 6. Test remove method from both ArrayList and HashMap
        System.out.println("<<<<<<<<<<<<<<<<<<< 6. Test remove method from both ArrayList and HashMap >>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Delete Vehicle 0001]");
        System.out.println();
        vehicleTaxation.removeVehicle("0001");
        System.out.println("[Look up li.dongy Information.]");
        System.out.println();
        vehicleTaxation.findFromListAndPrint(lookup1);
        vehicleTaxation.findFromMapAndPrint(lookup1);
        System.out.println("[Delete Vehicle 01234]");
        System.out.println();
        vehicleTaxation.removeVehicle("01234");
        System.out.println();
        
        // 7. Test save method
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 7. Test save method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println();
        System.out.println("[Saving Vehicle List to test.txt]");
        System.out.println();
        taxRegistryIO.save(vehicleTaxation.getVehicleList() , "test.txt");

    }

    public static void main(String[] args) {
        VehicleTest vt = new VehicleTest();
        vt.run();
    }       
}
