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
public interface CARuleI {
    public CAFlake initFlake(int flakeSize, double heat);
    public CAFlake generateNextFlake(CAFlake current);
}
