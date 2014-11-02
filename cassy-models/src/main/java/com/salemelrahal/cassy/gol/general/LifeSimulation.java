package com.salemelrahal.cassy.gol.general;

import java.util.Collection;

import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.common.field.grid.GridFactory;
import com.salemelrahal.cassy.gol.GridInitializer;
import com.salemelrahal.cassy.gol.LifeState;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;

public class LifeSimulation implements SimulationConfiguration<LifeState, Grid> {
	private String survives;
	private String born;
	
	public LifeSimulation(String born, String survives) {
		this.survives = survives;
		this.born = born;
	}

	public Rule<LifeState,Grid> getRule() {
		return new GeneralRule(survives, born);
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
		return new GridFactory(100, 100);
	}

}
