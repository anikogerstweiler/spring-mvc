package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.domain.City;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Route;
import com.epam.jjp.repository.PlaneShootoutRepository;

@Service
public class PlaneShootoutService {
	@Autowired
	private PlaneShootoutRepository repository;
	
	public void addCity(final City City) {
		repository.addCity(City);
	}
	
	public City getCityByName(final String name) {
		return repository.getCityByName(name);
	}
	
	public List<City> getCities() {
		return repository.getCities();
	}
	
	public void addPlane(final Plane plane) {
		repository.addPlane(plane);
	}
	
	public Plane getPlaneByName(final String name) {
		return repository.getPlaneByName(name);
	}
	
	public List<Plane> getPlanes() {
		return repository.getPlanes();
	}
	
	public void addRoute(final Route Route) {
		repository.addRoute(Route);
	}
	
	public Route getRouteByName(final String name) {
		return repository.getRouteByName(name);
	}
	
	public List<Route> getRoutes() {
		return repository.getRoutes();
	}
}
