package com.salemelrahal.gol.model.impl;

public class Cell {
	private static long nextId = 1;
	private long id;
	private State state = State.DEAD;
	
	public Cell() {
		id = nextId;
		nextId++;
	}
	
	public long getId(){
		return id;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public boolean isAlive() {
		return State.ALIVE.equals(state);
	}
	
	public Cell clone() {
		Cell toReturn = new Cell();
		toReturn.setState(state);
		return toReturn;
	}
	
	public String toString() {
		return "id:" + id + "state:" + state;
	}
}
