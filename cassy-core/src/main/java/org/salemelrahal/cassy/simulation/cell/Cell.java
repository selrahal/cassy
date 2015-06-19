package org.salemelrahal.cassy.simulation.cell;

/**
 * An automaton, has a state.
 *
 */
public interface Cell {
	public State getState();
	public void setState(State state);
	public Cell clone();
}
