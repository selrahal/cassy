package com.salemelrahal.cassy.wireworld;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.rule.Rule;

public class WireRule implements Rule<WireState, Grid>{	
	public String toString() {
		return "WireWorld";
	}

	public Grid calculateNextField(Grid grid) {
		Grid toReturn = new Grid(grid.getWidth(), grid.getHeight());
		//TODO: not have to call the below line
		toReturn.fillCells(new DynamicCell(WireState.EMTPY));
		for (int x = 0 ; x < grid.getWidth(); x++) {
			for (int y = 0; y < grid.getHeight(); y++) {
				WireState newState = null;
				Cell oldCell = grid.getCell(x, y);
				WireState oldState = (WireState) oldCell.getState();
				int aliveNeighbors = 0;
				for (Cell neighbor : grid.getNeighbors(y, x)) {
					if (neighbor.getState().equals(WireState.HEAD)) {
						aliveNeighbors++;
					}
				}

				if (oldState.equals(WireState.EMTPY)) {
					newState = WireState.EMTPY;
				} else if (oldState.equals(WireState.HEAD)) {
					newState = WireState.TAIL;
				} else if (oldState.equals(WireState.TAIL)) {
					newState = WireState.WIRE;
				} else if (oldState.equals(WireState.WIRE) && (aliveNeighbors == 2 || aliveNeighbors == 1)) {
					newState = WireState.HEAD;
				} else {
					newState = WireState.WIRE;
				}
				
				//Add the new cell to the grid!
				DynamicCell newCell = new DynamicCell(newState);
				toReturn.set(newCell, y, x);
			}
		}
		
		return toReturn;
	}
}
