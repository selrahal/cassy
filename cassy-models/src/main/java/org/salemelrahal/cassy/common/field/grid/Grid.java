package org.salemelrahal.cassy.common.field.grid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.salemelrahal.cassy.common.DynamicCell;
import org.salemelrahal.cassy.model.State;
import org.salemelrahal.cassy.model.field.Field;
import org.salemelrahal.cassy.model.field.Node;

public class Grid implements Field, Cloneable{
	private List<List<GridCellContainer>> cells;
	private int width;
	private int height;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	private GridCellContainer getSafe(int x, int y) {
		GridCellContainer toReturn = null;
		try {
			toReturn = cells.get(y).get(x);
		} catch (Exception e) {
			
		}
		return toReturn;
	}

	public void set(DynamicCell newCell, int row, int column) {
		try {
			cells.get(row).set(column, new GridCellContainer(newCell, column, row));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Grid clone() {
		Grid toReturn = new Grid(this.width, this.height);
		toReturn.cells = new ArrayList<List<GridCellContainer>>(height);
		for (int row = 0; row < this.height; row++) {
			toReturn.cells.add(new ArrayList<GridCellContainer>(width));
			for (int column = 0; column < this.width; column++) {
				toReturn.cells.get(row).add(this.cells.get(row).get(column).clone());
			}
		}
		return toReturn;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------------------\n");
		for (List<GridCellContainer> row : cells) {
			sb.append("|");
			for (GridCellContainer container : row) {
				sb.append(container.getState() + "|");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public Collection<Node> getNodes() {
		Collection<Node> toReturn = new ArrayList<Node>(height * width);
		for (List<GridCellContainer> row : this.cells){
			for (GridCellContainer element : row) {
				toReturn.add((Node)element);
			}
		}
		return toReturn;
	}
	

	public Collection<GridCellContainer> getNeighbors(GridCellContainer container) {
		Collection<GridCellContainer> neighbors = new ArrayList<GridCellContainer>();
		for (int i = -1 ; i < 2 ; i++) {
			for (int j = -1; j < 2; j++) {
				int x = container.getX() + j;
				int y = container.getY() + i;
				GridCellContainer toAdd = this.getSafe(x,y);
				if (toAdd != null) {
					if (i != 0 || j!= 0) {
						neighbors.add(toAdd);
					}
				}
			}
		}
		return neighbors;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public List<GridCellContainer> getCellsByState(State state){
		List<GridCellContainer> toReturn = new ArrayList<GridCellContainer>();
		for (int row = 0; row < this.height; row++) {
			for (int column = 0; column < this.width; column++) {
				GridCellContainer container = this.cells.get(row).get(column);
				if (container.getState().equals(state)) {
					toReturn.add(container.clone());
				}
			}
		}
		return toReturn;
	}
	
	public GridCellContainer getGridCellContainer(int x, int y){
		return this.getSafe(x, y);
	}

	public void fillCells(DynamicCell dynamicCell) {
		cells = new ArrayList<List<GridCellContainer>>(height);
		for (int i = 0 ; i < height ; i++) {
			cells.add(new ArrayList<GridCellContainer>(width));
			for (int j = 0; j < width; j++) {
				cells.get(i).add(new GridCellContainer(dynamicCell.clone(), j, i));
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cells == null) ? 0 : cells.hashCode());
		result = prime * result + height;
		result = prime * result + width;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) return false;
		if (!(object instanceof Grid)) return false;
		Grid other = (Grid) object;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (!this.getGridCellContainer(x,y).equals(other.getGridCellContainer(x,y))) {
					return false;
				}
			}
		}
		return true;
	}

}
