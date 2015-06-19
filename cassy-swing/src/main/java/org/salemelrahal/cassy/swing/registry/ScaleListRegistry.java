package org.salemelrahal.cassy.swing.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScaleListRegistry {
	private static Map<String, Integer> scaleMap;

	static {
		scaleMap = new ConcurrentHashMap<String, Integer>();
		scaleMap.put("Small", 3);
		scaleMap.put("Medium", 6);
		scaleMap.put("Large", 10);
	}

	public static List<String> getScales() {
		return new ArrayList<String>(scaleMap.keySet());
	}

	public static int get(String name) {
		return scaleMap.get(name);
	}
}
