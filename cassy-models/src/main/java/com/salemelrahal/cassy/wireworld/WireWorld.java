package com.salemelrahal.cassy.wireworld;

import java.util.Collection;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class WireWorld implements Simulation<WireState, Grid>{

	public Rule<WireState, Grid> getRule() {
		return new WireRule();
	}

	public Initializer<Grid> getInitializer() {
		return new WireGridInitializer();
	}

	public Field getField() {
		//TODO: Implement
		return null;
	}

	public Collection<WireState> getStates() {
		//TODO: Implement
		return null;
	}

}
