package com.salemelrahal.cassy.rule;

import com.salemelrahal.cassy.model.State;
import com.salemelrahal.cassy.model.field.Field;

public interface Rule<S extends State, F extends Field<?>> {
	public F calculateNextField(F field);
}
