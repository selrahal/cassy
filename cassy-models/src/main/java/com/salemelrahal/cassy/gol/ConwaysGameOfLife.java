package com.salemelrahal.cassy.gol;

import java.util.Collection;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class ConwaysGameOfLife implements Simulation {

	public Field getField() {
		// TODO Implement
		return null;
	}

	public Rule getRule() {
		return new ClassicRule();
	}

	public Initializer getInitializer() {
		return new GridInitializer();
	}

	public Collection<State> getStates() {
		// TODO Implement
		return null;
	}

}
