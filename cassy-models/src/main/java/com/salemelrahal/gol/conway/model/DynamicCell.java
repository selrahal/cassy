package com.salemelrahal.gol.conway.model;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.State;

public class DynamicCell implements Cell{
	private State state = BinaryState.DEAD;
	
	public void setState(BinaryState state) {
		this.state = state;
	}
	
	public DynamicCell clone() {
		DynamicCell toReturn = new DynamicCell();
		toReturn.setState(state);
		return toReturn;
	}
	
	public String toString() {
		return state.toString();
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean shouldChange(State state) {
		return !this.state.equals(state);
	}

	public State getState() {
		return this.state;
	}
}
