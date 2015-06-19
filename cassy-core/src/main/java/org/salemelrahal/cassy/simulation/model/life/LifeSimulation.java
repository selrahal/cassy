package org.salemelrahal.cassy.simulation.model.life;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.simulation.model.field.FieldController;
import org.salemelrahal.cassy.simulation.model.gol.GridInitializer;
import org.salemelrahal.cassy.simulation.rule.Rule;

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
