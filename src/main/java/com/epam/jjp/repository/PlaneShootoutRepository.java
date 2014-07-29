package com.epam.jjp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.City;
import com.epam.jjp.domain.Game;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;
import com.epam.jjp.domain.Plane.PlaneType;

@Repository
public class PlaneShootoutRepository {
	private final List<City> cities = new ArrayList<>();
	private final List<Plane> planes = new ArrayList<>();
	private final List<Route> routes = new ArrayList<>();
	private Game game;
	
	public void addCity(final City city) {
		cities.add(city);
	}
	
	public City getCityByName(final String name) {
		City result = null;
		for (City c : cities) {
			if (name.equals(c.getName())) {
				result = c;
			}
		}
		return result;
	}
	
	public List<City> getCities() {
		return Collections.unmodifiableList(cities);
	}
	
	public void addPlane(final Plane plane) {
		planes.add(plane);
	}
	
	public Plane getPlaneByName(final String name) {
		Plane result = null;
		for (Plane p : planes) {
			if (name.equals(p.getName())) {
				result = p;
			}
		}
		if (result == null) {
			throw new IllegalStateException("plane is null");
		}
		return result;
	}
	
	public List<Plane> getPlanes() {
		return Collections.unmodifiableList(planes);
	}
	
	public void addRoute(final Route Route) {
		routes.add(Route);
	}
	
	public Route getRouteByName(final String name) {
		Route result = null;
		for (Route p : routes) {
			if (name.equals(p.getName())) {
				result = p;
			}
		}
		if (result == null) {
			throw new IllegalStateException("route is null");
		}
		return result;
	}
	
	public List<Route> getRoutes() {
		return Collections.unmodifiableList(routes);
	}
	
	public void addGame(final Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return game;
	}
	
	{
		Plane plane1 = new Plane();
		plane1.setName("B737");
		plane1.setType(PlaneType.CHARITY);
		plane1.setHp(100);
		
		Plane plane2 = new Plane();
		plane2.setName("C130");
		plane2.setType(PlaneType.CIVIL);
		plane2.setHp(200);
		
		Plane plane3 = new Plane();
		plane3.setName("C140");
		plane3.setType(PlaneType.MILITARY);
		plane3.setHp(150);
		
		planes.add(plane1);
		planes.add(plane2);
		planes.add(plane3);
	}
	
	{
		 City city1 = new City();
		  
		  Map<PlaneType, Integer> likeliHood = new HashMap<>();
		  likeliHood.put(PlaneType.CHARITY, 56);
		  likeliHood.put(PlaneType.CIVIL, 40);
		  likeliHood.put(PlaneType.MILITARY, 70);
		  
		  Map<PlaneType, Integer> firepower = new HashMap<>();
		  firepower.put(PlaneType.CHARITY, 20);
		  firepower.put(PlaneType.CIVIL, 20);
		  firepower.put(PlaneType.MILITARY, 20);
		  
		  city1.setName("Budapest");
		  city1.setLikelihoods(likeliHood);
		  city1.setFirePowers(firepower);
		  
		  City city2 = new City();
		  
		  likeliHood.clear();
		  likeliHood.put(PlaneType.CHARITY, 40);
		  likeliHood.put(PlaneType.CIVIL, 56);
		  likeliHood.put(PlaneType.MILITARY, 45);
		  
		  firepower.clear();
		  firepower.put(PlaneType.CHARITY, 30);
		  firepower.put(PlaneType.CIVIL, 30);
		  firepower.put(PlaneType.MILITARY, 30);
		  
		  city2.setName("Debrecen");
		  city2.setLikelihoods(likeliHood);
		  city2.setFirePowers(firepower);
		  
		  City city3 = new City();
		  
		  likeliHood.clear();
		  likeliHood.put(PlaneType.CHARITY, 20);
		  likeliHood.put(PlaneType.CIVIL, 30);
		  likeliHood.put(PlaneType.MILITARY, 40);
		  
		  firepower.clear();
		  firepower.put(PlaneType.CHARITY, 40);
		  firepower.put(PlaneType.CIVIL, 40);
		  firepower.put(PlaneType.MILITARY, 40);
		  
		  city3.setName("Pécs");
		  city3.setLikelihoods(likeliHood);
		  city3.setFirePowers(firepower);
		  
		  City city4 = new City();
		  
		  likeliHood.clear();
		  likeliHood.put(PlaneType.CHARITY, 20);
		  likeliHood.put(PlaneType.CIVIL, 30);
		  likeliHood.put(PlaneType.MILITARY, 40);
		  
		  firepower.clear();
		  firepower.put(PlaneType.CHARITY, 40);
		  firepower.put(PlaneType.CIVIL, 40);
		  firepower.put(PlaneType.MILITARY, 40);
		  
		  city4.setName("Paks");
		  city4.setLikelihoods(likeliHood);
		  city4.setFirePowers(firepower);
		  
		  cities.add(city1);
		  cities.add(city2);
		  cities.add(city3);
		  cities.add(city4);
	}

}
