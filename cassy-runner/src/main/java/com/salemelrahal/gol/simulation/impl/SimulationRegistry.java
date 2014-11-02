package com.salemelrahal.gol.simulation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.salemelrahal.cassy.ant.LangtonsAnt;
import com.salemelrahal.cassy.gol.ConwaysGameOfLife;
import com.salemelrahal.cassy.gol.brain.BriansBrain;
import com.salemelrahal.cassy.gol.general.LifeSimulation;
import com.salemelrahal.cassy.gol.seeds.Seeds;
import com.salemelrahal.cassy.simulation.SimulationConfiguration;
import com.salemelrahal.cassy.wireworld.WireWorld;

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
	
	public static List<String> getSimulations() {
		return new ArrayList<String>(simulationMap.keySet());
	}
	
	public static SimulationConfiguration get(String name) {
		return simulationMap.get(name);
	}

}
