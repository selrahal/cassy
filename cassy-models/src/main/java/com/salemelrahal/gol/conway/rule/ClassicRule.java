package com.salemelrahal.gol.conway.rule;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;
import com.salemelrahal.gol.conway.model.BinaryState;

public class ClassicRule implements Rule{
	public State calculateNextState(Cell cell, Field field) {
		int aliveNeighbors = 0;
		for (Cell neighbor : field.getNeighbors(cell)) {
			if (neighbor.getState().equals(BinaryState.ALIVE)) {
				aliveNeighbors++;
			}
		}
		if (aliveNeighbors < 2){
			return BinaryState.DEAD;
		}else if (aliveNeighbors == 2 && cell.getState().equals(BinaryState.ALIVE)){
			return BinaryState.ALIVE;
		}else if (aliveNeighbors == 2 && !cell.getState().equals(BinaryState.ALIVE)) {
			return BinaryState.DEAD;
		}else if (aliveNeighbors == 3){
			return BinaryState.ALIVE;
		}else {
			return BinaryState.DEAD;
		}
	}
	
	public String toString() {
		return "Conway's Game of Life";
	}
}
