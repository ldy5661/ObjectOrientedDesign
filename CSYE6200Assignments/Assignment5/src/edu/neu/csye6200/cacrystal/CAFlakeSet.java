/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.util.ArrayList;

/**
 *
 * NUID: 001632075
 * @author Dongyue Li
*/
public class CAFlakeSet {
    private ArrayList<CAFlake> flakes;
    private CARule_Basic basicRule;
    private CARule_OddEven oddEvenRule;
    
    
    public CAFlakeSet() {
        flakes = new ArrayList<>();
        basicRule = new CARule_Basic();
        oddEvenRule = new CARule_OddEven();
    }
    
    public void displayFlakes_BasicRule(double heat, int flakeSize, int generateNum) {
        int count = 0;
        
        CAFlake currentFlake = new CAFlake(flakeSize);
        if(currentFlake.isInit() == false) {
            currentFlake = basicRule.initFlake(flakeSize, heat);
        }
        
        for (int i = 0; i < generateNum; i++) {
            flakes.add(currentFlake);
            currentFlake = basicRule.generateNextFlake(currentFlake);
        }

        for (CAFlake flake : flakes) {
            System.out.println("Flake #" + count);
            flake.displayFlake(flake);
            count++;
        }
        flakes.clear();
    }
    
    public void displayFlakes_OddEvenRule(double heat, int flakeSize, int generateNum) {
        int count = 0;
        
        CAFlake currentFlake = new CAFlake(flakeSize);
        if(currentFlake.isInit() == false) {
            currentFlake = oddEvenRule.initFlake(flakeSize, heat);
        }
        
        for (int i = 0; i < generateNum; i++) {
            flakes.add(currentFlake);
            currentFlake = oddEvenRule.generateNextFlake(currentFlake);
        }

        for (CAFlake flake : flakes) {
            System.out.println("Flake #" + count);
            flake.displayFlake(flake);
            count++;
        }
        flakes.clear();
    }
//    
//    public void displayFlakes_RandomAllRule(double heat, int flakeSize, int generateNum) {
//        int count = 0;
//        CAFlake currentFlake = new CAFlake(flakeSize);
//        if(currentFlake.isInit() == false) {
//            currentFlake = oddEvenRule.initFlake(flakeSize, heat);
//        }
//        
//        for (int i = 0; i < generateNum; i++) {
//            flakes.add(currentFlake);
//            if (Math.random() < 0.5) {
//                currentFlake = basicRule.generateNextFlake(currentFlake);
//            } else {
//                currentFlake = oddEvenRule.generateNextFlake(currentFlake);
//            }
//        }
//
//        for (CAFlake flake : flakes) {
//            System.out.println("Flake #" + count);
//            flake.displayFlake(flake);
//            count++;
//        }
//        flakes.clear();
//    }
//                
    public void displayFlakes_MixAllRules(double heat, int flakeSize, int generateNum) {
        int count = 0;
        
        CAFlake currentFlake = new CAFlake(flakeSize);
        if(currentFlake.isInit() == false) {
            currentFlake = basicRule.initFlake(flakeSize, heat);
        }
        
        for (int i = 0; i < generateNum; i++) {
            flakes.add(currentFlake);
            if (i < 16) {
                currentFlake = basicRule.generateNextFlake(currentFlake);
            } else {
                currentFlake = oddEvenRule.generateNextFlake(currentFlake); 
            }
        }

        for (CAFlake flake : flakes) {
            System.out.println("Flake #" + count);
            flake.displayFlake(flake);
            count++;
        }
        flakes.clear();
    }
}
