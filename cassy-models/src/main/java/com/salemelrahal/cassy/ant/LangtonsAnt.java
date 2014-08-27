package com.salemelrahal.cassy.ant;

import java.util.Collection;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.cassy.simulation.Simulation;

public class LangtonsAnt implements Simulation{

	public Rule getRule() {
		return new AntRule();
	}

	public Initializer getInitializer() {
		return new AntGridInitializer();
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
