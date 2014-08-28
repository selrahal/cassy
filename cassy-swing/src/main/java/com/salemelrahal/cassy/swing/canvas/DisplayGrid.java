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
import com.salemelrahal.cassy.common.Grid;
import com.salemelrahal.cassy.common.GridCellContainer;
import com.salemelrahal.cassy.gol.LifeState;
import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;
import com.salemelrahal.cassy.swing.mouse.BinaryMouseAdapter;
import com.salemelrahal.cassy.wireworld.WireState;
import com.salemelrahal.gol.game.impl.Game;

public class DisplayGrid extends JPanel{
	private static final int OFFSET = 3;
	
	//TODO: Factor dimensions out so they can change.
	private int canvasHeight;
	private int canvasWidth;
	private SimulationContainer simulationContainer;
	
    
	public DisplayGrid(SimulationContainer simulationContainer) {
		super();
		this.simulationContainer = simulationContainer;
		this.canvasHeight = ((Grid)(simulationContainer.getGame()).getField()).getHeight() * OFFSET;
		this.canvasWidth = ((Grid)(simulationContainer.getGame()).getField()).getWidth() * OFFSET;
        setBorder(BorderFactory.createLineBorder(Color.black));
        addMouseListener(new BinaryMouseAdapter(simulationContainer, this));
        addMouseMotionListener(new BinaryMouseAdapter(simulationContainer, this));
        
    }

    public Dimension getPreferredSize() {
        return new Dimension(canvasWidth,canvasHeight);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        this.drawCells(g);
        this.drawGrid(g);
    }
    
    private void drawCells(Graphics g) {
    	for (Entry<State, Color> entry : getColorMap().entrySet()) {
    		g.setColor(entry.getValue());
    		List<GridCellContainer> aliveCells = ((Grid)(simulationContainer.getGame()).getField()).getCellsByState(entry.getKey());
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
	
	private Map<State, Color> getColorMap() {
		Map<State, Color> toReturn = new HashMap<State, Color>();
		toReturn.put(LifeState.ALIVE, Color.BLACK);
		toReturn.put(LifeState.DYING, Color.BLUE);
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
		toReturn.put(WireState.EMTPY, Color.WHITE);
		toReturn.put(WireState.HEAD, Color.BLUE);
		toReturn.put(WireState.TAIL, Color.RED);
		toReturn.put(WireState.WIRE, Color.YELLOW);
		return toReturn;
	}
	
	public int getOffset() {
		return OFFSET;
	}
}
