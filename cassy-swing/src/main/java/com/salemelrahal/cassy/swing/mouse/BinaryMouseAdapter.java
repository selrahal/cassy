package com.salemelrahal.cassy.swing.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.salemelrahal.gol.game.impl.Game;

public class BinaryMouseAdapter extends MouseAdapter{
	private Game game;
	private JPanel jPanel;
	
	public BinaryMouseAdapter(Game game, JPanel jPanel) {
		this.game = game;
		this.jPanel = jPanel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		this.setAlive(e.getX() / 10, e.getY() / 10);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		this.setAlive(e.getX() / 10, e.getY() / 10);
	}
	
	private void setAlive(int x, int y) {
		System.out.println("set ant x:"+x+"   y:"+y);
		game.click(x,y);
		jPanel.repaint();
	}

}
