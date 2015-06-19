package org.salemelrahal.cassy.simulation;

import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;

/**
 * A Configuration that provides all necessary components to run
 * a cellular automaton simulation. This includes the Rule (logic
 * used to determine Field state), a controller for editing the field,
 *  and a factory to create new fields.
 * 
 *
 */
public interface SimulationConfiguration {
	public Rule getRule();
	public FieldController getFieldController();
}
