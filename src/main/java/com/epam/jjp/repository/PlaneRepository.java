package com.epam.jjp.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Plane.PlaneType;

@Repository
public class PlaneRepository {
	private final List<Plane> planes = new ArrayList<>();
	
	{
		Plane plane1 = new Plane();
		plane1.setName("B737");
		plane1.setType(PlaneType.CIVIL);
		plane1.setHp(100);
		
		Plane plane2 = new Plane();
		plane2.setName("C130");
		plane2.setType(PlaneType.CHARITY);
		plane2.setHp(200);
		
		planes.add(plane1);
		planes.add(plane2);
	}
	
	public List<Plane> getPlanes() {
		return Collections.unmodifiableList(planes);
	}
}
