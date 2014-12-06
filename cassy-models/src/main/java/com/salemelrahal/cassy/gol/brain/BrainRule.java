package com.salemelrahal.cassy.gol.brain;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.common.field.grid.GridCellContainer;
import com.salemelrahal.cassy.gol.LifeState;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;

public class BrainRule implements Rule<LifeState, Grid>{
	public State calculateNextState(GridCellContainer cell, int row, int column, Grid field) {
		int aliveNeighbors = 0;
		for (GridCellContainer neighbor : field.getNeighbors(cell)) {
			if (neighbor.getState().equals(LifeState.ALIVE)) {
				aliveNeighbors++;
			}
		}
		if (cell.getState().equals(LifeState.ALIVE)){
			return LifeState.DYING;
		}else if (cell.getState().equals(LifeState.DYING)) {
			return LifeState.DEAD;
		}else if (aliveNeighbors == 2 ){
			return LifeState.ALIVE;
		}else {
			return LifeState.DEAD;
		}
	}
	
	public String toString() {
		return "Conway's Game of Life";
	}

	public Grid calculateNextField(Grid grid) {
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
