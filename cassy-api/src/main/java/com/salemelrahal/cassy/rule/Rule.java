package com.salemelrahal.cassy.rule;

import com.salemelrahal.cassy.model.Cell;
import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;

public interface Rule {
	public State calculateNextState(Cell cell, Field field);
}
