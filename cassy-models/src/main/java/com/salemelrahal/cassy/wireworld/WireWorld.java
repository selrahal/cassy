package com.salemelrahal.cassy.wireworld;

import java.util.Collection;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class WireWorld implements Simulation{

	public Rule getRule() {
		return new WireRule();
	}

	public Initializer getInitializer() {
		return new WireGridInitializer();
	}

	public Field getField() {
		//TODO: Implement
		return null;
	}

	public Collection<State> getStates() {
		//TODO: Implement
		return null;
	}

}
