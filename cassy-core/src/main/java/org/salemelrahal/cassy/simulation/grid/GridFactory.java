package org.salemelrahal.cassy.simulation.grid;

import org.salemelrahal.cassy.simulation.model.field.FieldFactory;

public class GridFactory implements FieldFactory{
	private int width;
	private int height;
	
	public GridFactory(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Grid next() {
		return new Grid(width, height);
	}
}
