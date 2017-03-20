/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

/**
 *
 * NUID: 001632075
 * @author Dongyue Li
*/
public class CAFlakeCell {
    /*
    Snowflakes are formed when water vapor in a cloud freezes into ice, and that the 
    structure of a given snowflake is determined by the temperature and humidity of
    the environment in which it grows, and the length of itme it spends there. Whenever 
    a piece of ice is added to the snowflake, there is some heat released, which then 
    tends to inhibit the addition of further pieces of ice nearby.When water or water vapor 
    freezes into ice, it releases a certain amount of latent heat as the reverse of the 
    phenomenon that when ice is warmed to 0 ºC it still needs heat applied before it will actually melt.
    */
    private int filled = 0; // cell filled with ice as 1 or gas as 0
    private double heat = 0; // assume that the rate of heat conduction keep same in different direction on the grid

    // each cell on the grid may have different heat value, so we will use setHeat() method to initiate heat value later
    public CAFlakeCell(int filled) { 
        this.filled = filled;
    }
    
    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    public double getHeat() {
        return heat;
    }

    public void setHeat(double heat) {
        this.heat = heat;
    }
    
}
