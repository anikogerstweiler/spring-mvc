package com.epam.jjp.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.epam.jjp.domain.Plane.PlaneType;

public class City {
	private String name;
	private Map<PlaneType, Integer> likelihoods = new HashMap<>();
	private Map<PlaneType, Integer> firePowers = new HashMap<>();
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLikelihoods(final Map<PlaneType, Integer> likelihoods) {
		this.likelihoods.clear();
		this.likelihoods.putAll(likelihoods);
	}
	
	public Map<PlaneType, Integer> getLikelihoods() {
		return Collections.unmodifiableMap(likelihoods);
	}
	
	public void setFirePowers(final Map<PlaneType, Integer> firePowers) {
		this.firePowers.clear();
		this.firePowers.putAll(firePowers);
	}
	
	public Map<PlaneType, Integer> getFirePowers() {
		return Collections.unmodifiableMap(firePowers);
	}
}
