package com.epam.jjp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.jjp.domain.Plane.PlaneType;

public class CityForm {
	private String name;
	private Map<PlaneType, Integer> likelihoods = new HashMap<>();
	private Map<PlaneType, Integer> firePowers = new HashMap<>();
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLikelihood(final PlaneType type, int likelihood) {
		likelihoods.put(type, likelihood);
	}
	
	public Map<PlaneType, Integer> getLikelihoods() {
		return Collections.unmodifiableMap(likelihoods);
	}
	
	public void setFirePower(final PlaneType type, int firePower) {
		firePowers.put(type, firePower);
	}
	
	public Map<PlaneType, Integer> getFirePowers() {
		return Collections.unmodifiableMap(firePowers);
	}
}
