package com.salemelrahal.gol.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.salemelrahal.gol.init.impl.Initializer;

public class Grid {
	private List<List<Cell>> cells;
	private int width;
	private int height;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		clear();
		initialize();
	}
	
	public int height() {
		return this.height;
	}
	
	public int width() {
		return this.width;
	}
	
	public Cell get(int row, int column) {
		return this.getSafe(row, column);
	}
	
	public Collection<Cell> getNeighbors(int row, int column) {
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
				cells.get(row).add(new Cell());
				initializer.init(cells.get(row).get(column), this.getNeighbors(row, column));
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

	public void set(Cell newCell, int row, int column) {
		try {
			cells.get(row).set(column, newCell);
		} catch (Exception e) {
			
		}
	}
	
	public Grid clone() {
		return new Grid(this.width, this.height);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------------------\n");
		for (List<Cell> row : cells) {
			for (Cell cell : row) {
				sb.append(cell.isAlive()? "1" :"0");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
