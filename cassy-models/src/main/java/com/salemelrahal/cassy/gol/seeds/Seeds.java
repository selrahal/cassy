package com.salemelrahal.cassy.gol.seeds;

import java.util.Collection;

import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.gol.GridInitializer;
import com.salemelrahal.cassy.gol.LifeState;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;

public class Seeds implements SimulationConfiguration<LifeState, Grid> {

	public Rule<LifeState, Grid> getRule() {
		return new SeedsRule();
	}

	public Initializer<Grid> getInitializer() {
		return new GridInitializer();
	}

	public Collection<LifeState> getStates() {
		// TODO Implement
		return null;
	}

	public FieldFactory<Grid> getFieldFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
