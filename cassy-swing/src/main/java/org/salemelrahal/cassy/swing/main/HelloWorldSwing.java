package org.salemelrahal.cassy.swing.main;
 
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

import org.salemelrahal.cassy.simulation.Simulation;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.grid.GridFactory;
import org.salemelrahal.cassy.simulation.impl.SimulationRegistry;
import org.salemelrahal.cassy.simulation.model.life.LifeSimulation;
import org.salemelrahal.cassy.swing.button.ChooseScaleActionListener;
import org.salemelrahal.cassy.swing.button.ChooseSimulationActionListener;
import org.salemelrahal.cassy.swing.button.ChooseSizeActionListener;
import org.salemelrahal.cassy.swing.button.StartGameActionListener;
import org.salemelrahal.cassy.swing.canvas.DisplayGrid;
import org.salemelrahal.cassy.swing.mouse.BinaryMouseAdapter;
import org.salemelrahal.cassy.swing.registry.ScaleListRegistry;
import org.salemelrahal.cassy.swing.registry.SizeListRegistry;
 
/**
 * This GUI is still a work in progress :)
 *
 */
public class HelloWorldSwing {
    private static void createAndShowGUI() {
    	
    	int canvasHeight = 200;
    	int canvasWidth = 200;
    	SimulationConfiguration simulation = new LifeSimulation("1357", "1357");
    	Simulation simulationContainer = new Simulation(simulation, new GridFactory(100, 100));
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
        
        JComboBox sizeList = new JComboBox(SizeListRegistry.getSizes().toArray());
        sizeList.addActionListener(new ChooseSizeActionListener(displayGrid));
        
        JComboBox scaleList = new JComboBox(ScaleListRegistry.getScales().toArray());
        scaleList.addActionListener(new ChooseScaleActionListener(displayGrid));
    	
    	
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
        buttons.add(sizeList);
        buttons.add(scaleList);
        frame.add(buttons);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Display the window.
//        frame.pack();
        frame.setVisible(true);
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