/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * NUID: 001632075
 * @author Dongyue Li
*/
public class CAFlakeSet extends Observable implements Runnable{
    private ArrayList<CAFlake> flakes;
    private int flakeSize;
    private int generateNumber;
    private double temperature;
    private int ruleNumber;
    private CARuleI rule;
    private CARule_Rect_Basic basic;
    private CARule_Rect_OddEven oddeven;
    
    /**
     * Generate a list of flakes based on ruleNumber, generate number and environment temperature
     * @param ruleNumber  1: rectangle basic rule, 2: rectangle odd even rule, 3/4: mix 1 and 2, 5: hexagon odd even rule
     * @param flakeSize the number of flakeSize rows and columns
     * @param generateNumber number of flakes you want to generate
     * @param temperature environment temperature in degrees Celsius(ºC)
     */
    public CAFlakeSet(int ruleNumber, int flakeSize, int generateNumber, double temperature) {
        this.flakeSize = flakeSize;
        this.generateNumber = generateNumber;
        this.temperature = temperature;
        flakes = new ArrayList<>();
        
        // check with rule apply
        if (ruleNumber == 1) {
            rule = new CARule_Rect_Basic();
        } else if (ruleNumber == 2) {
            rule = new CARule_Rect_OddEven();
        } else if (ruleNumber == 3 || ruleNumber == 4) {
            basic = new CARule_Rect_Basic();
            oddeven = new CARule_Rect_OddEven();
        } else if (ruleNumber == 5) {
            rule = new CARule_Hex_OddEven();
        }
        this.ruleNumber = ruleNumber;

    }
    
    /**
     * Thread for Dynamic drawing.
     */
    @Override
    public void run() {
        int counter = 0;
        if (ruleNumber == 3 || ruleNumber == 4) {
            CAFlake currentFlake = new CAFlake(flakeSize);
            if(currentFlake.isInit() == false) {
                currentFlake = basic.initFlake(flakeSize, temperature);
            }        
            for (int i = 0; i < generateNumber; i++) {
                flakes.add(currentFlake);
                setChanged();
                notifyObservers(++counter);
//                notifyObservers(currentFlake);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CAFlakeSet.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (i < 16) {
                    currentFlake = oddeven.generateNextFlake(currentFlake);
                } else {
                    currentFlake = basic.generateNextFlake(currentFlake); 
                }                
            }            
        } else {
            CAFlake currentFlake = new CAFlake(flakeSize);
            if(currentFlake.isInit() == false) {
                currentFlake = rule.initFlake(flakeSize, temperature);
            }        
            for (int i = 0; i < generateNumber; i++) {
                flakes.add(currentFlake);
                setChanged();
                notifyObservers(++counter);
//                notifyObservers(currentFlake);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CAFlakeSet.class.getName()).log(Level.SEVERE, null, ex);
                }
                currentFlake = rule.generateNextFlake(currentFlake);
            }        
        }

    }
    
    // get latest generated flake from flakeSet arraylist
    public CAFlake getLatestFlake() {
        if (flakes.size() > 0) {
            return flakes.get(flakes.size() - 1);
        } else {
            return null;
        }
    } 
         
}
