package org.salemelrahal.cassy.gol;

import org.salemelrahal.cassy.common.DynamicCell;
import org.salemelrahal.cassy.common.field.grid.Grid;
import org.salemelrahal.cassy.common.field.grid.GridCellContainer;
import org.salemelrahal.cassy.model.State;
import org.salemelrahal.cassy.model.field.Field;
import org.salemelrahal.cassy.rule.Rule;

public class ClassicRule implements Rule{
	public State calculateNextState(GridCellContainer cell, int row, int column, Grid field) {
		int aliveNeighbors = 0;
		for (GridCellContainer neighbor : field.getNeighbors(cell)) {
			if (neighbor.getState().equals(LifeState.ALIVE)) {
				aliveNeighbors++;
			}
		}
		if (aliveNeighbors < 2){
			return LifeState.DEAD;
		}else if (aliveNeighbors == 2 && cell.getState().equals(LifeState.ALIVE)){
			return LifeState.ALIVE;
		}else if (aliveNeighbors == 2 && !cell.getState().equals(LifeState.ALIVE)) {
			return LifeState.DEAD;
		}else if (aliveNeighbors == 3){
			return LifeState.ALIVE;
		}else {
			return LifeState.DEAD;
		}
	}
	
	public String toString() {
		return "Conway's Game of Life";
	}

	public Field calculateNextField(Field field) {
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
