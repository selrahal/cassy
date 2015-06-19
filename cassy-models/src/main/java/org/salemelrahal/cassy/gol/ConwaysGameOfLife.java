package org.salemelrahal.cassy.gol;

import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class ConwaysGameOfLife implements SimulationConfiguration {
	public Rule getRule() {
		return new ClassicRule();
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
