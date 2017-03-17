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
public interface CARuleI {
    public CAFlake initFlake(int flakeSize);
    public CAFlake generateNextFlake(int flakeSize, CAFlake current);
}
