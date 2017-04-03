/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import edu.neu.csye6200.ui.CAApp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * NUID: 001632075
 * @author Dongyue Li
*/

public class DongyueLi_SnowflakeApp extends CAApp{
    private static Logger log = Logger.getLogger(DongyueLi_SnowflakeApp.class.getName());
    public static boolean addColor = false;
    private JPanel northPanel = null;
    private JButton startBtn = null;
    private JButton pauseBtn = null;
    private JButton stopBtn = null;
    private JLabel genCtnLable = null;
    private JTextField stepCntTF = null;
    private JLabel tempLable = null;
    private JTextField tempTF = null;
    private JLabel flakeSizeLable = null;
    private JTextField flakeSizeTF = null;
    private JComboBox<String> ruleCBox = null;
    private CACanvas caPanel = null;
    private Runnable r;
    private Thread t;


    
    public DongyueLi_SnowflakeApp() {
        super.initGUI();
 	frame.setSize(700, 761);
        frame.setTitle("SnowflakeApp by Dongyue Li with NUID: 001632075");
        // Center window
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setResizable(false);
        frame.setVisible(true); // The UI is built, so display it
    }
    

    @Override
    public JPanel getNorthPanel() {
        northPanel = new JPanel();
    	northPanel.setLayout(new FlowLayout());
    	
        startBtn = new JButton("Start");
    	startBtn.addActionListener(this); // Allow the app to hear about button pushes
    	northPanel.add(startBtn);
        
        pauseBtn = new JButton("Pause");
        pauseBtn.setEnabled(false);
        pauseBtn.addActionListener(this); // Allow the app to hear about button pushes
        northPanel.add(pauseBtn);
        
    	stopBtn = new JButton("Stop"); // Allow the app to hear about button pushes
        stopBtn.setEnabled(false);
    	stopBtn.addActionListener(this);
    	northPanel.add(stopBtn);
        
        flakeSizeLable = new JLabel("Size");
        northPanel.add(flakeSizeLable);
        
        flakeSizeTF = new JTextField("65");
        flakeSizeTF.setColumns(2);
        northPanel.add(flakeSizeTF);  // Add Text Field
        
        genCtnLable = new JLabel("GenNum");
        northPanel.add(genCtnLable);
        
        stepCntTF = new JTextField("30");
        stepCntTF.setColumns(2);
        northPanel.add(stepCntTF);  // Add Text Field
        
        tempLable = new JLabel("Temp");
        northPanel.add(tempLable);
        
        tempTF = new JTextField("-10");
        tempTF.setColumns(3);
        northPanel.add(tempTF);  // Add Text Field
        
        ruleCBox = new JComboBox<>();
        ruleCBox.addItem("Please Select Rule");
        ruleCBox.addItem("Rule 1");
        ruleCBox.addItem("Rule 2");
        ruleCBox.addItem("Rule 3");
        ruleCBox.addItem("Rule 4");
        ruleCBox.addItem("Rule 5");
        ruleCBox.addActionListener(this);
        northPanel.add(ruleCBox); // Add ComboBox
        
        northPanel.setBackground(Color.MAGENTA);
    	return northPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        log.info("We received an ActionEvent " + e);
        if (e.getActionCommand().equalsIgnoreCase("Start")) {
            int flakeSize = Integer.parseInt(flakeSizeTF.getText());
            int generateNumber = Integer.parseInt(stepCntTF.getText());
            double temperature = Double.parseDouble(tempTF.getText());
            int ruleNumber = 0;
            // Rule 1: rectangle basic rule
            if (ruleCBox.getSelectedIndex() == 1) {
                addColor = false;
                ruleNumber = 1;
                CAFlakeSet flakeSet = new CAFlakeSet(ruleNumber, flakeSize, generateNumber, temperature);
                caPanel = new CACanvas(flakeSet, ruleNumber);
                this.r = flakeSet;
                t = new Thread(r);
                t.start();
                frame.add(caPanel, BorderLayout.CENTER);
                frame.setVisible(true);
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                stopBtn.setEnabled(true);                     
            }
            // Rule 2: rectangle odd even rule
            if (ruleCBox.getSelectedIndex() == 2) {
                addColor = false;
                ruleNumber = 2;
                CAFlakeSet flakeSet = new CAFlakeSet(ruleNumber, flakeSize, generateNumber, temperature);
                caPanel = new CACanvas(flakeSet, ruleNumber);
                this.r = flakeSet;
                t = new Thread(r);
                t.start();
                frame.add(caPanel, BorderLayout.CENTER);
                frame.setVisible(true);
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                stopBtn.setEnabled(true);                     
            }
            // Rule 3: mix 1 and 2
            if (ruleCBox.getSelectedIndex() == 3) {
                addColor = false;
                ruleNumber = 3;
                CAFlakeSet flakeSet = new CAFlakeSet(ruleNumber, flakeSize, generateNumber, temperature);
                caPanel = new CACanvas(flakeSet, ruleNumber);
                this.r = flakeSet;
                t = new Thread(r);
                t.start();
                frame.add(caPanel, BorderLayout.CENTER);
                frame.setVisible(true);
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                stopBtn.setEnabled(true);                     
            }
            // Rule 4: mix 1 and 2, draw rainbow flakes
            if (ruleCBox.getSelectedIndex() == 4) {
                addColor = true;
                ruleNumber = 4; 
                CAFlakeSet flakeSet = new CAFlakeSet(ruleNumber, flakeSize, generateNumber, temperature);
                caPanel = new CACanvas(flakeSet, ruleNumber);
                this.r = flakeSet;
                t = new Thread(r);
                t.start();
                frame.add(caPanel, BorderLayout.CENTER);
                frame.setVisible(true);
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                stopBtn.setEnabled(true);                     
            }
            // Rule 5: hexagon odd even rule
            if (ruleCBox.getSelectedIndex() == 5) {
                addColor = false;
                ruleNumber = 5;
                CAFlakeSet flakeSet = new CAFlakeSet(ruleNumber, flakeSize, generateNumber, temperature);
                caPanel = new CACanvas(flakeSet, ruleNumber);
                this.r = flakeSet;
                t = new Thread(r);
                t.start();
                frame.add(caPanel, BorderLayout.CENTER);
                frame.setVisible(true);
                startBtn.setEnabled(false);
                pauseBtn.setEnabled(true);
                stopBtn.setEnabled(true);                     
            }             
        }
        if (e.getActionCommand().equalsIgnoreCase("Pause")) {
            t.suspend();
            pauseBtn.setText("Unpause");
            startBtn.setEnabled(false);
            pauseBtn.setEnabled(true);
            stopBtn.setEnabled(true);
        }
        if (e.getActionCommand().equalsIgnoreCase("Unpause")) {
            t.resume();
            pauseBtn.setText("Pause");
            startBtn.setEnabled(false);
            pauseBtn.setEnabled(true);
            stopBtn.setEnabled(true);
        }
        if(e.getActionCommand().equalsIgnoreCase("Stop")) {
            t.stop();
            pauseBtn.setText("Pause");
            startBtn.setEnabled(true);
            pauseBtn.setEnabled(false);
            stopBtn.setEnabled(false);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        log.info("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
        log.info("Window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        log.info("Window deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        log.info("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        log.info("Window deactivated");
    }
    
    /**
     * Dongyue Li Snowflake application starting point
     * @param args 
     */
    public static void main(String[] args) {
            DongyueLi_SnowflakeApp snowflakeApp = new DongyueLi_SnowflakeApp();
            log.info("SnowflakeApp started");
    }
    
}
