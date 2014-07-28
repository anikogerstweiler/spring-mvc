package com.epam.jjp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.epam.jjp.domain.City;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Plane.PlaneType;
import com.epam.jjp.service.PlaneShootoutService;

@Controller
@SessionAttributes("cityForm")
public class PlaneShootoutController {
	@Autowired
	private PlaneShootoutService service;
	
	@RequestMapping(value = "/planes", method = RequestMethod.GET)
	public String planeShootout(final Model model) {
		populateData(model);
		return "planes";
	}
	
	@RequestMapping(value = "/planes/addPlane", method = RequestMethod.POST)
	public String addPlane(@ModelAttribute("planeForm") final PlaneForm planeForm, final Model model) {
		Plane plane = new Plane();
		plane.setName(planeForm.getName());
		plane.setType(planeForm.getType());
		plane.setHp(planeForm.getHp());
		service.addPlane(plane);
		
		populateData(model);
		return "planes";
	}
	
	@RequestMapping(value = "/planes/addCity", method = RequestMethod.POST, params = "step=cityAttributes")
	public String addCityAttributes(final Model model) {
		populateData(model);
		return "cityAttributes";
	}
	
	@RequestMapping(value = "/planes/addCity", method = RequestMethod.POST, params = "step=done")
	public String addCityDone(@ModelAttribute("cityForm") final CityForm cityForm, final SessionStatus sessionStatus, final Model model) {
		City city = new City();
		city.setName(cityForm.getName());
		service.addCity(city);
		
		populateData(model);
		sessionStatus.setComplete();
		return "planes";
	}
	
	private void populateData(final Model model) {
		model.addAttribute("planeTypes", PlaneType.values());
		
		model.addAttribute("cities", service.getCities());
		model.addAttribute("planes", service.getPlanes());
		model.addAttribute("routes", service.getRoutes());
	}
}
