package com.salemelrahal.cassy.common.field.graph;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.model.field.Node;

public class GraphCellContainer implements Node{
	private Cell cell;
	
	public GraphCellContainer (Cell cell) {
		this.cell = cell;
	}
	
	public void setState(State antState) {
		cell.setState(antState);
	}

	public State getState() {
		return cell.getState();
	}
	
	public GraphCellContainer clone() {
		return new GraphCellContainer(this.cell.clone());
	}
}
