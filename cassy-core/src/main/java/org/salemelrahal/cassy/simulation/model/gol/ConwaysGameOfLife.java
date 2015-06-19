package org.salemelrahal.cassy.simulation.model.gol;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.model.field.FieldController;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class ConwaysGameOfLife implements SimulationConfiguration {
	public Rule getRule() {
		return new ClassicRule();
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
