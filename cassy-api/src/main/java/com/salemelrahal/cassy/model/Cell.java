package com.salemelrahal.cassy.model;

public interface Cell<S extends State> {
	public S getState();
	public void setState(S state);
	public Cell<S> clone();
}
