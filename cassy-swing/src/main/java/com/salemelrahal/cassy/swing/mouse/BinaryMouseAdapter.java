package com.salemelrahal.cassy.swing.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.salemelrahal.cassy.swing.canvas.DisplayGrid;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;

public class BinaryMouseAdapter extends MouseAdapter{
	private SimulationContainer simulationContainer;
	private DisplayGrid displayGrid;
	
	public BinaryMouseAdapter(SimulationContainer simulationContainer, DisplayGrid displayGrid) {
		this.simulationContainer = simulationContainer;
		this.displayGrid = displayGrid;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		int x = e.getX() / displayGrid.getOffset();
		int y =  e.getY() / displayGrid.getOffset();
		simulationContainer.getGame().click(x,y);
		this.setAlive(e.getX(),e.getY());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		int x = e.getX() / displayGrid.getOffset();
		int y =  e.getY() / displayGrid.getOffset();
		simulationContainer.getGame().drag(x,y);
		this.setAlive(e.getX(),e.getY());
	}
	
	private void setAlive(int x, int y) {
		
		displayGrid.repaint(x, y, displayGrid.getOffset(), displayGrid.getOffset());
	}

}
