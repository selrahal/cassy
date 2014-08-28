package com.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;
import com.salemelrahal.gol.simulation.impl.SimulationRegistry;

public class ChooseSimulationActionListener implements ActionListener{
	private SimulationContainer simulationContainer;
	private JComponent field;
	
	public ChooseSimulationActionListener(SimulationContainer simulationContainer, JComponent field) {
		this.simulationContainer = simulationContainer;
		this.field = field;
	}

	public void actionPerformed(ActionEvent arg0) {
		JComboBox cb = (JComboBox)arg0.getSource();
        String simulationName = (String)cb.getSelectedItem();
        Simulation simulation = SimulationRegistry.get(simulationName);
        this.simulationContainer.setSimulation(simulation);
		field.repaint();
	}

}
