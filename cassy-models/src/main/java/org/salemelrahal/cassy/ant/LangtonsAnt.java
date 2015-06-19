package org.salemelrahal.cassy.ant;

import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class LangtonsAnt implements SimulationConfiguration{

	public Rule getRule() {
		return new AntRule();
	}

	public FieldController getFieldController() {
		return new AntGridInitializer();
	}
}
