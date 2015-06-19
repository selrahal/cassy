package org.salemelrahal.gol.simulation.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.salemelrahal.cassy.common.field.grid.GridFactory;
import org.salemelrahal.gol.game.impl.Run;
import org.salemelrahal.gol.game.impl.Simulation;
import org.salemelrahal.gol.simulation.impl.SimulationRegistry;

public class Runner {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("CASSSY:");
		System.out.print("Simulation width:");
		int width = Integer.parseInt(br.readLine());
		System.out.print("Simulation height:");
		int height = Integer.parseInt(br.readLine());
		System.out.println("Number of runs:");
		int numberOfRuns = Integer.parseInt(br.readLine());
		System.out.println("Max Score:");
		int maxScore = Integer.parseInt(br.readLine());
		
		
		
		
		
		GridFactory gridFactory = new GridFactory(width, height);
		int[] scores = new int[maxScore + 1];
		for (int i = 0 ; i < maxScore + 1; i++) {
			scores[i] = 0;
		}
		for (int i = 0; i < numberOfRuns; i++) {
			Simulation game = new Simulation(SimulationRegistry.get("Conway's Game of Life"), gridFactory);
			game.setFieldFactory(gridFactory);
			game.reset();
			Run run = new Run(game);
			int runs = run.runTillStale(maxScore);
			scores[runs]++;
			if (runs == maxScore) System.out.println(game);
		}
		for (int i = 0; i < maxScore + 1; i++) {
			if (scores[i] != 0) System.out.println(i + ":" + scores[i]);
		}
	}
}
