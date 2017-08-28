/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1;

import java.util.Scanner;

/**
* A starter file for implementing CSYE 6200 Assignment 1
* Filename: Assign1.java
* NUID: 001632075
* @author Dongyue Li
*/
public class Assign1 {
// both readLine() and Scanner work well.    
//    static String readLine() throws java.io.IOException {
//        String retStr = "";
//        char inChar;
//        while ( (inChar = (char) System.in.read()) >= ' ') { // Let's take anything greater than an ASCII space (32)
//            retStr = retStr + inChar; // Add each character to our String
//        }
//        return retStr; // OK, we're done. Return the input string
//    }
    public static void main(String[] args) throws java.io.IOException {
        String accounts[][] = {  {"dongyueli", "1575", "12000.00"},  {"ldy", "7721", "300.00"},  {"dyl",  "3884", "700.00"}};

        Scanner sc = new Scanner(System.in);   //commit by ldy
        boolean authorized = false;
        String authorizedUser = null;
        int authorizedUserIndex = -1;
        while(authorized == false){
            System.out.println("Please Enter Username: ");
            String user = sc.nextLine();
//        String user = readLine();
            System.out.println("Please Enter PIN Number: ");
            try{
                String passStr = sc.nextLine();
//                String passStr = readLine();
                int pass = Integer.parseInt(passStr);
                
                for(int i = 0; i < accounts.length; i++){
                    if(user.equals(accounts[i][0]) && pass==Integer.parseInt(accounts[i][1])){
                        authorized = true;
                        authorizedUser = accounts[i][0];
                        authorizedUserIndex = i;
                        break;
                    }
                }
                if(authorized == false){
                    System.out.println("Wrong Username or PIN Number. Try again: ");
                }
            }catch(Exception e){
                System.out.println("PIN Should be Number Only!");
            }
        }
        
        if(authorized == true && authorizedUser!= null && authorizedUserIndex >= 0){
            String inChar = "";
            do {
                System.out.println("Welcome " + authorizedUser +" Please enter 1 for account balance, 2 for Obtain cash, 3 for quit");                
                inChar = sc.nextLine();
//                inChar = readLine();
                if(inChar.equals("1") || inChar.equals("2") || inChar.equals("3")){
                    switch(inChar){
                        case "1": System.out.println("You have: " + accounts[authorizedUserIndex][2] + " dollars");
                            break;
                        case "2": 
                            System.out.println("Please enter the amount you need: ");
                            boolean  validInput = false;
                            while(!validInput) {
                                try{
                                    int amount = Integer.parseInt(sc.nextLine());
//                                    int amount = Integer.parseInt(readLine());
                                    int amountWithDraw = amount;
                                    if(amount > Double.parseDouble(accounts[authorizedUserIndex][2])){
                                        System.out.println("Amount cannot greater than your balance! Please Enter Again !");
                                        continue;
                                    }
                                    if(amount > 200){
                                        System.out.println("Amount cannot greater than 200 for one transection! Please Enter Again !");
                                        continue;
                                    }
                                    validInput = true;
                                    if(amount % 20 == 0 && amount >= 20){
                                        System.out.println("$20 bill: " + (amount / 20));
                                        accounts[authorizedUserIndex][2] = String.valueOf(Double.parseDouble(accounts[authorizedUserIndex][2]) - amountWithDraw);                           
                                        System.out.println("You are all set!");
                                        break;
                                    }
                                    else if(amount >= 20){
                                        System.out.println("$20 bill: " + (amount / 20));
                                        amount = amount % 20;
                                    }

                                    if(amount % 10 == 0 && amount >= 10){
                                        System.out.println("$10 bill: " + (amount / 10));
                                        accounts[authorizedUserIndex][2] = String.valueOf(Double.parseDouble(accounts[authorizedUserIndex][2]) - amountWithDraw);                                    
                                        System.out.println("You are all set!");
                                        break;
                                    }
                                    else if(amount >= 10){
                                        System.out.println("$10 bill: " + (amount / 10));
                                        amount = amount % 10;
                                    }

                                    if(amount % 5 == 0 && amount >= 5){
                                        System.out.println("$5 bill: " + (amount / 5));
                                        accounts[authorizedUserIndex][2] = String.valueOf(Double.parseDouble(accounts[authorizedUserIndex][2]) - amountWithDraw);                                    
                                        System.out.println("You are all set!");
                                        break;
                                    }
                                    else if(amount >= 5){
                                        System.out.println("$5 bill: " + (amount / 5));
                                        amount = amount % 5;
                                    }

                                    if(amount > 0){
                                        System.out.println("$1 bill: " + (amount / 1));
                                        System.out.println("You are all set!");
                                    }
                                    
                                    accounts[authorizedUserIndex][2] = String.valueOf(Double.parseDouble(accounts[authorizedUserIndex][2]) - amountWithDraw);                                    
                                    break;                           
                                }
                                catch(Exception e){
                                    System.out.println("Integer Only ! Please Enter Again !");
                                }
                            }
                    }
                } else {
                    System.out.println("Wrong input!");
                }
            } 
            while (!inChar.equals("3")); // Exit on quit
            System.out.println("Quiting...");
        }   
    } 

}
