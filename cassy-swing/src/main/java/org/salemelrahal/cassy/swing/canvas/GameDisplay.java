package org.salemelrahal.cassy.swing.canvas;

import javax.swing.JPanel;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.gol.game.impl.Simulation;

public class GameDisplay extends JPanel {
	private static final long serialVersionUID = -7933246417534690843L;
	protected Simulation simulation;

	public GameDisplay(Simulation game) {
		super();
		this.simulation = game;
	}
	
	public void setSimulation(SimulationConfiguration simulationConfiguration) {
		simulation.update(simulationConfiguration);
	}
	
	
}