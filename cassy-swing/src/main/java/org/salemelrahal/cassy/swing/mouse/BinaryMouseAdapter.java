package org.salemelrahal.cassy.swing.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.salemelrahal.cassy.swing.canvas.DisplayField;

public class BinaryMouseAdapter extends MouseAdapter{
	private DisplayField displayGrid;
	
	public BinaryMouseAdapter(DisplayField displayGrid) {
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
