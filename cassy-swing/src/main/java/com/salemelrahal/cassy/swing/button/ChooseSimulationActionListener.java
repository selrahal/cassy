package com.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.cassy.swing.canvas.DisplayGrid;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;
import com.salemelrahal.gol.simulation.impl.SimulationRegistry;

public class ChooseSimulationActionListener implements ActionListener{
	private DisplayGrid displayGrid;
	
	public ChooseSimulationActionListener(DisplayGrid displayGrid) {
		this.displayGrid =displayGrid;
	}

	public void actionPerformed(ActionEvent arg0) {
		JComboBox<String> cb = (JComboBox<String>)arg0.getSource();
        String simulationName = (String)cb.getSelectedItem();
        Simulation simulation = SimulationRegistry.get(simulationName);
        this.displayGrid.setSimulation(simulation);
	}

}
