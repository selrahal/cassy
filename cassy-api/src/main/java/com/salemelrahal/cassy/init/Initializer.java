package com.salemelrahal.cassy.init;

import com.salemelrahal.cassy.model.Field;

public interface Initializer<F extends Field> {
	public void initialize(F field);
	public void randomize(F field);
	public void click(F field, int x, int y);
	public void drag(F field, int x, int y);
}
