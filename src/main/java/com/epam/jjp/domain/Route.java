package com.epam.jjp.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {
	private String name;
	private City start;
	private List<City> enRouteCities = new ArrayList<City>();
	private City goal;
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setStart(final City city) {
		start = city;
	}
	
	public City getStart() {
		return start;
	}
	
	public void setEnRouteCities(final List<City> cities) {
		enRouteCities.clear();
		enRouteCities.addAll(cities);
	}
	
	public List<City> getEnRouteCities() {
		return Collections.unmodifiableList(enRouteCities);
	}
	
	public void setGoal(final City city) {
		goal = city;
	}
	
	public City getGoal() {
		return goal;
	}
}
