package com.salemelrahal.cassy.simulation;

import java.util.Collection;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;

public interface Simulation {
	public Field getField();
	public Rule getRule();
	public Initializer getInitializer();
	public Collection<State> getStates();
}
