package com.salemelrahal.gol.conway.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.gol.init.impl.Initializer;

public class Grid implements Field{
	private List<List<Cell>> cells;
	private int width;
	private int height;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		clear();
		initialize();
	}
	
	public void clear() {
		cells = new ArrayList<List<Cell>>(height);
		for (int i = 0 ; i < height ; i++) {
			cells.add(new ArrayList<Cell>(width));
		}
	}
	
	public void initialize() {
		Initializer initializer = new Initializer();
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width;column++) {
				cells.get(row).add(new DynamicCell());
				initializer.init(cells.get(row).get(column), this.getNeighbors(cells.get(row).get(column)));
			}
		}
	}
	
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
			
		}
	}
	
	public Grid clone() {
		Grid toReturn = new Grid(this.width, this.height);
		for (int row = 0; row < this.height; row++) {
			for (int column = 0; column < this.width; column++) {
				Cell cell = this.cells.get(row).get(column);
				toReturn.cells.get(row).set(column, cell);
			}
		}
		return toReturn;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------------------\n");
		for (List<Cell> row : cells) {
			for (Cell cell : row) {
				sb.append(cell.getState().equals(BinaryState.ALIVE)? "1" :"0");
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

	public Collection<Cell> getNeighbors(Cell cell) {
		Collection<Cell> neighbors = new ArrayList<Cell>();
		Coordinate cCell = this.findCell(cell);
		if (cCell == null) {
			throw new RuntimeException("Cell not here!!!");
		}
		int row = cCell.row;
		int column = cCell.column;
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

	public void replace(Cell cell, Cell newCell) {
		Coordinate cCell = this.findCell(cell);
		if (cCell == null) {
			throw new RuntimeException("Cell not here!");
		} else {
			this.cells.get(cCell.row).set(cCell.column, newCell);
		}
		
	}
	
	private Coordinate findCell(Cell cell){
		for (int row = 0; row < this.height; row++) {
			for (int column = 0; column < this.width; column++) {
				if (this.cells.get(row).get(column).equals(cell)) {
					Coordinate toReturn = new Coordinate();
					toReturn.row = row;
					toReturn.column = column;
					return toReturn;
				}
			}
		}
		return null;
	}
	
	private class Coordinate {
		int row,column;
	}
}
