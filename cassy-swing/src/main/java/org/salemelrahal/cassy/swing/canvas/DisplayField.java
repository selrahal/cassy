package org.salemelrahal.cassy.swing.canvas;

import java.awt.Dimension;
import java.awt.Graphics;

import org.salemelrahal.cassy.simulation.SimulationConfiguration;

public interface DisplayField {

	public abstract Dimension getPreferredSize();

	public abstract void paintComponent(Graphics g);

	public abstract void click(int x, int y);

	public abstract void drag(int x, int y);

	public abstract void setSimulation(SimulationConfiguration simulation);

	public abstract void setScale(int i);

	public abstract void setSize(int i);

}