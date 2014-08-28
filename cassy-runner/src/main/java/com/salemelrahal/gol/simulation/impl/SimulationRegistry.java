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
import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.cassy.wireworld.WireWorld;

public class SimulationRegistry {
	
	private static Map<String, Simulation> simulationMap;
	
	static {
		simulationMap = new ConcurrentHashMap<String, Simulation>();
		simulationMap.put("Conway's Game of Life", new ConwaysGameOfLife());
		simulationMap.put("WireWorld", new WireWorld());
		simulationMap.put("Langton's Ant", new LangtonsAnt());
		simulationMap.put("Seeds", new Seeds());
		simulationMap.put("Brian's Brain", new BriansBrain());
		simulationMap.put("1357/1357", new LifeSimulation("1357", "1357"));
	}
	
	public static List<String> getSimulations() {
		return new ArrayList<String>(simulationMap.keySet());
	}
	
	public static Simulation get(String name) {
		return simulationMap.get(name);
	}

}
