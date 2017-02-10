/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author dongyueli
 */
public class TaxRegistryIO {
  
    // save single vehicle
    private void save(Vehicle v, String fileName) {
        String base = "src/Assignment3/Assignment3_IO/";
        BufferedReader reader = null;
        try {
            File file = new File(base + fileName);
            if (file.exists()) {
                reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] splits = line.split("\t");
                    if(splits[1].equals(v.getVehicleID())) {
                        System.out.println("Can not save Vehicle ID: " + v.getVehicleID() + " already exist!");
                        System.out.println("***********************************************");
                        return;
                    }
                }
            }
            
            FileWriter writer = new FileWriter(base + fileName, true);
            writer.write(v.getOwnerID() + "\t" +
                    v.getVehicleID() + "\t" +
                    v.getMake() + "\t" + 
                    v.getModel() + "\t" + 
                    v.getModelYear() + "\t" +
                    v.getPassengers() + "\t" + 
                    v.getValue() + "\t" +
                    v.getFuelType() + "\t");
            if (v instanceof ElectricVehicle) {
                writer.write(
                    ((ElectricVehicle) v).getBatteryCapacity() + "\t" +
                    ((ElectricVehicle) v).getRangeEfficiency() + "\n");
            } else if (v instanceof HybridVehicle) {
                writer.write(
                    ((HybridVehicle) v).getFuelCap() + "\t" +
                    ((HybridVehicle) v).getKpl() + "\t" +
                    ((HybridVehicle) v).getBatteryCapacity() + "\t" + 
                    ((HybridVehicle) v).getRangeEfficiency() + "\n");
            }else{
                writer.write(
                    ((GasVehicle) v).getFuelCap() + "\t" +
                    ((GasVehicle) v).getKpl() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Save Vehicle ID: " + v.getVehicleID() + " Info successfully!");
        System.out.println("***********************************************");
    }
    
    // save list vehicles
    public void save(ArrayList<Vehicle> list, String fileName) {
        for(Vehicle v: list){
            save(v, fileName);
        }
    }
    
    // load list vehicles
    public VehicleTaxation load(String fileName) {
        VehicleTaxation vt = new VehicleTaxation();
        String base = "src/Assignment3/Assignment3_IO/";
        BufferedReader reader = null;
        int count = 0;
        try{
            File file = new File(base + fileName);
            if (file.exists()) {
                reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] splits = line.split("\t");
                    String ownerID = splits[0];
                    String vehicleID = splits[1]; 
                    String make = splits[2];
                    String model = splits[3];
                    int modelYear = Integer.parseInt(splits[4]);
                    int passengers = Integer.parseInt(splits[5]);
                    double value = Double.parseDouble(splits[6]);
                    String fuelType = splits[7];
                    if (splits[7].equals("Gas")) {
                        int fuelCap = Integer.parseInt(splits[8]);
                        double kpl = Double.parseDouble(splits[9]);
                        Vehicle gas_v = new GasVehicle(ownerID, vehicleID, make, model, modelYear, passengers, value, fuelType, fuelCap, kpl);
                        vt.addVehicle(gas_v);
                    } else if (splits[7].equals("Electricity")) {
                        int batteryCapacity = Integer.parseInt(splits[8]);
                        double rangeEfficiency = Double.parseDouble(splits[9]);
                        Vehicle e_v = new ElectricVehicle(ownerID, vehicleID, make, model, modelYear, passengers, value, fuelType, batteryCapacity, rangeEfficiency);
                        vt.addVehicle(e_v);
                    } else {
                        int fuelCap = Integer.parseInt(splits[8]);
                        double kpl = Double.parseDouble(splits[9]);
                        int batteryCapacity = Integer.parseInt(splits[10]);
                        double rangeEfficiency= Double.parseDouble(splits[11]);
                        Vehicle h_v = new HybridVehicle(ownerID, vehicleID, make, model, modelYear, passengers, value, fuelType, fuelCap, kpl, batteryCapacity, rangeEfficiency);
                        vt.addVehicle(h_v);
                    }
                    count++;
                }
            } else {
                System.out.println("Loaded error! File not found!");
                System.out.println("***********************************************");
            }
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Loaded "+ count + " Vehicles Info successfully");
        System.out.println("***********************************************");
        return vt;
    }
}
