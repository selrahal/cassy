package com.salemelrahal.gol.init.impl;

import java.util.Collection;
import java.util.Random;

import com.salemelrahal.gol.model.impl.Cell;
import com.salemelrahal.gol.model.impl.State;

public class Initializer {
	public void init(Cell cell, Collection<Cell> neighbors) {
		cell.setState(((new Random()).nextBoolean()?State.DEAD:State.ALIVE));
	}
}
