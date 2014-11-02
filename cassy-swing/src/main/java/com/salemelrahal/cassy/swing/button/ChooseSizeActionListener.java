package com.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.salemelrahal.cassy.swing.canvas.DisplayField;
import com.salemelrahal.cassy.swing.registry.SizeListRegistry;
import com.salemelrahal.gol.simulation.impl.SimulationRegistry;

public class ChooseSizeActionListener implements ActionListener{
	private DisplayField displayGrid;
	
	public ChooseSizeActionListener(DisplayField displayGrid) {
		this.displayGrid =displayGrid;
	}

	public void actionPerformed(ActionEvent arg0) {
		JComboBox<String> cb = (JComboBox<String>)arg0.getSource();
        String sizeName = (String)cb.getSelectedItem();
        this.displayGrid.setSize(SizeListRegistry.get(sizeName));
	}

}
