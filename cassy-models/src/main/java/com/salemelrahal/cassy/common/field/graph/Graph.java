package com.salemelrahal.cassy.common.field.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.salemelrahal.cassy.model.field.Field;

public class Graph implements Field<GraphCellContainer>{
	private Map<GraphCellContainer, List<GraphCellContainer>> adjacenyMap;
	
	public Graph() {
		adjacenyMap = new HashMap<GraphCellContainer, List<GraphCellContainer>>();
	}

	public Field clone() {
		Graph toReturn = new Graph();
		for (Entry<GraphCellContainer, List<GraphCellContainer>> entry : adjacenyMap.entrySet()) {
			List<GraphCellContainer> newList = new ArrayList<GraphCellContainer>();
			for (GraphCellContainer container : entry.getValue()) {
				newList.add(container.clone());
			}
			toReturn.adjacenyMap.put(entry.getKey().clone(), newList);
		}
		return toReturn;
	}
	
	//TODO: Worry about heavy reliance on Cell's .equals method
//	public void addLink(Cell origin, Cell destination) {
//		if (!adjacenyMap.containsKey(origin)) {
//			adjacenyMap.put(origin, new ArrayList<Cell>());
//		}
//		if (!adjacenyMap.get(origin).contains(destination)) {
//			adjacenyMap.get(origin).add(destination);
//		}
//	}

	public Collection<GraphCellContainer> getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<GraphCellContainer> getNeighbors(GraphCellContainer node) {
		// TODO Auto-generated method stub
		return null;
	}

}
