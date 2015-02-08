package com.salemelrahal.gol.simulation.impl;

import com.salemelrahal.gol.game.impl.Game;

public class Run {
	private Game<?, ?> game;
	private static final int MAX_RUNS = 1000;
	
	public Run(Game<?, ?> game) {
		this.game = game;
		game.randomize();
	}
	
	public int runTillStale() {
		int runs = 1;
		while (game.iterate() && runs < MAX_RUNS) {
			runs++;
		}
		return runs;
	}
}
