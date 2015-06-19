package org.salemelrahal.cassy.simulation.model.gol;

import java.util.Random;

import org.salemelrahal.cassy.simulation.cell.DynamicCell;
import org.salemelrahal.cassy.simulation.grid.Grid;
import org.salemelrahal.cassy.simulation.grid.GridCellContainer;
import org.salemelrahal.cassy.simulation.model.field.Field;
import org.salemelrahal.cassy.simulation.model.field.FieldController;

public class GridInitializer implements FieldController{
	private static final Random RANDOM_INSTANCE = new Random();
	
	public void randomize(Field field) {
		Grid grid = (Grid) field;
		int height = grid.getHeight();
		int width = grid.getWidth();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				DynamicCell cell = new DynamicCell((RANDOM_INSTANCE.nextBoolean()?LifeState.DEAD:LifeState.ALIVE));
				grid.set(cell, row, column);
			}
		}
	}

	public void reset(Field field) {
		Grid grid = (Grid) field;
		grid.fillCells(new DynamicCell(LifeState.DEAD));
	}

	public void click(Field field, int x, int y) {
		Grid grid = (Grid) field;
		GridCellContainer cell = grid.getGridCellContainer(x, y);
		LifeState state = (LifeState)cell.getState();
		if (state.equals(LifeState.ALIVE)) {
			cell.setState(LifeState.DEAD);
		} else if (state.equals(LifeState.DEAD)) {
			cell.setState(LifeState.ALIVE);
		}
	}

	public void drag(Field field, int x, int y) {
		Grid grid = (Grid) field;
		((GridCellContainer)grid.getGridCellContainer(x, y)).setState(LifeState.ALIVE);
	}
}
