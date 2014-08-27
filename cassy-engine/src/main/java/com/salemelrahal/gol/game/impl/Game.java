package com.salemelrahal.gol.game.impl;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.rule.Rule;

public class Game {
	private Field field;
	private Field nextField;
	private Rule rule;
	private Initializer initializer;
	
	public Game(Field field, Rule rule, Initializer initializer) {
		this.field =field;
		this.rule = rule;
		this.nextField = field.clone();
		this.initializer = initializer;
	}
	
	//Only support synchronous updating for now
	//will return a boolean indicating whether or not a change has occured
	public boolean iterate() {
		boolean changed = false;
//		this.nextField = this.field.clone();
		
//		for (Cell cell : field.getCells()) {
//			State newState = rule.calculateNextState(cell, field);
//			if (cell.shouldChange(newState)) {
//				changed = true;
//				Cell newCell = cell.clone();
//				newCell.setState(newState);
//				nextField.replace(cell, newCell);
//			}
//		}
		
//		this.field = this.nextField;
		
		
		Field nextField = rule.calculateNextField(field);
		changed = !nextField.equals(field);
		this.field = nextField;
		return changed;
	}
	
	public String toString() {
		return rule.toString() + "\n" + field.toString();
	}
	
	public void init() {
		initializer.initialize(field);
	}
	
	public Field getField(){
		return this.field;
	}
	
	public void reset() {
//		this.field.clear();
		init();
	}
	
	public void click(int x, int y) {
		initializer.click(field, x, y);
	}
}
