package com.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JSlider;

import com.salemelrahal.gol.game.impl.Game;

public class StartGameActionListener implements ActionListener{
	private Game game;
	private JComponent field;
	private boolean running = false;
	private JSlider slider;
	
	public StartGameActionListener(Game game, JComponent field, JSlider slider) {
		this.game = game;
		this.field = field;
		this.slider = slider;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		if ("step".equals(arg0.getActionCommand())) {
			game.iterate();
			field.repaint();
		} else if ("stop".equals(arg0.getActionCommand())) {
			running = false;
		} else if ("start".equals(arg0.getActionCommand())) {
			running = true;
			Thread run = new Thread(new RunGame());
			run.start();
		} else if ("clear".equals(arg0.getActionCommand())) {
			game.reset();
			field.repaint();
		}
		
	}
	
	private class RunGame implements Runnable {
		public void run() {
			System.out.println("Thread " + running);
			while (running && game.iterate()) {
				field.repaint();
				System.out.println("ITERATE");
				try {
					Thread.sleep(1000 - slider.getValue());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
