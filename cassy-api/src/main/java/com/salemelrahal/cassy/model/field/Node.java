package com.salemelrahal.cassy.model.field;

import com.salemelrahal.cassy.model.State;

public interface Node {
	public void setState(State antState);
	public State getState();
}
