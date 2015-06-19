package org.salemelrahal.cassy.model.field;


public interface FieldController {
	public void reset(Field field);
	public void randomize(Field field);
	public void click(Field field, int x, int y);
	public void drag(Field field, int x, int y);
}
