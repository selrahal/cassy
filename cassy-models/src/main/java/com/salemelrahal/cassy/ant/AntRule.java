package com.salemelrahal.cassy.ant;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.gol.conway.model.DynamicCell;
import com.salemelrahal.gol.conway.model.Grid;

public class AntRule implements Rule<AntState, Grid>{	
	public String toString() {
		return "Conway's Game of Life";
	}

	public Grid calculateNextField(Grid grid) {
		Grid toReturn = new Grid(grid.getWidth(), grid.getHeight());
		boolean foundAnt = false;
		for (int x = 0 ; x < grid.getWidth(); x++) {
			for (int y = 0; y < grid.getHeight(); y++) {
				AntState.Color newColor = null;
				AntState.Direction newDirection = null;
				Cell oldCell = grid.getCell(x, y);
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
						Cell up = grid.getCell(x, y - 1);
						Cell down = grid.getCell(x, y+1);
						Cell left = grid.getCell(x-1, y);
						Cell right = grid.getCell(x + 1, y);
						if ((isRight(up) && isWhite(up)) || (isLeft(up) && isBlack(up))){
							newDirection = AntState.Direction.DOWN;
							foundAnt = true;
						} else if ((isUp(left) && isWhite(left)) || (isDown(left) && isBlack(left))) {
							newDirection = AntState.Direction.RIGHT;
							foundAnt = true;
						} else if ((isLeft(down) && isWhite(down)) || (isRight(down) && isBlack(down))) {
							newDirection = AntState.Direction.UP;
							foundAnt = true;
						} else if ((isDown(right) && isWhite(right)) || (isUp(right) && isBlack(right))) {
							newDirection = AntState.Direction.LEFT;
							foundAnt = true;
						} else {
							//No ant will move on to this spot :(
							newDirection = AntState.Direction.NONE;
						}
						//because the ant didnt leave this square, the color wont change
						newColor = oldState.getColor();
				}
				
				//Add the new cell to the grid!
				AntState newState = new AntState(newColor, newDirection);
				DynamicCell newCell = new DynamicCell();
				newCell.setState(newState);
				toReturn.set(newCell, y, x);
			}
		}
		
		return toReturn;
	}
	
	
	private boolean isUp(Cell cell) {
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.UP));
	}
	
	private boolean isDown(Cell cell) {
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.DOWN));
	}
	
	private boolean isLeft(Cell cell) {
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.LEFT));
	}
	
	private boolean isRight(Cell cell) {	
		return (cell != null && ((AntState)cell.getState()).getAntFacing().equals(AntState.Direction.RIGHT));
	}
	
	private boolean isWhite(Cell cell) {
		return (cell != null && ((AntState)cell.getState()).getColor().equals(AntState.Color.WHITE));
	}
	
	private boolean isBlack(Cell cell) {
		return (cell != null && ((AntState)cell.getState()).getColor().equals(AntState.Color.BLACK));
	}
}
