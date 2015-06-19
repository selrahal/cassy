package org.salemelrahal.cassy.common.field.grid;

import org.salemelrahal.cassy.model.Cell;
import org.salemelrahal.cassy.model.State;

public class GridCellContainer implements Cloneable{
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof GridCellContainer)) {
			return false;
		}
		GridCellContainer other = (GridCellContainer) obj;
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
