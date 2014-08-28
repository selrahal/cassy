package com.salemelrahal.cassy.ant;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Cell;

public class AntGridInitializer implements Initializer<Grid>{

	public void initialize(Grid grid) {
		grid.fillCells(new DynamicCell(new AntState(AntState.Color.WHITE, AntState.Direction.NONE)));
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
			cell.setState(new AntState(AntState.Color.WHITE, AntState.Direction.LEFT));
		}
	}

	public void randomize(Grid field) {
		// TODO Auto-generated method stub
		
	}

	public void drag(Grid grid, int x, int y) {
		grid.getCell(x, y).setState(new AntState(AntState.Color.WHITE, AntState.Direction.LEFT));
	}
}
