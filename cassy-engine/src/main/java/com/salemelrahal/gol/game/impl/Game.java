package com.salemelrahal.gol.game.impl;

import com.salemelrahal.cassy.init.Initializer;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.model.field.Field;
import com.salemelrahal.cassy.rule.Rule;

public class Game<F extends Field, S extends State> {
	private F field;
	private Rule<S,F> rule;
	private Initializer<F> initializer;
	
	public Game(F field, Rule<S,F> rule, Initializer<F> initializer) {
		this.field =field;
		this.rule = rule;
		this.initializer = initializer;
		initializer.initialize(field);
	}
	
	public boolean iterate() {
		boolean changed = false;		
		F nextField = rule.calculateNextField(field);
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
		init();
	}
	
	public void click(int x, int y) {
		initializer.click(field, x, y);
	}

	public void randomize() {
		initializer.randomize(field);
	}

	public void drag(int x, int y) {
		initializer.drag(field, x, y);
	}

	public void setField(F field ) {
		this.field = field;
	}
}
