package com.salemelrahal.cassy.simulation;

import java.util.Collection;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;

public interface Simulation<S extends State, F extends Field> {
//	public F newField();
	public Rule<S,F> getRule();
	public Initializer<F> getInitializer();
	public Collection<S> getStates();
}
