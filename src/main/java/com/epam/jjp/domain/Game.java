package com.epam.jjp.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Game {
	private Map<Plane, Route> planeRoutes = new HashMap<>();
	
	public void setPlaneRoutes(final Map<Plane, Route> planeRoutes) {
		this.planeRoutes.clear();
		this.planeRoutes.putAll(planeRoutes);
	}
	
	public Map<Plane, Route> getPlaneRoutes() {
		return Collections.unmodifiableMap(planeRoutes);
	}
}
