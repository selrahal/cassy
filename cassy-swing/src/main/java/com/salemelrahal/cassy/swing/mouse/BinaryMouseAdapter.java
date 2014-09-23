package com.salemelrahal.cassy.swing.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.salemelrahal.cassy.swing.canvas.DisplayGrid;

public class BinaryMouseAdapter extends MouseAdapter{
	private DisplayGrid displayGrid;
	
	public BinaryMouseAdapter(DisplayGrid displayGrid) {
		this.displayGrid = displayGrid;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		displayGrid.click(e.getX(),e.getY());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		displayGrid.drag(e.getX(),e.getY());
	}

}
