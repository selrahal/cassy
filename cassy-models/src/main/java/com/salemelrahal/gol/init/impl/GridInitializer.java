package com.salemelrahal.gol.init.impl;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.gol.conway.model.BinaryState;
import com.salemelrahal.gol.conway.model.DynamicCell;
import com.salemelrahal.gol.conway.model.Grid;

public class GridInitializer implements Initializer<Grid>{

	public void initialize(Grid grid) {
		int height = grid.getHeight();
		int width = grid.getWidth();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				DynamicCell cell = new DynamicCell();
//				cell.setState(((new Random()).nextBoolean()?BinaryState.DEAD:BinaryState.ALIVE));
				cell.setState((BinaryState.DEAD));
				grid.set(cell, row, column);
//				initializer.init(cells.get(row).get(column), this.getNeighbors(cells.get(row).get(column)));
			}
		}
	}

	public void click(Grid grid, int x, int y) {
		Cell cell = grid.getCell(x, y);
		BinaryState state = (BinaryState)cell.getState();
		if (state.equals(BinaryState.ALIVE)) {
			cell.setState(BinaryState.DEAD);
		} else if (state.equals(BinaryState.DEAD)) {
			cell.setState(BinaryState.ALIVE);
		}
	}
}
