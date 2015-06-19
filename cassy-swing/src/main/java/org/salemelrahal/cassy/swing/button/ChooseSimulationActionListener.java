package org.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import org.salemelrahal.cassy.swing.canvas.DisplayField;
import org.salemelrahal.gol.simulation.impl.SimulationRegistry;

public class ChooseSimulationActionListener implements ActionListener{
	private DisplayField displayGrid;
	
	public ChooseSimulationActionListener(DisplayField displayGrid) {
		this.displayGrid =displayGrid;
	}

	public void actionPerformed(ActionEvent arg0) {
		JComboBox<String> cb = (JComboBox<String>)arg0.getSource();
        String simulationName = (String)cb.getSelectedItem();
        this.displayGrid.setSimulation(SimulationRegistry.get(simulationName));
	}

}
