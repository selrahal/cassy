package org.salemelrahal.cassy.simulation.model.brain;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.model.field.FieldController;
import org.salemelrahal.cassy.simulation.model.gol.GridInitializer;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class BriansBrain implements SimulationConfiguration {

	public Rule getRule() {
		return new BrainRule();
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
