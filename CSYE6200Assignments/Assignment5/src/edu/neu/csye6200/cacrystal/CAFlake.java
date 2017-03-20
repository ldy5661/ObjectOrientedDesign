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
public class CAFlake {
    private CAFlakeCell[][] cells;
    private boolean init = false;  //check initiate or not
    // pick one flake and backgroound color as you like
    public static final String BRIGHT_BLACK = "\u001b[30;1m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String WHITE = "\u001b[37m";
    public static final String	BACKGROUND_BRIGHT_BLUE	= "\u001b[44;1m";
    //    public static final String	BACKGROUND_BLUE	= "\u001B[44m";
    

    public CAFlake(int flakeSize) {
        cells = new CAFlakeCell[flakeSize][flakeSize];
        for (int i = 0; i < flakeSize; i++) {
            for (int j = 0; j < flakeSize; j++) {
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
                    System.out.print(BACKGROUND_BRIGHT_BLUE + "  " + ANSI_RESET);
//                    System.out.print(BRIGHT_BLACK + " " + ANSI_RESET + " "); //"□"
                }
                if (flake.getCells()[i][j].getFilled() == 1) {
                    // if you can not see snowflake sign you can use "■" instead
                    System.out.print(BACKGROUND_BRIGHT_BLUE + WHITE + "❆ " + ANSI_RESET); //"■", 
                }
            }
            System.out.println();
        }
    }
    
}
