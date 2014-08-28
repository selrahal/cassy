package com.salemelrahal.cassy.init;

import com.salemelrahal.cassy.model.Field;

public interface Initializer<T extends Field> {
	public void initialize(T field);
	public void randomize(T field);
	public void click(T field, int x, int y);
	public void drag(T field, int x, int y);
}
