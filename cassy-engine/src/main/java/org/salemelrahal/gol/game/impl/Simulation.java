package org.salemelrahal.gol.game.impl;

import org.salemelrahal.cassy.model.field.Field;
import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.model.field.FieldFactory;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class Simulation{
	private Field field;
	private Rule rule;
	private FieldController initializer;
	private FieldFactory fieldFactory;
	
	public Simulation(SimulationConfiguration simulationConfiguration, FieldFactory fieldFactory) {
		this.rule = simulationConfiguration.getRule();
		this.initializer = simulationConfiguration.getFieldController();
		this.fieldFactory = fieldFactory;
		resetField();
	}
	
	public void update(SimulationConfiguration simulationConfiguration) {
		this.rule = simulationConfiguration.getRule();
		this.initializer = simulationConfiguration.getFieldController();
		resetField();
	}
	
	public void setFieldFactory(FieldFactory fieldFactory) {
		this.fieldFactory = fieldFactory;
		resetField();
	}
	
	public boolean iterate() {
		boolean changed = false;		
		Field nextField = rule.calculateNextField(field);
		changed = !nextField.equals(field);
		this.field = nextField;
		return changed;
	}
	
	public String toString() {
		return rule.toString() + "\n" + field.toString();
	}
	
	public void resetField() {
		this.field = fieldFactory.next();
		initializer.reset(field);
	}
	
	public Field getField(){
		return this.field;
	}
	
	public void reset() {
		resetField();
	}
	
	public void click(int x, int y) {
		initializer.click(field, x, y);
	}

	public void randomize() {
		initializer.randomize(field);
	}

	public void drag(int x, int y) {
		initializer.drag(field, x, y);
	}

	public void setField(Field field ) {
		this.field = field;
	}
}
