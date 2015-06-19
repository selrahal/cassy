package org.salemelrahal.cassy.model;

/**
 * An automaton, has a state.
 *
 */
public interface Cell {
	public State getState();
	public void setState(State state);
	public Cell clone();
}
