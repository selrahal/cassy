package com.salemelrahal.cassy.gol.brain;

import java.util.Collection;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.gol.GridInitializer;
import com.salemelrahal.cassy.gol.LifeState;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class BriansBrain implements Simulation<LifeState, Grid> {

	public Field getField() {
		// TODO Implement
		return null;
	}

	public Rule<LifeState, Grid> getRule() {
		return new BrainRule();
	}

	public Initializer<Grid> getInitializer() {
		return new GridInitializer();
	}

	public Collection<LifeState> getStates() {
		// TODO Implement
		return null;
	}

}
