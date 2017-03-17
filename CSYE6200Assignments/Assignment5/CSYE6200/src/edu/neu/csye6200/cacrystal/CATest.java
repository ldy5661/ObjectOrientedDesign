/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.util.Scanner;

/**
 *
 * @author dongyueli
 */
public class CATest {
    private CAFlakeSet flakeSet = new CAFlakeSet();
    
    private void run() {
        Scanner sc = new Scanner(System.in);        
        boolean done = false;
        while(!done) {
            try{
                System.out.println("Flake Size");
                int flakeSize = Integer.parseInt(sc.nextLine());
                System.out.println("How many Snowflake do you want?");
                int generateNumber = Integer.parseInt(sc.nextLine());
                flakeSet.displayFlakes(flakeSize, generateNumber);
                done = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void main(String[] args) {
        CATest test = new CATest();
        test.run();
    }
}
