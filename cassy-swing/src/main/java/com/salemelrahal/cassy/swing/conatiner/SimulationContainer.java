package com.salemelrahal.cassy.swing.conatiner;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.model.field.Field;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;
import com.salemelrahal.gol.game.impl.Game;

public class SimulationContainer {
	private Game game;
	private FieldFactory fieldFactory;
	private Rule rule;
	private Initializer initializer;

	public SimulationContainer(SimulationConfiguration simulation) {
		super();
		this.setSimulation(simulation);
	}

	public void setSimulation(SimulationConfiguration simulation) {
		this.rule = simulation.getRule();
		this.initializer = simulation.getInitializer();
		this.fieldFactory = simulation.getFieldFactory();
		_reset();
	}
	
	public void click(int x, int y) {
		this.game.click(x, y);
	}
	
	public void drag(int x, int y) {	
		this.game.drag(x, y);
	}
	
	public void reset() {
		_reset();
	}
	
	public boolean iterate() {
		return this.game.iterate();
	}
	
	public Field getField() {
		return game.getField();
	}

	public void setFieldFactory(FieldFactory fieldFactory) {
		this.fieldFactory = fieldFactory;
		_reset();
	}
	
	private void _reset() {
		this.game = new Game<Field, State>(fieldFactory.next(), rule, initializer);
		this.game.reset();
	}

}
