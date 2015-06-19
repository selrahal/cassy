package org.salemelrahal.cassy.ant;

import org.salemelrahal.cassy.common.DynamicCell;
import org.salemelrahal.cassy.common.field.grid.Grid;
import org.salemelrahal.cassy.common.field.grid.GridCellContainer;
import org.salemelrahal.cassy.model.field.Field;
import org.salemelrahal.cassy.rule.Rule;

public class AntRule implements Rule{	
	public String toString() {
		return "Conway's Game of Life";
	}

	public Field calculateNextField(Field field) {
		Grid grid = (Grid) field;
		Grid toReturn = new Grid(grid.getWidth(), grid.getHeight());
		//TODO: not have to call the below line
		toReturn.fillCells(new DynamicCell(new AntState(null, null)));
		for (int x = 0 ; x < grid.getWidth(); x++) {
			for (int y = 0; y < grid.getHeight(); y++) {
				AntState.Color newColor = null;
				AntState.Direction newDirection = null;
				GridCellContainer oldCell = grid.getGridCellContainer(x, y);
				AntState oldState = (AntState) oldCell.getState();
				if (!oldState.getAntFacing().equals(AntState.Direction.NONE)){
					//Found the ant! Flip the color and move!
					if (oldState.getColor().equals(AntState.Color.WHITE)) {
						newColor = AntState.Color.BLACK;
					} else {
						newColor = AntState.Color.WHITE;
					}
					
					//Ant has moved!
					newDirection = AntState.Direction.NONE;
				} else {
					//No ant, if we are waiting to find ant lets check our neighbors
					GridCellContainer up = grid.getGridCellContainer(x, y - 1);
					GridCellContainer down = grid.getGridCellContainer(x, y + 1);
					GridCellContainer left = grid.getGridCellContainer(x - 1, y);
					GridCellContainer right = grid.getGridCellContainer(x + 1, y);
						if ((isRight(up) && isWhite(up)) || (isLeft(up) && isBlack(up))){
							newDirection = AntState.Direction.DOWN;
						} else if ((isUp(left) && isWhite(left)) || (isDown(left) && isBlack(left))) {
							newDirection = AntState.Direction.RIGHT;
						} else if ((isLeft(down) && isWhite(down)) || (isRight(down) && isBlack(down))) {
							newDirection = AntState.Direction.UP;
						} else if ((isDown(right) && isWhite(right)) || (isUp(right) && isBlack(right))) {
							newDirection = AntState.Direction.LEFT;
						} else {
							//No ant will move on to this spot :(
							newDirection = AntState.Direction.NONE;
						}
						//because the ant didnt leave this square, the color wont change
						newColor = oldState.getColor();
				}
				
				//Add the new cell to the grid!
				AntState newState = new AntState(newColor, newDirection);
				DynamicCell newCell = new DynamicCell(newState);
				toReturn.set(newCell, y, x);
			}
		}
		
		return toReturn;
	}
	
	
	private boolean isUp(GridCellContainer cell) {
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.UP));
	}
	
	private boolean isDown(GridCellContainer cell) {
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.DOWN));
	}
	
	private boolean isLeft(GridCellContainer cell) {
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.LEFT));
	}
	
	private boolean isRight(GridCellContainer cell) {	
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.RIGHT));
	}
	
	private boolean isWhite(GridCellContainer cell) {
		return (cell != null && ((AntState)cell.getState()).getColor().equals(AntState.Color.WHITE));
	}
	
	private boolean isBlack(GridCellContainer cell) {
		return (cell != null && ((AntState)cell.getState()).getColor().equals(AntState.Color.BLACK));
	}
}
