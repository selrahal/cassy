package org.salemelrahal.cassy.gol.general;

import org.salemelrahal.cassy.gol.GridInitializer;
import org.salemelrahal.cassy.model.field.FieldController;
import org.salemelrahal.cassy.rule.Rule;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public class LifeSimulation implements SimulationConfiguration {
	private String survives;
	private String born;
	
	public LifeSimulation(String born, String survives) {
		this.survives = survives;
		this.born = born;
	}

	public Rule getRule() {
		return new GeneralRule(survives, born);
	}

	public FieldController getFieldController() {
		return new GridInitializer();
	}
}
