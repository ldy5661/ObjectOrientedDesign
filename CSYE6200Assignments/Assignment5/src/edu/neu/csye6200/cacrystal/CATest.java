/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.util.Scanner;

/**
 *
 * NUID: 001632075
 * @author Dongyue Li
*/
public class CATest {
    private CAFlakeSet flakeSet;

    public CATest() {
        flakeSet = new CAFlakeSet();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);        
        boolean done = false;
        while(!done) {
            try{
                System.out.println("Hi, What kind of Snowflake would you like? Press \'1\' to start or Press \'quit\' to leave. ");
                String inchar0 = sc.nextLine();
                switch (inchar0) {
                    case "quit":
                        done = true;
                        break;
                    case "1":
                        System.out.println("Please tell me the environment temperature in degrees Celsius(ºC).");
                        double temperature = Double.parseDouble(sc.nextLine());
                        if (temperature >= 0.0) {
                            System.out.println("Sorry, Can not generate Snowflake at this environment temperature. Please try number below 0.");
                            continue;
                        }
                        System.out.println("Flake Size (Please enter odd number)");
                        int flakeSize = Integer.parseInt(sc.nextLine());
                        System.out.println("How many Snowflakes do you want?");
                        int generateNumber = Integer.parseInt(sc.nextLine());
//                        flakeSet.displayFlakes_BasicRule(temperature, flakeSize, generateNumber);
//                        flakeSet.displayFlakes_OddEvenRule(temperature, flakeSize, generateNumber);
                        flakeSet.displayFlakes_MixAllRules(temperature, flakeSize, generateNumber);
                        done = false;
                        break;
                    default:
                        System.out.println("Wrong Input, Please try again");
                        done = false;
                        break;
                }
            } catch (Exception e) {
//                e.printStackTrace(); // print stack trace if you can not find error by yourself
                done = false;
                System.out.println("Wrong Input, Please try again");
            }
        }
        
    }
    
    public static void main(String[] args) {
        CATest test = new CATest();
        test.run();
    }
}
