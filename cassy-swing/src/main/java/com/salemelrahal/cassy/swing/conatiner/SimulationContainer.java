package com.salemelrahal.cassy.swing.conatiner;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.gol.game.impl.Game;

public class SimulationContainer {
	private Simulation simulation;
	private Game game;

	public SimulationContainer(Simulation simulation) {
		super();
		this.simulation = simulation;
		this.setSimulation(simulation);
	}

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
		this.game = new Game(new Grid(300,300), simulation.getRule(), simulation.getInitializer());
	}
	
	public Game getGame() {
		return this.game;
	}
}
