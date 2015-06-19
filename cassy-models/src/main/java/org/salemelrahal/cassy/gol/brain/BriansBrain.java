package org.salemelrahal.cassy.gol.brain;

import org.salemelrahal.cassy.gol.GridInitializer;
import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class BriansBrain implements SimulationConfiguration {

	public Rule getRule() {
		return new BrainRule();
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
