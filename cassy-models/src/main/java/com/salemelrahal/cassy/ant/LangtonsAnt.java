package com.salemelrahal.cassy.ant;

import java.util.Collection;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class LangtonsAnt implements Simulation<AntState, Grid>{

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

}
