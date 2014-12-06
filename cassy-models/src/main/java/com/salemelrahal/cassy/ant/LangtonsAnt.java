package com.salemelrahal.cassy.ant;

import java.util.Collection;

import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.common.field.grid.GridFactory;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;

public class LangtonsAnt implements SimulationConfiguration<AntState, Grid>{

	public Rule<AntState, Grid> getRule() {
		return new AntRule();
	}

	public Initializer<Grid> getInitializer() {
		return new AntGridInitializer();
	}

	public Grid newField() {
		//TODO: Implement
		return null;
	}

	public Collection<AntState> getStates() {
		//TODO: Implement
		return null;
	}

	public FieldFactory<Grid> getFieldFactory() {
		return new GridFactory(100, 100);
	}

}
