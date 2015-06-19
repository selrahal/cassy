package org.salemelrahal.cassy.swing.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SizeListRegistry {
	private static Map<String, Integer> scaleMap;

	static {
		scaleMap = new ConcurrentHashMap<String, Integer>();
		scaleMap.put("Small", 100);
		scaleMap.put("Medium", 200);
		scaleMap.put("Large", 300);
	}

	public static List<String> getSizes() {
		return new ArrayList<String>(scaleMap.keySet());
	}

	public static int get(String name) {
		return scaleMap.get(name);
	}
}
