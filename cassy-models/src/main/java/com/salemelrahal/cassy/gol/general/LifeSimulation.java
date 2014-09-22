package com.salemelrahal.cassy.gol.general;

import java.util.Collection;

import com.salemelrahal.cassy.gol.GridInitializer;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class LifeSimulation implements Simulation {
	private String survives;
	private String born;
	
	public LifeSimulation(String born, String survives) {
		this.survives = survives;
		this.born = born;
	}

	public Field getField() {
		// TODO Implement
		return null;
	}

	public Rule getRule() {
		return new GeneralRule(survives, born);
	}

	public Initializer getInitializer() {
		return new GridInitializer();
	}

	public Collection<State> getStates() {
		// TODO Implement
		return null;
	}

}
