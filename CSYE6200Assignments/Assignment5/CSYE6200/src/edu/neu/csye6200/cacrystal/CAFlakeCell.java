/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

/**
 *
 * @author dongyueli
 */
public class CAFlakeCell {
    private int filled = 0;
   

    public CAFlakeCell(int filled) {
        this.filled = filled;
    }
    
    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }
}
