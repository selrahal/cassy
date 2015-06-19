package org.salemelrahal.cassy.ant;

import org.salemelrahal.cassy.common.DynamicCell;
import org.salemelrahal.cassy.common.field.grid.Grid;
import org.salemelrahal.cassy.common.field.grid.GridCellContainer;
import org.salemelrahal.cassy.model.field.Field;
import org.salemelrahal.cassy.model.field.FieldController;

public class AntGridInitializer implements FieldController{

	public void reset(Field field) {
		Grid grid = (Grid) field;
		grid.fillCells(new DynamicCell(new AntState(AntState.Color.WHITE, AntState.Direction.NONE)));
	}

	public void click(Field field, int x, int y) {
		Grid grid = (Grid) field;
		GridCellContainer gridCellContainer = (GridCellContainer) grid.getGridCellContainer(x, y);
		AntState state = (AntState) gridCellContainer.getState();
		System.out.println(state + " x:" + x + " y:" + y);
		if (!state.getAntFacing().equals(AntState.Direction.NONE)) {
			gridCellContainer.setState(new AntState(AntState.Color.BLACK, AntState.Direction.NONE));
		} else if (state.getColor().equals(AntState.Color.BLACK)) {
			gridCellContainer.setState(new AntState(AntState.Color.WHITE, AntState.Direction.NONE));
		} else if (state.getColor().equals(AntState.Color.WHITE)) {
			gridCellContainer.setState(new AntState(AntState.Color.WHITE, AntState.Direction.LEFT));
		}
	}

	public void randomize(Field field) {
		// TODO Auto-generated method stub
		
	}

	public void drag(Field field, int x, int y) {
		Grid grid = (Grid) field;
		((GridCellContainer)grid.getGridCellContainer(x, y)).setState(new AntState(AntState.Color.WHITE, AntState.Direction.LEFT));
	}
}
