package com.epam.jjp.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Game {
	
	private Map<Plane, Route> planeRoutes = new HashMap<>();
	
	private Random random = new Random();
	
	private StringBuilder builder = new StringBuilder();
	
	public void setPlaneRoutes(final Map<Plane, Route> planeRoutes) {
		this.planeRoutes.clear();
		this.planeRoutes.putAll(planeRoutes);
	}
	
	public void addPlaneRoute(Plane plane, Route route) {
		planeRoutes.put(plane, route);
	}
	
	public Map<Plane, Route> getPlaneRoutes() {
		return Collections.unmodifiableMap(planeRoutes);
	}
	
	public String start() {
		for (Entry<Plane, Route> entry : planeRoutes.entrySet()) {
			Plane plane = entry.getKey();
			Route route = entry.getValue();
			for (City city : route.getEnRouteCities()) {
				int citysLikelihood = city.getLikelihoodByType(plane.getType());
				int randomValue = random.nextInt(100);
				
				int delta = 0;
				if (randomValue > citysLikelihood) {
					delta = city.getFirePowers().get(plane.getType());
				}
				
				plane.changeHp(delta);
				builder.append(plane.getName() + " was shot with " + delta + " in " + city.getName()).append("<br>");
			}
			
			if (plane.getHp() == 0) {
				builder.append(plane.getName() + " was shot down... :-(").append("<br>");
			} else {
				builder.append(plane.getName() + " made it to safety!!! :-). HP left: " + plane.getHp());
			}
		}
		return builder.toString();
	}

}
