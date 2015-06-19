package org.salemelrahal.gol.game.impl;


public class Run {
	private Simulation game;
	
	public Run(Simulation game) {
		this.game = game;
		game.randomize();
	}
	
	public int runTillStale(int maxRuns) {
		int runs = 1;
		while (game.iterate() && runs < maxRuns) {
			runs++;
		}
		return runs;
	}
}
