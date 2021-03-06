/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CSYE 6200 Vehicle class
 * 
 * @author Dongyue Li
 * ID: 001632075
 *
 */
public class VehicleTaxation {
    private ArrayList<Vehicle> vehicleList;
    // Allow same user has multiple vehicles!
    // Use HashMap to map OwnerID and owner Vehicles.
    // Use HashMap to map VehicleID and Vehicle.
    private HashMap<String, HashMap<String, Vehicle>> vehicleMap;

    public VehicleTaxation() {
        vehicleList = new ArrayList<>();
        vehicleMap = new HashMap<>();
    }
    
    // 1. add method. Allow same user has multiple vehicles! But same VehicleID can only be added once.
    public void addVehicle(Vehicle v){
        for(Vehicle vehicle: vehicleList){
            if(v.getVehicleID().equals(vehicle.getVehicleID())){
                System.out.println("Add Error! This vehicle ID: " + v.getVehicleID() + " is already exist!");
                System.out.println("***********************************************");
                return;
            }
        }
        vehicleList.add(v);
        if(!vehicleMap.containsKey(v.getOwnerID())) {
            vehicleMap.put(v.getOwnerID(), new HashMap<String, Vehicle>());
        }
        vehicleMap.get(v.getOwnerID()).put(v.getVehicleID(), v);
    }

    // 2. get method in ArrayList
    public ArrayList<Vehicle> getVehicleFromList(String ownerID){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            if(ownerID.equals(vehicle.getOwnerID())){
                result.add(vehicle);
            }
        }
        return result;
    }
    
    // 3. get method in HashMap        
    public HashMap<String, Vehicle> getVehicleFromMap(String ownerID){
        return vehicleMap.get(ownerID);
    }
    
    // 4. remove method
    public void removeVehicle(String vehicleID){
        for(int i = 0; i < vehicleList.size(); i++){
            if(vehicleList.get(i).getVehicleID().equals(vehicleID)){
                vehicleList.remove(i);
            }
        }
        for(Map.Entry ownerMap: vehicleMap.entrySet()){
            ((HashMap<String, Vehicle>)ownerMap.getValue()).remove(vehicleID);
        }
        
    }

    // 5. print method
    public void printVehicleTax(){
        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.getOwnerID() + " Taxation Infomation");
            System.out.println(String.format("%-20s %-20s", "Owner ID: ", vehicle.getOwnerID()));
            System.out.println(String.format("%-20s %-20s", "Vehicle ID: ", vehicle.getVehicleID()));
            System.out.println(String.format("%-20s %1.2f %s", "Range: ", vehicle.calcRange(), "km"));
            System.out.println(String.format("%-20s %s %-1.2f", "Tax: ", "$", vehicle.calcTax()));
            System.out.println("***********************************************");
        }
    }
    
    // 6. This method will call getVehicleFromList method and print if find.
    public void findFromListAndPrint(String ownerID) {
        System.out.println(">>Find from ArrayList");
        System.out.println();
        if(getVehicleFromList(ownerID) != null && !getVehicleFromList(ownerID).isEmpty()) {
            for(Vehicle v : getVehicleFromList(ownerID)) {
                System.out.println("Find Infomation of " + ownerID);
                v.print();
            }
        } else {
            System.out.println("Can not find Information of " + ownerID);
            System.out.println("***********************************************");
        }
    }
    
    // 7. This method will call getVehicleFromMap method and print if find.
    public void findFromMapAndPrint(String ownerID) {
        System.out.println(">>Find from Map");
        System.out.println();
        if(getVehicleFromMap(ownerID) != null && !getVehicleFromMap(ownerID).isEmpty()) {
            for(Map.Entry v : getVehicleFromMap(ownerID).entrySet()) {
                System.out.println("Find Infomation of " + ownerID);
                ((Vehicle)v.getValue()).print();
            }
        } else {
            System.out.println("Can not find Information of " + ownerID);
            System.out.println("***********************************************");
        }
    }
}
