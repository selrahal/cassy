package org.salemelrahal.cassy.simulation.model.wireworld;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.model.field.FieldController;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class WireWorld implements SimulationConfiguration{

	public Rule getRule() {
		return new WireRule();
	}

	public FieldController getFieldController() {
		return new WireGridInitializer();
	}
}
