package com.salemelrahal.cassy.gol.general;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.gol.LifeState;
import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;

public class GeneralRule implements Rule<LifeState, Grid>{
	private String survives;
	private String born;
	
	public GeneralRule(String survives, String born) {
		this.survives = survives;
		this.born = born;
	}

	public State calculateNextState(Cell cell, int row, int column, Grid field) {
		Integer aliveNeighbors = 0;
		for (Cell neighbor : field.getNeighbors(row, column)) {
			if (neighbor.getState().equals(LifeState.ALIVE)) {
				aliveNeighbors++;
			}
		}
		if (cell.getState().equals(LifeState.ALIVE) && survives.contains(aliveNeighbors.toString())){
			return LifeState.ALIVE;
		}else if (cell.getState().equals(LifeState.ALIVE)) {
			return LifeState.DEAD;
		}else if (cell.getState().equals(LifeState.DEAD) && born.contains(aliveNeighbors.toString())){
			return LifeState.ALIVE;
		}else if (cell.getState().equals(LifeState.DEAD)) {
			return LifeState.DEAD;
		}
		return null;
	}
	
	public String toString() {
		return "Conway's Game of Life";
	}

	public Grid calculateNextField(Grid grid) {
		Grid nextField = grid.clone();

		
		for (int x = 0 ; x < grid.getWidth(); x++) {
			for (int y = 0; y < grid.getHeight(); y++) {
				Cell cell = grid.getCell(x, y);
				State newState = this.calculateNextState(cell, y, x, grid);
				if (cell.shouldChange(newState)) {
					DynamicCell newCell = new DynamicCell(newState);
					nextField.set(newCell, y, x);
				}
			}
		}

		
		return nextField;
	}
}
