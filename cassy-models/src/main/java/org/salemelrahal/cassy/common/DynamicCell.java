package org.salemelrahal.cassy.common;

import org.salemelrahal.cassy.model.Cell;
import org.salemelrahal.cassy.model.State;

public class DynamicCell implements Cell, Cloneable{
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) return false;
		if (!(object instanceof DynamicCell)) return false;
		DynamicCell other = (DynamicCell) object;
		if (!state.equals(other.getState())) return false;
		return true;
	}
}
