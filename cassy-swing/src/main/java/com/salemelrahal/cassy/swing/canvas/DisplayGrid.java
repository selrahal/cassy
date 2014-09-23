package com.salemelrahal.cassy.swing.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
import com.salemelrahal.cassy.simulation.Simulation;
import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;
import com.salemelrahal.cassy.wireworld.WireState;

public class DisplayGrid extends JPanel{
	private static final long serialVersionUID = 2697245729821535302L;
	private int offset = 5;;
	private int canvasHeight;
	private int canvasWidth;
	private SimulationContainer simulationContainer;
	
    
	public DisplayGrid(int canvasHeight, int canvasWidth, SimulationContainer simulationContainer) {
		super();
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
		this.simulationContainer = simulationContainer;
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
	
    public Dimension getPreferredSize() {
    	return new Dimension(canvasHeight, canvasWidth);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        this.drawCells(g);
        this.drawGrid(g);
    }
    
    private void drawCells(Graphics g) {
    	for (Entry<State, Color> entry : getColorMap().entrySet()) {
    		g.setColor(entry.getValue());
    		List<GridCellContainer> aliveCells = ((Grid)simulationContainer.getField()).getCellsByState(entry.getKey());
    		for (GridCellContainer container : aliveCells) {
	    		g.fillRect(container.getX() * offset, container.getY() * offset, offset, offset);
	    	}
    	}
    }
    
    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int x = 0; x < canvasWidth; x += offset) {
        	g.drawLine(x, 0, x, canvasHeight);
        }
    	for (int y = 0; y < canvasHeight; y += offset) {
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
		return offset;
	}
	
	public void addMouseListener(MouseListener listener) {
		super.addMouseListener(listener);
	}
	
	public void addMouseMotionListener(MouseMotionListener listener) {
		super.addMouseMotionListener(listener);
	}

	public void click(int x, int y) {
		simulationContainer.click(x/offset, y/offset);
		this.repaintCell(x, y);
	}

	public void drag(int x, int y) {
		simulationContainer.drag(x/offset, y/offset);
		this.repaintCell(x, y);
	}
	
	private void repaintCell(int x, int y) {
		int cellx = x/offset;
		int celly = y/offset;
		this.repaint(cellx*offset, celly*offset, offset, offset);
	}

	public void setSimulation(Simulation simulation) {
		simulationContainer.setSimulation(simulation);
		this.repaint();
	}
}
