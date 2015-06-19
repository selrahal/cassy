package org.salemelrahal.cassy.simulation.model.ant;

import org.salemelrahal.cassy.simulation.cell.State;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antFacing == null) ? 0 : antFacing.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object object) {
		if (object == null) return false;
		if (!(object instanceof AntState)) return false;
		AntState other = (AntState) object;
		if (!other.getAntFacing().equals(antFacing)) return false;
		if (!other.getColor().equals(color)) return false;
		return true;
	}
}
