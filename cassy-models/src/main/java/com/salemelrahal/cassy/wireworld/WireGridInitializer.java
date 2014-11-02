package com.salemelrahal.cassy.wireworld;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Cell;

public class WireGridInitializer implements Initializer<Grid>{

	public void initialize(Grid grid) {
		grid.fillCells(new DynamicCell(WireState.EMTPY));
	}

	public void click(Grid grid, int x, int y) {
		Cell cell = grid.getCell(x, y);
		WireState state = (WireState)cell.getState();
		if (state.equals(WireState.EMTPY)) {
			cell.setState(WireState.WIRE);
		} else if (state.equals(WireState.WIRE)) {
			cell.setState(WireState.HEAD);
		} else if (state.equals(WireState.HEAD)) {
			cell.setState(WireState.TAIL);
		} else if (state.equals(WireState.TAIL)) {
			cell.setState(WireState.EMTPY);
		}
	}

	public void randomize(Grid field) {
		// TODO Auto-generated method stub
		
	}

	public void drag(Grid grid, int x, int y) {
		grid.getCell(x, y).setState(WireState.WIRE);
	}
}
