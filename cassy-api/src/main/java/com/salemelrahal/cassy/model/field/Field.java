package com.salemelrahal.cassy.model.field;

import java.util.Collection;

public interface Field<N extends Node> {
	public Collection<N> getNodes();
	public Field<N> clone();
}
