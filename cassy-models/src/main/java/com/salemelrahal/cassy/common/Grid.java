package com.salemelrahal.cassy.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;

public class Grid implements Field{
	private List<List<Cell>> cells;
	private int width;
	private int height;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
//		clear();
	}
	
//	public void clear() {
//		cells = new ArrayList<List<Cell>>(height);
//		for (int i = 0 ; i < height ; i++) {
//			cells.add(new ArrayList<Cell>(width));
//			for (int j = 0; j < width; j++) {
//				cells.get(i).add(new DynamicCell());
//			}
//		}
//	}
	
	
	private Cell getSafe(int row, int column) {
		Cell toReturn = null;
		try {
			toReturn = cells.get(row).get(column);
		} catch (Exception e) {
			
		}
		return toReturn;
	}

	public void set(DynamicCell newCell, int row, int column) {
		try {
			cells.get(row).set(column, newCell);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Grid clone() {
		Grid toReturn = new Grid(this.width, this.height);
		toReturn.cells = new ArrayList<List<Cell>>(height);
		for (int row = 0; row < this.height; row++) {
			toReturn.cells.add(new ArrayList<Cell>(width));
			for (int column = 0; column < this.width; column++) {
				Cell cell = this.cells.get(row).get(column);
				toReturn.cells.get(row).add(cell);
			}
		}
		return toReturn;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------------------\n");
		for (List<Cell> row : cells) {
			sb.append("|");
			for (Cell cell : row) {
				sb.append(cell.getState() + "|");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public Collection<Cell> getCells() {
		Collection<Cell> toReturn = new ArrayList<Cell>(height * width);
		for (List<Cell> row : this.cells){
			toReturn.addAll(row);
		}
		return toReturn;
	}

	public Collection<Cell> getNeighbors(int row, int column) {
//		Collection<Cell> neighbors = new ArrayList<Cell>();
//		Coordinate cCell = this.findCell(cell);
//		if (cCell == null) {
//			throw new RuntimeException("Cell not here!!!");
//		}
//		int row = cCell.row;
//		int column = cCell.column;
		Collection<Cell> neighbors = new ArrayList<Cell>();
		for (int i = -1 ; i < 2 ; i++) {
			for (int j = -1; j < 2; j++) {
				Cell toAdd = this.getSafe(row + i, column + j);
				if (toAdd != null) {
					if (i != 0 || j!= 0) {
						neighbors.add(toAdd);
					}
				}
			}
		}
		return neighbors;
	}

//	public void replace(Cell cell, Cell newCell) {
//		Coordinate cCell = this.findCell(cell);
//		if (cCell == null) {
//			throw new RuntimeException("Cell not here!" + cell);
//		} else {
//			this.cells.get(cCell.row).set(cCell.column, newCell);
//		}
//		
//	}
	
//	private Coordinate findCell(Cell cell){
//		for (int row = 0; row < this.height; row++) {
//			for (int column = 0; column < this.width; column++) {
//				if (this.cells.get(row).get(column).equals(cell)) {
//					Coordinate toReturn = new Coordinate();
//					toReturn.row = row;
//					toReturn.column = column;
//					return toReturn;
//				}
//			}
//		}
//		return null;
//	}
	
	private class Coordinate {
		int row,column;
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
				Cell cell = this.cells.get(row).get(column);
				if (cell.getState().equals(state)) {
					toReturn.add(new GridCellContainer(cell, column, row));
				}
			}
		}
		return toReturn;
	}
	
	public Cell getCell(int x, int y){
		return this.getSafe(y, x);
	}
	
	public boolean equals(Object object) {
		if (object == null) return false;
		if (!(object instanceof Grid)) return false;
		Grid other = (Grid) object;
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (!this.getCell(x,y).equals(other.getCell(x,y))) {
					return false;
				}
			}
		}
		return true;
	}

	public void fillCells(DynamicCell dynamicCell) {
		cells = new ArrayList<List<Cell>>(height);
		for (int i = 0 ; i < height ; i++) {
			cells.add(new ArrayList<Cell>(width));
			for (int j = 0; j < width; j++) {
				cells.get(i).add(dynamicCell.clone());
			}
		}
	}

}
