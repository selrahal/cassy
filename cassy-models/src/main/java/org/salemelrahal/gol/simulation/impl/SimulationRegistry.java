package org.salemelrahal.gol.simulation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.salemelrahal.cassy.ant.LangtonsAnt;
import org.salemelrahal.cassy.gol.ConwaysGameOfLife;
import org.salemelrahal.cassy.gol.brain.BriansBrain;
import org.salemelrahal.cassy.gol.general.LifeSimulation;
import org.salemelrahal.cassy.gol.seeds.Seeds;
import org.salemelrahal.cassy.simulation.SimulationConfiguration;
import org.salemelrahal.cassy.wireworld.WireWorld;

public class SimulationRegistry {
	
	private static Map<String, SimulationConfiguration> simulationMap;
	
	static {
		simulationMap = new ConcurrentHashMap<String, SimulationConfiguration>();
		simulationMap.put("Conway's Game of Life", new ConwaysGameOfLife());
		simulationMap.put("WireWorld", new WireWorld());
		simulationMap.put("Langton's Ant", new LangtonsAnt());
		simulationMap.put("Seeds 2/", new Seeds());
		simulationMap.put("Brian's Brain", new BriansBrain());
		simulationMap.put("Replicator 1357/1357", new LifeSimulation("1357", "1357"));
		simulationMap.put("Life without Death 3/012345678", new LifeSimulation("3", "012345678"));
		simulationMap.put("Diamoeba 35678/5678", new LifeSimulation("35678", "5678"));
	}
	
	public void addSimulation(String name, SimulationConfiguration simulationConfiguration) { 
		simulationMap.put(name, simulationConfiguration);
	}
	
	public static List<String> getSimulations() {
		return new ArrayList<String>(simulationMap.keySet());
	}
	
	public static SimulationConfiguration get(String name) {
		return simulationMap.get(name);
	}

}
