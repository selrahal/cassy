package com.salemelrahal.gol.game.impl;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.rule.Rule;

public class Game {
	private Field field;
	private Field nextField;
	private Rule rule;
	
	public Game(Field field, Rule rule) {
		this.field =field;
		this.rule = rule;
		this.nextField = field.clone();
	}
	
	//Only support synchronous updating for now
	//will return a boolean indicating whether or not a change has occured
	public boolean iterate() {
		boolean changed = false;
		
		for (Cell cell : field.getCells()) {
			State newState = rule.calculateNextState(cell, field);
			if (cell.shouldChange(newState)) {
				changed = true;
				Cell newCell = cell.clone();
				newCell.setState(newState);
				nextField.replace(cell, newCell);
			}
		}
		
		this.field = this.nextField.clone();
		return changed;
	}
	
	public String toString() {
		return rule.toString() + "\n" + field.toString();
	}
}
