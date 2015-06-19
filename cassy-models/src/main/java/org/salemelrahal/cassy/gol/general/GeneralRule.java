package org.salemelrahal.cassy.gol.general;

import org.salemelrahal.cassy.common.DynamicCell;
import org.salemelrahal.cassy.common.field.grid.Grid;
import org.salemelrahal.cassy.common.field.grid.GridCellContainer;
import org.salemelrahal.cassy.gol.LifeState;
import org.salemelrahal.cassy.model.State;
import org.salemelrahal.cassy.model.field.Field;
import org.salemelrahal.cassy.rule.Rule;

public class GeneralRule implements Rule{
	private String survives;
	private String born;
	
	public GeneralRule(String survives, String born) {
		this.survives = survives;
		this.born = born;
	}

	public State calculateNextState(GridCellContainer cell, int row, int column, Grid field) {
		Integer aliveNeighbors = 0;
		for (GridCellContainer neighbor : field.getNeighbors(cell)) {
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

	public Grid calculateNextField(Field field) {
		Grid grid = (Grid) field;
		Grid nextField = grid.clone();

		
		for (int x = 0 ; x < grid.getWidth(); x++) {
			for (int y = 0; y < grid.getHeight(); y++) {
				GridCellContainer cell = grid.getGridCellContainer(x, y);
				State newState = this.calculateNextState(cell, y, x, grid);
				DynamicCell newCell = new DynamicCell(newState);
				nextField.set(newCell, y, x);
			}
		}

		
		return nextField;
	}
}
