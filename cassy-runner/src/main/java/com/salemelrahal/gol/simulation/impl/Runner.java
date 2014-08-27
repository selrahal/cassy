package com.salemelrahal.gol.simulation.impl;

import com.salemelrahal.cassy.gol.ClassicRule;
import com.salemelrahal.cassy.gol.GridInitializer;
import com.salemelrahal.gol.factory.impl.GridFactory;
import com.salemelrahal.gol.game.impl.Game;

public class Runner {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	private static final int MAX_SCORE = 1000;
	
	public static void main(String[] args) {
		GridFactory gridFactory = new GridFactory(WIDTH, HEIGHT);
		int[] scores = new int[MAX_SCORE + 1];
		for (int i = 0 ; i < MAX_SCORE + 1; i++) {
			scores[i] = 0;
		}
		for (int i = 0; i < 10; i++) {
			Game game = new Game(gridFactory.next(),new ClassicRule(), new GridInitializer());
			game.reset();
			Run run = new Run(game);
			int runs = run.runTillStale();
			scores[runs]++;
			if (runs == 1000) System.out.println(game);
		}
		for (int i = 0; i < MAX_SCORE + 1; i++) {
			if (scores[i] != 0) System.out.println(i + ":" + scores[i]);
		}
	}
}
