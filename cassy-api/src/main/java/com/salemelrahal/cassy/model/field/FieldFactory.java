package com.salemelrahal.cassy.model.field;


public interface FieldFactory<F extends Field<?>>{
	public F next();
}
