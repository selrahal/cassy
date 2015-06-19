package org.salemelrahal.cassy.model.field;

import java.util.Collection;

/**
 * A collection of Nodes
 * 
 */
public interface Field{
	public Collection<Node> getNodes();
	public Field clone();
}
