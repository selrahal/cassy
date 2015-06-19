package org.salemelrahal.cassy.simulation.model.seeds;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.model.field.FieldController;
import org.salemelrahal.cassy.simulation.model.gol.GridInitializer;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class Seeds implements SimulationConfiguration {

	public Rule getRule() {
		return new SeedsRule();
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
