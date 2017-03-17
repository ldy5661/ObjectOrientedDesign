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
public class CAFlake {
    private CAFlakeCell[][] cells;
    private boolean init = false;

    public CAFlake(int flakeSize) {
        cells = new CAFlakeCell[flakeSize][flakeSize];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = new CAFlakeCell(0);
            }
        }
    }

    public CAFlakeCell[][] getCells() {
        return cells;
    }

    public void setCells(CAFlakeCell[][] cells) {
        this.cells = cells;
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }
    

    public void displayFlake(CAFlake flake) {
        for (int i = 0; i < flake.getCells().length; i++) {
            for (int j = 0; j < flake.getCells()[0].length; j++) {                
                if (flake.getCells()[i][j].getFilled() == 0) {
                    System.out.print("□ ");
                }
                if (flake.getCells()[i][j].getFilled() == 1) {
                    System.out.print("■ ");
                }
            }
            System.out.println();
        }
    }
    
    
    
    
}
