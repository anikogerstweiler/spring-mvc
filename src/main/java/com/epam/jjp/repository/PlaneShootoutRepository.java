package com.epam.jjp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.City;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;

@Repository
public class PlaneShootoutRepository {
	private final List<City> cities = new ArrayList<>();
	private final List<Plane> planes = new ArrayList<>();
	private final List<Route> routes = new ArrayList<>();
	
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
		return result;
	}
	
	public List<Route> getRoutes() {
		return Collections.unmodifiableList(routes);
	}
}
