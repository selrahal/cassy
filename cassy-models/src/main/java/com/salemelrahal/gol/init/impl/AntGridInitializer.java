package com.salemelrahal.gol.init.impl;

import com.salemelrahal.cassy.ant.AntState;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.gol.conway.model.BinaryState;
import com.salemelrahal.gol.conway.model.DynamicCell;
import com.salemelrahal.gol.conway.model.Grid;

public class AntGridInitializer implements Initializer<Grid>{

	public void initialize(Grid grid) {
		int height = grid.getHeight();
		int width = grid.getWidth();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				DynamicCell cell = new DynamicCell();
//				cell.setState(((new Random()).nextBoolean()?BinaryState.DEAD:BinaryState.ALIVE));
				
				cell.setState(new AntState(AntState.Color.WHITE, AntState.Direction.NONE));
				grid.set(cell, row, column);
//				initializer.init(cells.get(row).get(column), this.getNeighbors(cells.get(row).get(column)));
			}
		}
	}

	public void click(Grid grid, int x, int y) {
		Cell cell = grid.getCell(x, y);
		AntState state = (AntState)cell.getState();
		System.out.println(state + " x:" + x + " y:" + y);
		if (!state.getAntFacing().equals(AntState.Direction.NONE)) {
			cell.setState(new AntState(AntState.Color.BLACK, AntState.Direction.NONE));
		} else if (state.getColor().equals(AntState.Color.BLACK)) {
			cell.setState(new AntState(AntState.Color.WHITE, AntState.Direction.NONE));
		} else if (state.getColor().equals(AntState.Color.WHITE)) {
			cell.setState(new AntState(AntState.Color.WHITE, AntState.Direction.RIGHT));
		}
	}
}
