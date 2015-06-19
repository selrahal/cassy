package org.salemelrahal.cassy.swing.canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.BorderFactory;

import org.salemelrahal.cassy.ant.AntState;
import org.salemelrahal.cassy.common.field.grid.Grid;
import org.salemelrahal.cassy.common.field.grid.GridCellContainer;
import org.salemelrahal.cassy.common.field.grid.GridFactory;
import org.salemelrahal.cassy.gol.LifeState;
import org.salemelrahal.cassy.model.State;
import org.salemelrahal.cassy.wireworld.WireState;
import org.salemelrahal.gol.game.impl.Simulation;

public class DisplayGrid extends GameDisplay implements DisplayField{
	private static final long serialVersionUID = 2697245729821535302L;
	private int offset = 5;;
	private int canvasHeight;
	private int canvasWidth;
	
	public DisplayGrid(int canvasHeight, int canvasWidth, Simulation game) {
		super(game);
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
	
    /* (non-Javadoc)
	 * @see com.salemelrahal.cassy.swing.canvas.DisplayField#getPreferredSize()
	 */
    public Dimension getPreferredSize() {
    	return new Dimension(canvasHeight, canvasWidth);
    }

    /* (non-Javadoc)
	 * @see com.salemelrahal.cassy.swing.canvas.DisplayField#paintComponent(java.awt.Graphics)
	 */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        this.drawCells(g);
        this.drawGrid(g);
    }
    
    private void drawCells(Graphics g) {
    	for (Entry<State, Color> entry : getColorMap().entrySet()) {
    		g.setColor(entry.getValue());
    		List<GridCellContainer> aliveCells = ((Grid)simulation.getField()).getCellsByState(entry.getKey());
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

	/* (non-Javadoc)
	 * @see com.salemelrahal.cassy.swing.canvas.DisplayField#click(int, int)
	 */
	public void click(int x, int y) {
		simulation.click(x/offset, y/offset);
		this.repaintCell(x, y);
	}

	/* (non-Javadoc)
	 * @see com.salemelrahal.cassy.swing.canvas.DisplayField#drag(int, int)
	 */
	public void drag(int x, int y) {
		simulation.drag(x/offset, y/offset);
		this.repaintCell(x, y);
	}
	
	private void repaintCell(int x, int y) {
		int cellx = x/offset;
		int celly = y/offset;
		this.repaint(cellx*offset, celly*offset, offset, offset);
	}

	/* (non-Javadoc)
	 * @see com.salemelrahal.cassy.swing.canvas.DisplayField#setScale(int)
	 */
	public void setScale(int i) {
		offset = i;
		this.repaint();
	}

	/* (non-Javadoc)
	 * @see com.salemelrahal.cassy.swing.canvas.DisplayField#setSize(int)
	 */
	public void setSize(int i) {
		Dimension size = new Dimension(i,i);
		this.resize(i, i);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		canvasHeight = i;
		canvasWidth = i;
		this.simulation.setFieldFactory(new GridFactory(i, i));
		this.repaint();
	}
}
