package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.domain.Plane;
import com.epam.jjp.repository.PlaneRepository;

@Service
public class PlaneService {
	@Autowired
	private PlaneRepository repository;
	
	public List<Plane> getPlanes() {
		return repository.getPlanes();
	}
}
