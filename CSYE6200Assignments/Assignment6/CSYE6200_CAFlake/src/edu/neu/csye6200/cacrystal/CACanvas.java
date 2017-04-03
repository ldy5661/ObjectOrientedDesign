/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * Snowflake canvas that observes CAFlakeSet changing and draws snowflakes based on ruleNumber
 * NUID: 001632075
 * @author Dongyue Li
*/
public class CACanvas extends JPanel implements Observer{
    private CAFlakeSet flakeSet;
    private int ruleNumber;
    private int counter;
    
    public CACanvas(CAFlakeSet flakeSet, int ruleNumber) {
        flakeSet.addObserver(this);
        this.flakeSet = flakeSet;
        this.ruleNumber = ruleNumber;
    }
   
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCanvas(g);
    }
    
    /**
     * Draw snowflake
     * @param g 
     */
    private void drawCanvas(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        g2d.setColor(Color.orange);
        g2d.fillRect(0, 0, size.width, size.height);

        CAFlake flake = flakeSet.getLatestFlake();
        if (flake == null) {
            return;
        } 
        int flakeSize = flake.getCells().length;
        // Responsive cellsize. According to current panel size, adjust cellsize.
        int cellSize =  (size.height / flakeSize) - 2;
        
        int mid = flakeSize / 2;
        
        // hexagon
        if (ruleNumber == 5) {
            if(counter == 1 || counter == 2 || counter == 3 || counter ==6) {
                for (int j = 0; j < mid; j++) {
                    paintSpace(g2d, 0, j * (cellSize + 2), (mid - j) * (cellSize / 2), cellSize, Color.WHITE);
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2) + (mid - j) * (cellSize / 2), j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2) + (mid - j) * (cellSize / 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }
                }
                for (int j = mid; j < flakeSize; j++) {
                    paintSpace(g2d, 0, j * (cellSize + 2), (j - mid) * (cellSize / 2), cellSize, Color.WHITE);
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2) + (j - mid) * (cellSize / 2), j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2) + (j - mid) * (cellSize / 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }
                }             
            }                                   
            else{
                for (int j = 0; j < mid - 1; j++) {
                    paintSpace(g2d, 0, j * (cellSize + 2), (mid - j) * (cellSize / 2) + (cellSize / 2), cellSize, Color.WHITE);
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2) + (mid - j) * (cellSize / 2) + (cellSize / 2) , j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2) + (mid - j) * (cellSize / 2) + (cellSize / 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }
                }
                for (int j = mid - 1; j < mid; j++) {
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2), j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }                
                }
                for (int j = mid; j < mid + 1; j++) {
                    paintSpace(g2d, 0, j * (cellSize + 2), (cellSize / 2), cellSize, Color.WHITE);
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2) + (cellSize / 2), j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2) + (cellSize / 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }                
                }            
                for (int j = mid + 1; j < mid + 2; j++) {
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2), j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }                
                }            
                for (int j = mid + 2; j < flakeSize; j++) {
                    paintSpace(g2d, 0, j * (cellSize + 2), (j - mid) * (cellSize / 2) + (cellSize / 2), cellSize, Color.WHITE);
                    for (int i = 0; i < flakeSize; i++) {
                        if (flake.getCells()[j][i].getFilled() == 0) {
                            paintCell(g2d, i * (cellSize + 2) + (j - mid) * (cellSize / 2) + (cellSize / 2), j * (cellSize + 2), cellSize, Color.WHITE);
                        }
                        if (flake.getCells()[j][i].getFilled() == 1) {
                            paintCell(g2d, i * (cellSize + 2) + (j - mid) * (cellSize / 2) + (cellSize / 2), j * (cellSize + 2), cellSize, Color.BLACK);
                        }    
                    }
                }                 
            }
            
        }
        // rectangle
        else {
            for (int j = 0; j < flakeSize; j++) {
                for (int i = 0; i < flakeSize; i++) {
                    if (flake.getCells()[i][j].getFilled() == 0) {
                        paintCell(g2d, i * (cellSize + 2), j * (cellSize + 2), cellSize, Color.WHITE);
                    }
                    Color col = null;
                    if (flake.getCells()[i][j].getFilled() == 1) {
                        if(DongyueLi_SnowflakeApp.addColor) {
                            // draw a rainbow of squares
                            int redVal = validColor(i * 2);
                            int greenVal = validColor(255 - j * 4);
                            int blueVal = validColor(255 - i - j);
                            col = new Color(redVal, greenVal, blueVal);
                        } else if (!DongyueLi_SnowflakeApp.addColor) {
                            // draw black and white squares
                            col = Color.BLACK;
                        }
                        paintCell(g2d, i * (cellSize + 2), j * (cellSize + 2), cellSize, col);
                    }    
                }
            }            
        }

    }
    
    /*
     * A local routine to ensure that the color value is in the 0 to 255 range;
     */
    private int validColor(int colorVal) {
            if (colorVal > 255)
                    colorVal = 255;
            if (colorVal < 0)
                    colorVal = 0;
            return colorVal;
    }
    
    // Paint a single cell
    private void paintCell(Graphics2D g2d, int x, int y, int size, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x, y, size, size);
    }
    
     // Paint a single space
    private void paintSpace(Graphics2D g2d, int x, int y, int width, int height, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
    }
    
    /**
     * Update and repaint canvas by observing CAFlakeSet changing
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        this.counter = (int) arg;
        validate();
        repaint();
    }
}
