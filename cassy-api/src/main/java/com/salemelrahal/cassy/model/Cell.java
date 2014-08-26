package com.salemelrahal.cassy.model;

public interface Cell {
	public State getState();
	public void setState(State state);
	public boolean shouldChange(State state);
	public Cell clone();
}
