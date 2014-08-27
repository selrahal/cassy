package com.salemelrahal.gol.factory.impl;

import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.model.Field;

public class GridFactory {
	private int width;
	private int height;
	
	public GridFactory(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Field next() {
		return new Grid(width, height);
	}
}
