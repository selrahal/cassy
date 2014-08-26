package com.salemelrahal.gol.init.impl;

import java.util.Collection;
import java.util.Random;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.gol.conway.model.BinaryState;

public class Initializer {
	public void init(Cell cell, Collection<Cell> neighbors) {
		cell.setState(((new Random()).nextBoolean()?BinaryState.DEAD:BinaryState.ALIVE));
	}
}
