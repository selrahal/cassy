package com.salemelrahal.cassy.gol;

import java.util.Collection;

import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.common.field.grid.GridFactory;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;

public class ConwaysGameOfLife implements SimulationConfiguration<LifeState, Grid> {
	public Rule<LifeState, Grid> getRule() {
		return new ClassicRule();
	}

	public Initializer<Grid> getInitializer() {
		return new GridInitializer();
	}

	public Collection<LifeState> getStates() {
		// TODO Implement
		return null;
	}

	public FieldFactory<Grid> getFieldFactory() {
		return new GridFactory(100, 100);
	}

}
