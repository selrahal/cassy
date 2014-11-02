package com.salemelrahal.cassy.common;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.State;

public class DynamicCell implements Cell{
	private State state;
	
	public DynamicCell(State state){
		this.state = state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public DynamicCell clone() {
		return new DynamicCell(state);
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
