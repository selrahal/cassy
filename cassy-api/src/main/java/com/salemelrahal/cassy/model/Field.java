package com.salemelrahal.cassy.model;

import java.util.Collection;

public interface Field {
	public Collection<Cell> getCells();
//	public Collection<Cell> getNeighbors(Cell cell);
	public Field clone();
//	public void replace(Cell cell, Cell newCell);
	public void clear();
}
