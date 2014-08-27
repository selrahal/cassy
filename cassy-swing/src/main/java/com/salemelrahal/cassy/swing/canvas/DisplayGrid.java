package com.salemelrahal.cassy.swing.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.salemelrahal.cassy.ant.AntState;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.swing.mouse.BinaryMouseAdapter;
import com.salemelrahal.gol.conway.model.BinaryState;
import com.salemelrahal.gol.conway.model.DynamicCell;
import com.salemelrahal.gol.conway.model.Grid;
import com.salemelrahal.gol.conway.model.GridCellContainer;
import com.salemelrahal.gol.game.impl.Game;

public class DisplayGrid extends JPanel{
	private static final int OFFSET = 10;
	private int canvasHeight;
	private int canvasWidth;
	private Game game;
	
    
	public DisplayGrid(Game game) {
		super();
		this.game = game;
		this.canvasHeight = ((Grid)game.getField()).getHeight() * OFFSET;
		this.canvasWidth = ((Grid)game.getField()).getWidth() * OFFSET;
		
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        addMouseListener(new BinaryMouseAdapter(game, this));
        addMouseMotionListener(new BinaryMouseAdapter(game, this));
        
//        addMouseListener(new AntMouseAdapter(this));
//        addMouseMotionListener(new AntMouseAdapter(this));
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvasWidth,canvasHeight);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        System.out.println("paintComponent called");
        this.drawCells(g);
        this.drawGrid(g);
    }
    
    private void drawCells(Graphics g) {
    	for (Entry<State, Color> entry : getColorMap().entrySet()) {
    		g.setColor(entry.getValue());
    		List<GridCellContainer> aliveCells = ((Grid)game.getField()).getCellsByState(entry.getKey());
    		System.out.println("Fetched " + aliveCells.size() + " alive cells");
    		for (GridCellContainer container : aliveCells) {
	    		g.fillRect(container.getX() * OFFSET, container.getY() * OFFSET, OFFSET, OFFSET);
	    	}
    	}
    }
    
    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int x = 0; x < canvasWidth; x += OFFSET) {
        	g.drawLine(x, 0, x, canvasHeight);
        }
    	for (int y = 0; y < canvasHeight; y += OFFSET) {
    		g.drawLine(0, y, canvasWidth, y);
    	}
    }

	public void set(DynamicCell dynamicCell, int x, int y) {
		((Grid)game.getField()).set(dynamicCell, y, x);
		repaint();
	}
	
	private Map<State, Color> getColorMap() {
		Map<State, Color> toReturn = new HashMap<State, Color>();
		toReturn.put(BinaryState.ALIVE, Color.BLACK);
//		toReturn.put(BinaryState.DEAD, Color.WHITE);
//		toReturn.put(new AntState(AntState.Color.WHITE, AntState.Direction.NONE), Color.WHITE);
		toReturn.put(new AntState(AntState.Color.BLACK, AntState.Direction.NONE), Color.BLACK);
		toReturn.put(new AntState(AntState.Color.WHITE, AntState.Direction.UP), Color.RED);
		toReturn.put(new AntState(AntState.Color.WHITE, AntState.Direction.DOWN), Color.RED);
		toReturn.put(new AntState(AntState.Color.WHITE, AntState.Direction.LEFT), Color.RED);
		toReturn.put(new AntState(AntState.Color.WHITE, AntState.Direction.RIGHT), Color.RED);
		toReturn.put(new AntState(AntState.Color.BLACK, AntState.Direction.UP), Color.RED);
		toReturn.put(new AntState(AntState.Color.BLACK, AntState.Direction.DOWN), Color.RED);
		toReturn.put(new AntState(AntState.Color.BLACK, AntState.Direction.LEFT), Color.RED);
		toReturn.put(new AntState(AntState.Color.BLACK, AntState.Direction.RIGHT), Color.RED);
		return toReturn;
	}
}
