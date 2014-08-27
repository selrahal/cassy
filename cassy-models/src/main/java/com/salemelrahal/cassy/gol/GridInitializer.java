package com.salemelrahal.cassy.gol;

import java.util.Random;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Cell;

public class GridInitializer implements Initializer<Grid>{
	
	public void randomize(Grid grid) {
		int height = grid.getHeight();
		int width = grid.getWidth();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				DynamicCell cell = new DynamicCell(((new Random()).nextBoolean()?LifeState.DEAD:LifeState.ALIVE));
				grid.set(cell, row, column);
//				initializer.init(cells.get(row).get(column), this.getNeighbors(cells.get(row).get(column)));
			}
		}
	}

	public void initialize(Grid grid) {
		grid.fillCells(new DynamicCell(LifeState.DEAD));
//		int height = grid.getHeight();
//		int width = grid.getWidth();
//		for (int row = 0; row < height; row++) {
//			for (int column = 0; column < width; column++) {
//				DynamicCell cell = 
////				cell.setState(((new Random()).nextBoolean()?BinaryState.DEAD:BinaryState.ALIVE));
//				grid.set(cell, row, column);
////				initializer.init(cells.get(row).get(column), this.getNeighbors(cells.get(row).get(column)));
//			}
//		}
	}

	public void click(Grid grid, int x, int y) {
		Cell cell = grid.getCell(x, y);
//		BinaryState state = (BinaryState)cell.getState();
//		if (state.equals(BinaryState.ALIVE)) {
//			cell.setState(BinaryState.DEAD);
//		} else if (state.equals(BinaryState.DEAD)) {
			cell.setState(LifeState.ALIVE);
//		}
	}
}
