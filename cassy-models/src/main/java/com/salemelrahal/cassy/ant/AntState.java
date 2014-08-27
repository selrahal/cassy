package com.salemelrahal.cassy.ant;

import com.salemelrahal.cassy.model.State;

public class AntState implements State{
	private Color color;
	private Direction antFacing;
	public enum Direction {
		NONE, UP, DOWN, LEFT, RIGHT;
	}
	public enum Color {
		BLACK, WHITE;
	}
	public AntState(Color color, Direction antFacing) {
		super();
		this.color = color;
		this.antFacing = antFacing;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Direction getAntFacing() {
		return antFacing;
	}
	public void setAntFacing(Direction antFacing) {
		this.antFacing = antFacing;
	}
	public String toString() {
		return color + ":" + antFacing;
	}
	public boolean equals(Object object) {
		if (object == null) return false;
		if (!(object instanceof AntState)) return false;
		AntState other = (AntState) object;
		if (!other.getAntFacing().equals(antFacing)) return false;
		if (!other.getColor().equals(color)) return false;
		return true;
	}
}
