package org.salemelrahal.cassy.simulation.model.wireworld;

import org.salemelrahal.cassy.simulation.cell.DynamicCell;
import org.salemelrahal.cassy.simulation.grid.Grid;
import org.salemelrahal.cassy.simulation.grid.GridCellContainer;
import org.salemelrahal.cassy.simulation.model.field.Field;
import org.salemelrahal.cassy.simulation.rule.Rule;

public class WireRule implements Rule{	
	public String toString() {
		return "WireWorld";
	}

	public Field calculateNextField(Field field) {
		Grid grid = (Grid) field;
		Grid toReturn = new Grid(grid.getWidth(), grid.getHeight());
		//TODO: not have to call the below line
		toReturn.fillCells(new DynamicCell(WireState.EMTPY));
		for (int x = 0 ; x < grid.getWidth(); x++) {
			for (int y = 0; y < grid.getHeight(); y++) {
				WireState newState = null;
				GridCellContainer oldCell = grid.getGridCellContainer(x, y);
				WireState oldState = (WireState) oldCell.getState();
				int aliveNeighbors = 0;
				for (GridCellContainer neighbor : grid.getNeighbors(oldCell)) {
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
