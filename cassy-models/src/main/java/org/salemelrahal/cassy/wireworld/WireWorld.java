package org.salemelrahal.cassy.wireworld;

import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class WireWorld implements SimulationConfiguration{

	public Rule getRule() {
		return new WireRule();
	}

	public FieldController getFieldController() {
		return new WireGridInitializer();
	}
}
