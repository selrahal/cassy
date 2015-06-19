package org.salemelrahal.cassy.simulation.model.seeds;

import org.salemelrahal.cassy.simulation.cell.DynamicCell;
import org.salemelrahal.cassy.simulation.cell.State;
import org.salemelrahal.cassy.simulation.grid.Grid;
import org.salemelrahal.cassy.simulation.grid.GridCellContainer;
import org.salemelrahal.cassy.simulation.model.field.Field;
import org.salemelrahal.cassy.simulation.model.gol.LifeState;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class SeedsRule implements Rule{
	private State calculateNextState(GridCellContainer cell, int row, int column, Grid field) {
		int aliveNeighbors = 0;
		for (GridCellContainer neighbor : field.getNeighbors(cell)) {
			if (neighbor.getState().equals(LifeState.ALIVE)) {
				aliveNeighbors++;
			}
		}
		if (cell.getState().equals(LifeState.ALIVE)){
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
