/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
/**
 * This example, like all Swing examples, exists in a package:
 * in this case, the "start" package.
 * If you are using an IDE, such as NetBeans, this should work
 * seamlessly.  If you are compiling and running the examples
 * from the command-line, this may be confusing if you aren't
 * used to using named packages.  In most cases,
 * the quick and dirty solution is to delete or comment out
 * the "package" line from all the source files and the code
 * should work as expected.  For an explanation of how to
 * use the Swing examples as-is from the command line, see
 * http://docs.oracle.com/javase/javatutorials/tutorial/uiswing/start/compile.html#package
 */
package com.salemelrahal.cassy.swing.main;
 
/*
 * HelloWorldSwing.java requires no other files.
 */
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.gol.seeds.Seeds;
import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.cassy.swing.button.ChooseSimulationActionListener;
import com.salemelrahal.cassy.swing.button.StartGameActionListener;
import com.salemelrahal.cassy.swing.canvas.DisplayGrid;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;
import com.salemelrahal.cassy.swing.mouse.BinaryMouseAdapter;
import com.salemelrahal.gol.game.impl.Game;
import com.salemelrahal.gol.simulation.impl.SimulationRegistry;
 
public class HelloWorldSwing {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
    	
    	int canvasHeight = 200;
    	int canvasWidth = 200;
    	Simulation simulation = new Seeds();
    	SimulationContainer simulationContainer = new SimulationContainer(simulation);
    	DisplayGrid displayGrid = new DisplayGrid(canvasHeight, canvasWidth, simulationContainer);
    	displayGrid.addMouseListener(new BinaryMouseAdapter(displayGrid));
    	displayGrid.addMouseMotionListener(new BinaryMouseAdapter(displayGrid));
    	
    	
    	
        //Create and set up the window.
    	System.out.println("Created GUI on EDT? "+
    	        SwingUtilities.isEventDispatchThread());
    	JSlider slider = new JSlider(JSlider.HORIZONTAL, 10, 1000, 500);
//    	slider.addChangeListener(this);
    	 
        //Turn on labels at major tick marks.
 
    	slider.setMajorTickSpacing(100);
    	slider.setMinorTickSpacing(10);
    	slider.setPaintTicks(true);
    	slider.setPaintLabels(true);
    	slider.setBorder(
                BorderFactory.createEmptyBorder(0,0,10,0));
        Font font = new Font("Serif", Font.ITALIC, 5);
        slider.setFont(font);
        
        JComboBox simulationList = new JComboBox(SimulationRegistry.getSimulations().toArray());
        simulationList.addActionListener(new ChooseSimulationActionListener(displayGrid));
    	
    	
    	JPanel buttons = new JPanel();
    	buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        JFrame frame = new JFrame("HelloWorldSwing");
        JButton start = new JButton("Start");
        start.setActionCommand("start");
        JButton stop = new JButton("Stop");
        stop.setActionCommand("stop");
        JButton step = new JButton("Step");
        step.setActionCommand("step");
        JButton clear = new JButton("Clear");
        clear.setActionCommand("clear");
        ActionListener actionListener = new StartGameActionListener(simulationContainer, displayGrid, slider);
        start.addActionListener(actionListener);
        stop.addActionListener(actionListener);
        step.addActionListener(actionListener);
        clear.addActionListener(actionListener);
        
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 600);
        
        frame.getContentPane().add(displayGrid);
        
        buttons.add(start);
        buttons.add(stop);
        buttons.add(step);
        buttons.add(clear);
        buttons.add(slider);
        buttons.add(simulationList);
        frame.add(buttons);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        System.out.println("DONE?");
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}