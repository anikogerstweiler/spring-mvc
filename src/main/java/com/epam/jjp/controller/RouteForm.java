package com.epam.jjp.controller;

import java.util.ArrayList;
import java.util.List;

import com.epam.jjp.domain.City;

public class RouteForm {
	private String name;
	private String start;
	private List<String> enRouteCities = new ArrayList<String>();
	private String goal;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public List<String> getEnRouteCities() {
		return enRouteCities;
	}
	public void setEnRouteCities(String city) {
		enRouteCities.add(city);
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
}
