package com.salemelrahal.gol.rule.impl;

import java.util.Collection;

import com.salemelrahal.gol.model.impl.Cell;
import com.salemelrahal.gol.model.impl.State;

public class ClassicRule {
	//should take a cell and a grid
	public Cell determineNewState(Cell cell, Collection<Cell> neighbors) {
		int aliveNeighbors = 0;
		for (Cell neighbor : neighbors) {
			if (neighbor.isAlive()) {
				aliveNeighbors++;
			}
		}
		Cell toReturn = cell.clone();
		if (aliveNeighbors < 2){
			toReturn.setState(State.DEAD);
		}else if (aliveNeighbors == 2 && cell.isAlive()){
			toReturn.setState(State.ALIVE);
		}else if (aliveNeighbors == 2 && !cell.isAlive()) {
			toReturn.setState(State.DEAD);
		}else if (aliveNeighbors == 3){
			toReturn.setState(State.ALIVE);
		}else {
			toReturn.setState(State.DEAD);
		}
		return toReturn;
	}
	
	public String toString() {
		return "Conway's Game of Life";
	}
}
