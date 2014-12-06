package com.salemelrahal.cassy.model.field;

import com.salemelrahal.cassy.model.State;

public interface Node<S extends State> {
	public void setState(S antState);
	public S getState();
}
