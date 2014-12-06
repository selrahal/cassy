package com.salemelrahal.cassy.wireworld;

import java.util.Collection;

import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.common.field.grid.GridFactory;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;

public class WireWorld implements SimulationConfiguration<WireState, Grid>{

	public Rule<WireState, Grid> getRule() {
		return new WireRule();
	}

	public Initializer<Grid> getInitializer() {
		return new WireGridInitializer();
	}

	public Collection<WireState> getStates() {
		return null;
	}

	public FieldFactory<Grid> getFieldFactory() {
		return new GridFactory(100, 100);
	}

}
