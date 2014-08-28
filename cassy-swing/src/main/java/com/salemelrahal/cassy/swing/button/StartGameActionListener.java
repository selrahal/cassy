package com.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;

import com.salemelrahal.cassy.swing.conatiner.SimulationContainer;
import com.salemelrahal.gol.game.impl.Game;

public class StartGameActionListener implements ActionListener{
	private SimulationContainer simulationContainer;
	private JComponent field;
	private boolean running = false;
	private JSlider slider;
	
	public StartGameActionListener(SimulationContainer simulationContainer, JComponent field, JSlider slider) {
		this.simulationContainer = simulationContainer;
		this.field = field;
		this.slider = slider;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		if ("step".equals(arg0.getActionCommand())) {
			(simulationContainer.getGame()).iterate();
			field.repaint();
		} else if ("stop".equals(arg0.getActionCommand())) {
			running = false;
		} else if ("start".equals(arg0.getActionCommand())) {
			running = true;
			Thread run = new Thread(new RunGame());
			run.start();
		} else if ("clear".equals(arg0.getActionCommand())) {
			(simulationContainer.getGame()).reset();
			field.repaint();
		}
		
	}
	
	private class RunGame implements Runnable {
		long stime = System.currentTimeMillis();
		long ptime = System.currentTimeMillis();
		public void run() {
			while (running && (simulationContainer.getGame()).iterate()) {
				System.out.println("ITERA:" + (System.currentTimeMillis() - stime));
				ptime = System.currentTimeMillis();
				field.repaint();
				System.out.println("PAINT:" + (System.currentTimeMillis() - ptime));
				try {
					Thread.sleep(1000 - slider.getValue());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stime = System.currentTimeMillis();
			}
		}
	}

}
