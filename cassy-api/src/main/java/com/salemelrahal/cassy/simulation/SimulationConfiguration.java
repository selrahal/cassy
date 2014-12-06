package com.salemelrahal.cassy.simulation;

import java.util.Collection;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.model.field.Field;
import com.salemelrahal.cassy.model.field.FieldFactory;
import com.salemelrahal.cassy.model.field.Node;
import com.salemelrahal.cassy.rule.Rule;

public interface SimulationConfiguration<S extends State, F extends Field<?>> {
//	public F newField();
	public Rule<S,F> getRule();
	public Initializer<F> getInitializer();
	public Collection<S> getStates();
	public FieldFactory<F> getFieldFactory();
}
