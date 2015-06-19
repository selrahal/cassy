package org.salemelrahal.cassy.simulation.model.ant;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.model.field.FieldController;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class LangtonsAnt implements SimulationConfiguration{

	public Rule getRule() {
		return new AntRule();
	}

	public FieldController getFieldController() {
		return new AntGridInitializer();
	}
}
