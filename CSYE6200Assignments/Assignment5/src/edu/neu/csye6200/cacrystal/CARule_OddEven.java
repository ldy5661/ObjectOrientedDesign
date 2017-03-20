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
public class CARule_OddEven implements CARuleI{
    // When gas freezes into ice, it releases a certain amount of latent heat, here we assume the value would be 0.25
    private double heatReleasd = 0.25;

    @Override
    public CAFlake initFlake(int flakeSize, double heat) {
        CAFlake flakes = new CAFlake(flakeSize);
        for (int i = 0; i < flakeSize; i++) {
            for (int j = 0; j < flakeSize; j++) {
                flakes.getCells()[i][j].setHeat(heat);
            }
        }
        int mid = flakeSize / 2;
        flakes.getCells()[mid][mid].setFilled(1);
        // When gas freezes into ice, the latent heat will affect its neighbors heat value,
        // which then tends to inhibit the addition of further pieces of ice nearby.
        flakes.getCells()[mid - 1][mid].setHeat(heat + heatReleasd);  //top
        flakes.getCells()[mid][mid + 1].setHeat(heat + heatReleasd);  //right
        flakes.getCells()[mid + 1][mid].setHeat(heat + heatReleasd);  //bottom
        flakes.getCells()[mid][mid - 1].setHeat(heat + heatReleasd);  //left
        flakes.setInit(true);
        return flakes;
    }

    
    /**
     * OddEven Rule (tree-like forms, faceted shapes, dendrites forms, needle-like forms, rounded forms)
     * sum of its four neighbors: 0 1 2 3 4
     * status of itself:          0 1 0 1 0
     * Each cell on a grid becomes black on the next step if it is already black or
     * whenever it has odd number of neighbors which was black on the step before,
     * but stay white whenever it has even number of neighbor which was black.
     * @param current current flake
     * @return next flake status based on the current flake status through basic rule
     */

    @Override
    public CAFlake generateNextFlake(CAFlake current) {
        int flakeSize = current.getCells().length;
        CAFlake nextFlake = new CAFlake(flakeSize);
        // Copy current flake
        CAFlake current0 = new CAFlake(flakeSize);
        for (int i = 0; i < flakeSize; i++) {
            for (int j = 0; j < flakeSize; j++) {
                current0.getCells()[i][j].setFilled(current.getCells()[i][j].getFilled());
                current0.getCells()[i][j].setHeat(current.getCells()[i][j].getHeat());
            }
        }
        int rowSize = flakeSize - 1;
        int colSize = flakeSize - 1;
        int top, right, bottom, left;

        for (int i = 0; i <= rowSize; i++) {
            for (int j = 0; j <= colSize; j++) {
                double heat = current0.getCells()[i][j].getHeat();
                // when the heat value >= 0 ºC, no ice will generate in current cell
                if (heat >= 0.0) {
                    nextFlake.getCells()[i][j].setFilled(0);
                    nextFlake.getCells()[i][j].setHeat(heat);
                    current0.getCells()[i][j].setFilled(0);
                    continue;
                }
                if (current0.getCells()[i][j].getFilled() == 1 && heat < 0.0) {
                    nextFlake.getCells()[i][j].setFilled(1);
                    nextFlake.getCells()[i][j].setHeat(heat);
                    continue;
                }
                if (i == 0) {
                    top = 0;
                } else {
                    top = current0.getCells()[i - 1][j].getFilled();
                }
                if (j == colSize) {
                    right = 0;
                } else {
                    right = current0.getCells()[i][j + 1].getFilled();
                }
                if (i == rowSize) {
                    bottom = 0;
                } else {
                    bottom = current0.getCells()[i + 1][j].getFilled();
                }
                if (j == 0) {
                    left = 0;
                } else {
                    left = current0.getCells()[i][j - 1].getFilled();
                }
                
                int sum = top + right + bottom + left;
                
                if (sum % 2 == 0) {
                    nextFlake.getCells()[i][j].setFilled(0);
                    nextFlake.getCells()[i][j].setHeat(heat);
                } else if (sum % 2 == 1) {
                    nextFlake.getCells()[i][j].setFilled(1);
                    nextFlake.getCells()[i][j].setHeat(heat);
                    // When gas freezes into ice, the latent heat will affect its neighbors heat value
                    if (i - 1 >= 0) {
                        current0.getCells()[i - 1][j].setHeat(current0.getCells()[i - 1][j].getHeat() + heatReleasd);  //top
                        nextFlake.getCells()[i - 1][j].setHeat(current0.getCells()[i - 1][j].getHeat());  //top
                    }
                    if (j + 1 <= colSize) {
                        current0.getCells()[i][j + 1].setHeat(current0.getCells()[i][j + 1].getHeat() + heatReleasd);  //right
                        nextFlake.getCells()[i][j + 1].setHeat(current0.getCells()[i][j + 1].getHeat());  //top
                    }
                    if (i + 1 <= rowSize) {
                        current0.getCells()[i + 1][j].setHeat(current0.getCells()[i + 1][j].getHeat() + heatReleasd);  //bottom
                        nextFlake.getCells()[i + 1][j].setHeat(current0.getCells()[i + 1][j].getHeat());  //top
                    }
                    if (j - 1 >= 0) {
                        current0.getCells()[i][j - 1].setHeat(current0.getCells()[i][j - 1].getHeat() + heatReleasd);  //left
                        nextFlake.getCells()[i][j - 1].setHeat(current0.getCells()[i][j - 1].getHeat());  //top
                    }
                }
            }
        }

        return nextFlake;
    }
    
}
