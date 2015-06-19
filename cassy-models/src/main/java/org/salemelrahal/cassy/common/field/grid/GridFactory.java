package org.salemelrahal.cassy.common.field.grid;

import org.salemelrahal.cassy.model.field.FieldFactory;

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
