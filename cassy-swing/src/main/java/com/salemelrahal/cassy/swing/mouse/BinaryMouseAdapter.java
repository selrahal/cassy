package com.salemelrahal.cassy.swing.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.salemelrahal.cassy.swing.canvas.DisplayGrid;
import com.salemelrahal.gol.game.impl.Game;

public class BinaryMouseAdapter extends MouseAdapter{
	private Game game;
	DisplayGrid displayGrid;
	
	public BinaryMouseAdapter(Game game, DisplayGrid displayGrid) {
		this.game = game;
		this.displayGrid = displayGrid;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		this.setAlive(e.getX() / displayGrid.getOffset(), e.getY() / displayGrid.getOffset());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		this.setAlive(e.getX() / displayGrid.getOffset(), e.getY() / displayGrid.getOffset());
	}
	
	private void setAlive(int x, int y) {
		System.out.println("set ant x:"+x+"   y:"+y);
		game.click(x,y);
		displayGrid.repaint();
	}

}
