package com.salemelrahal.cassy.swing.conatiner;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.gol.game.impl.Game;

public class SimulationContainer {
	private Game game;
	private Simulation simulation;

	public SimulationContainer(Simulation simulation) {
		super();
		this.setSimulation(simulation);
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
		this.game = new Game<Field, State>(new Grid(100,100), simulation.getRule(),simulation.getInitializer());
		this.game.reset();
	}
	
	public void click(int x, int y) {
		this.game.click(x, y);
	}
	
	public void drag(int x, int y) {	
		this.game.drag(x, y);
	}
	
	public void reset() {
		this.game.reset();
	}
	
	public boolean iterate() {
		return this.game.iterate();
	}
	
	public Field getField() {
		return game.getField();
	}

}
