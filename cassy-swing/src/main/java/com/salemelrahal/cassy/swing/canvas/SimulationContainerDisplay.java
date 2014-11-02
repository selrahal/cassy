package com.salemelrahal.cassy.swing.canvas;

import javax.swing.JPanel;

import com.salemelrahal.cassy.simulation.SimulationConfiguration;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;

public class SimulationContainerDisplay extends JPanel {

	protected SimulationContainer simulationContainer;

	public SimulationContainerDisplay(SimulationContainer simulationContainer) {
		super();
		this.simulationContainer = simulationContainer;
	}

	public void setSimulation(SimulationConfiguration simulation) {
		simulationContainer.setSimulation(simulation);
		this.repaint();
	}

}