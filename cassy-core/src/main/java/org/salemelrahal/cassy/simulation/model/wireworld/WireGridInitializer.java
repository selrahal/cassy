package org.salemelrahal.cassy.simulation.model.wireworld;

import org.salemelrahal.cassy.simulation.cell.DynamicCell;
import org.salemelrahal.cassy.simulation.grid.Grid;
import org.salemelrahal.cassy.simulation.grid.GridCellContainer;
import org.salemelrahal.cassy.simulation.model.field.Field;
import org.salemelrahal.cassy.simulation.model.field.FieldController;

public class WireGridInitializer implements FieldController{

	public void reset(Field field) {
		Grid grid = (Grid) field;
		grid.fillCells(new DynamicCell(WireState.EMTPY));
	}

	public void click(Field field, int x, int y) {
		Grid grid = (Grid) field;
		GridCellContainer cell = grid.getGridCellContainer(x, y);
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

	public void randomize(Field field) {
		// TODO Auto-generated method stub
		
	}

	public void drag(Field field, int x, int y) {
		Grid grid = (Grid) field;
		((GridCellContainer)grid.getGridCellContainer(x, y)).setState(WireState.WIRE);
	}
}
