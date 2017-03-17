/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.util.ArrayList;

/**
 *
 * @author dongyueli
 */
public class CAFlakeSet {
    private ArrayList<CAFlake> flakes;
    private CARule rule;

    public CAFlakeSet() {
        flakes = new ArrayList<>();
        rule = new CARule();
    }
    
    public void displayFlakes(int flakeSize, int generateNum) {
        int count = 0;
        
        CAFlake currentFlake = new CAFlake(flakeSize);
        if(currentFlake.isInit() == false) {
            currentFlake = rule.initFlake(flakeSize);
        }
                rule.initFlake(flakeSize);
        for (int i = 0; i < generateNum; i++) {
            flakes.add(currentFlake);
            currentFlake = rule.generateNextFlake(flakeSize, currentFlake);
        }

        for (CAFlake flake : flakes) {
            System.out.println("Flake #" + count);
            flake.displayFlake(flake);
            count++;
        }
    }
    
}
