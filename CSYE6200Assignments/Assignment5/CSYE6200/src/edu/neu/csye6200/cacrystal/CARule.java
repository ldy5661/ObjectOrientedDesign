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
public class CARule implements CARuleI{

    @Override
    public CAFlake initFlake(int flakeSize) {
        CAFlake flakes = new CAFlake(flakeSize);
        int mid = flakes.getCells().length / 2;
        flakes.getCells()[mid][mid].setFilled(1);
        flakes.setInit(true);
        return flakes;
    }

    @Override
    public CAFlake generateNextFlake(int flakeSize, CAFlake current) {
        CAFlake nextFlake = new CAFlake(flakeSize);

        int rowSize = current.getCells().length - 1;
        int colSize = current.getCells()[0].length - 1;
        int top, right, bottom, left;

        for (int i = 0; i <= rowSize; i++) {
            for (int j = 0; j <= colSize; j++) {
                if (current.getCells()[i][j].getFilled() == 1) {
                    nextFlake.getCells()[i][j].setFilled(1);
                    continue;
                }
                if (i == 0) {
                    top = 0;
                } else {
                    top = current.getCells()[i - 1][j].getFilled();
                }
                if (j == colSize) {
                    right = 0;
                } else {
                    right = current.getCells()[i][j + 1].getFilled();
                }
                if (i == rowSize) {
                    bottom = 0;
                } else {
                    bottom = current.getCells()[i + 1][j].getFilled();
                }
                if (j == 0) {
                    left = 0;
                } else {
                    left = current.getCells()[i][j - 1].getFilled();
                }
                
                int sum = top + right + bottom + left;
                
                if (sum % 2 == 0) {
                    nextFlake.getCells()[i][j].setFilled(0);
                } else if (sum % 2 == 1) {
                    nextFlake.getCells()[i][j].setFilled(1);
                }
            }
        }

        return nextFlake;
    }
    
}
