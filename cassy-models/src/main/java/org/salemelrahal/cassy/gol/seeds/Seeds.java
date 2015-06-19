package org.salemelrahal.cassy.gol.seeds;

import org.salemelrahal.cassy.gol.GridInitializer;
import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class Seeds implements SimulationConfiguration {

	public Rule getRule() {
		return new SeedsRule();
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
