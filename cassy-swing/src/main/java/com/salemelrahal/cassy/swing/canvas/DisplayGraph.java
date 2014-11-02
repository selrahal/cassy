package com.salemelrahal.cassy.swing.canvas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;

public class DisplayGraph extends SimulationContainerDisplay implements DisplayField{
	private int height, width;
	
	public DisplayGraph (int height, int width, SimulationContainer simulationContainer) {
		super(simulationContainer);
		this.height = height;
		this.width = width;
	}

	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void addMouseListener(MouseListener listener) {
		super.addMouseListener(listener);
	}

	public void addMouseMotionListener(MouseMotionListener listener) {
		super.addMouseMotionListener(listener);
	}

	public void click(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void drag(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	public void setScale(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setSize(int i) {
		// TODO Auto-generated method stub
		
	}

}
