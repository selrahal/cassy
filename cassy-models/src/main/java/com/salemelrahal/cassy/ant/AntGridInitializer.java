package com.salemelrahal.cassy.ant;

import com.salemelrahal.cassy.common.DynamicCell;
import com.salemelrahal.cassy.common.field.grid.Grid;
import com.salemelrahal.cassy.common.field.grid.GridCellContainer;
import com.salemelrahal.cassy.init.Initializer;

public class AntGridInitializer implements Initializer<Grid>{

	public void initialize(Grid grid) {
		grid.fillCells(new DynamicCell(new AntState(AntState.Color.WHITE, AntState.Direction.NONE)));
	}

	public void click(Grid grid, int x, int y) {
		GridCellContainer<AntState> gridCellContainer = (GridCellContainer<AntState>) grid.getGridCellContainer(x, y);
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

	public void randomize(Grid field) {
		// TODO Auto-generated method stub
		
	}

	public void drag(Grid grid, int x, int y) {
		((GridCellContainer<AntState>)grid.getGridCellContainer(x, y)).setState(new AntState(AntState.Color.WHITE, AntState.Direction.LEFT));
	}
}
