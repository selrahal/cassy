package com.salemelrahal.gol.conway.model;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.State;

public class DynamicCell implements Cell{
	private State state;
	
	public DynamicCell() {
		//Needed?
		this(BinaryState.DEAD);
	}
	
	public DynamicCell(State state){
		this.state = state;
	}
	
	public void setState(State state) {
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

	public boolean shouldChange(State state) {
		return !this.state.equals(state);
	}

	public State getState() {
		return this.state;
	}
	
	public boolean equals(Object object) {
		if (object == null) return false;
		if (!(object instanceof DynamicCell)) return false;
		DynamicCell other = (DynamicCell) object;
		if (!state.equals(other.getState())) return false;
		return true;
	}
}
