package com.epam.jjp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;

public class GameForm {
	
	private Map<Plane, Route> planeRoutes;
	
	public void setPlaneRoutes(Plane plane, Route route) {
		planeRoutes.put(plane, route);
	}
	
	public Map<Plane, Route> getPlaneRoutes() {
		return Collections.unmodifiableMap(planeRoutes);
	}
	
}
