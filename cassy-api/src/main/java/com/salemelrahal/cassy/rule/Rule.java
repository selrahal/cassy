package com.salemelrahal.cassy.rule;

import com.salemelrahal.cassy.model.Field;
import com.salemelrahal.cassy.model.State;

public interface Rule<S extends State, F extends Field> {
	public F calculateNextField(F field);
}
