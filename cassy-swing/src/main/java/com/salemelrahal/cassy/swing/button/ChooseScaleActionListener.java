package com.salemelrahal.cassy.swing.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.salemelrahal.cassy.swing.canvas.DisplayField;
import com.salemelrahal.cassy.swing.registry.ScaleListRegistry;

public class ChooseScaleActionListener implements ActionListener{
	private DisplayField displayGrid;
	
	public ChooseScaleActionListener(DisplayField displayGrid) {
		this.displayGrid =displayGrid;
	}

	public void actionPerformed(ActionEvent arg0) {
		JComboBox<String> cb = (JComboBox<String>)arg0.getSource();
        String scaleName = (String)cb.getSelectedItem();
        this.displayGrid.setScale(ScaleListRegistry.get(scaleName));
	}

}
