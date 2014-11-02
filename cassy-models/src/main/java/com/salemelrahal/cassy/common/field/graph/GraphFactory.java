package com.salemelrahal.cassy.common.field.graph;

import com.salemelrahal.cassy.model.field.FieldFactory;

public class GraphFactory implements FieldFactory<Graph>{

	public Graph next() {
		return new Graph();
	}
	
}
