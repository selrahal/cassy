package com.salemelrahal.cassy.swing.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.salemelrahal.cassy.ant.AntState;
import com.salemelrahal.cassy.swing.canvas.DisplayGrid;
import com.salemelrahal.gol.conway.model.BinaryState;
import com.salemelrahal.gol.conway.model.DynamicCell;
import com.salemelrahal.gol.conway.model.Grid;

public class AntMouseAdapter extends MouseAdapter{
	private DisplayGrid grid;
	
	public AntMouseAdapter(DisplayGrid grid) {
		this.grid = grid;
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
		System.out.println("set alive x:"+x+"   y:"+y);
		AntState state = new AntState(AntState.Color.WHITE, AntState.Direction.LEFT);
		grid.set(new DynamicCell(state), x, y);
	}

}
