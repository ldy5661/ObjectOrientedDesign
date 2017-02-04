/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dongyueli
 */
public class VehicleTaxation {
    private ArrayList<Vehicle> vehicleList;
    private HashMap<String, ArrayList<Vehicle>> vehicleMap;

    public VehicleTaxation() {
        vehicleList = new ArrayList<>();
        vehicleMap = new HashMap<>();
    }
    
    
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
            vehicleMap.put(v.getOwnerID(), new ArrayList<Vehicle>());
        }
        vehicleMap.get(v.getOwnerID()).add(v);
    }

    public ArrayList<Vehicle> getVehicleFromList(String ownerID){
        ArrayList<Vehicle> result = new ArrayList<>();
        for(Vehicle vehicle: vehicleList){
            if(ownerID.equals(vehicle.getOwnerID())){
                result.add(vehicle);
            }
        }
        return result;
    }
    
    public void removeVehicle(String ownerID){
        vehicleMap.remove(ownerID);
        for(Vehicle vehicle: vehicleList){
            if(ownerID.equals(vehicle.getOwnerID())){
                vehicleList.remove(vehicle);
            }
        }
    }
        
    public ArrayList<Vehicle> getVehicleFromMap(String ownerID){
        return vehicleMap.get(ownerID);
    }
    
    public void printVehicleTax(){
        for(Vehicle vehicle: vehicleList){
            System.out.println(vehicle.getOwnerID() + " Info");
            System.out.println("Owner ID: " + vehicle.getOwnerID());
            System.out.println("Range: " + vehicle.calcRange());
            System.out.println("Tax: " + vehicle.calcTax());
            System.out.println("***********************************************");
        }
    }
    
    public void findFromListAndPrint(String ownerID) {
        System.out.println(">>Find from ArrayList");
        if(getVehicleFromList(ownerID) != null) {
            for(Vehicle v : getVehicleFromList(ownerID)) {
                System.out.println("Infomation of " + ownerID);
                v.print();
            }
        } else {
            System.out.println("Can not found Information of " + ownerID);
            System.out.println("***********************************************");
        }
    }
    
    public void findFromMapAndPrint(String ownerID) {
        System.out.println(">>Find from Map");
        if(getVehicleFromMap(ownerID) != null) {
            for(Vehicle v : getVehicleFromMap(ownerID)) {
                System.out.println("Infomation of " + ownerID);
                v.print();
            }
        } else {
            System.out.println("Can not found Information of " + ownerID);
            System.out.println("***********************************************");
        }
    }
}
