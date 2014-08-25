package com.salemelrahal.gol.factory.impl;

import com.salemelrahal.gol.model.impl.Grid;

public class GridFactory {
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
