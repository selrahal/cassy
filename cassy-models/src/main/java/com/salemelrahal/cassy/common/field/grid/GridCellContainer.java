package com.salemelrahal.cassy.common.field.grid;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.model.field.Node;

public class GridCellContainer implements Node{
	private Cell cell;
	private int x;
	private int y;
	public GridCellContainer(Cell cell, int x, int y) {
		super();
		this.cell = cell;
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setState(State antState) {
		cell.setState(antState);
	}
	public State getState() {
		return cell.getState();
	}
	public GridCellContainer clone() {
		return new GridCellContainer(cell.clone(), x, y);
	}
}
