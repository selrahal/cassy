package com.salemelrahal.cassy.model;

import java.util.Collection;

public interface Field {
	public Collection<Cell> getCells();
	public Field clone();
}
