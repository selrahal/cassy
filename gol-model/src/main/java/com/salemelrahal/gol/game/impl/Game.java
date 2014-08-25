package com.salemelrahal.gol.game.impl;

import com.salemelrahal.gol.model.impl.Cell;
import com.salemelrahal.gol.model.impl.Grid;
import com.salemelrahal.gol.rule.impl.ClassicRule;

public class Game {
	private Grid grid;
	private ClassicRule classicRule;
	
	public Game(Grid grid, ClassicRule classicRule) {
		this.grid = grid;
		this.classicRule = classicRule;
	}
	
	public boolean iterate() {
		boolean changed = false;
		Grid newGrid = grid.clone();
		
		for (int row = 0 ; row < grid.height(); row++) {
			for (int column = 0; column < grid.width(); column++) {
				Cell cell = grid.get(row, column);
				Cell newCell = classicRule.determineNewState(cell, grid.getNeighbors(row, column));
				if (!cell.getState().equals(newCell.getState())) changed = true;
				newGrid.set(newCell, row, column);
			}
		}
		this.grid = newGrid;
		return changed;
	}
	
	public String toString() {
		return classicRule.toString() + "\n" + grid.toString();
	}
}
