package com.salemelrahal.gol.conway.rule;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.gol.conway.model.BinaryState;
import com.salemelrahal.gol.conway.model.DynamicCell;
import com.salemelrahal.gol.conway.model.Grid;

public class ClassicRule implements Rule<BinaryState, Grid>{
	public State calculateNextState(Cell cell, int row, int column, Grid field) {
		int aliveNeighbors = 0;
		for (Cell neighbor : field.getNeighbors(row, column)) {
			if (neighbor.getState().equals(BinaryState.ALIVE)) {
				aliveNeighbors++;
			}
		}
		if (aliveNeighbors < 2){
			return BinaryState.DEAD;
		}else if (aliveNeighbors == 2 && cell.getState().equals(BinaryState.ALIVE)){
			return BinaryState.ALIVE;
		}else if (aliveNeighbors == 2 && !cell.getState().equals(BinaryState.ALIVE)) {
			return BinaryState.DEAD;
		}else if (aliveNeighbors == 3){
			return BinaryState.ALIVE;
		}else {
			return BinaryState.DEAD;
		}
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
					DynamicCell newCell = new DynamicCell();
					newCell.setState(newState);
					nextField.set(newCell, y, x);
				}
			}
		}

		
		return nextField;
	}
}
