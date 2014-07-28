package com.epam.jjp.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jjp.domain.Plane;
import com.epam.jjp.service.PlaneService;

@Controller
public class PlaneShootoutController {
	@Autowired
	private PlaneService service;
	
	@RequestMapping(value = "/planeShootout", method = RequestMethod.GET)
	public String planeShootout(final Locale locale, final Model model) {
		return "planeShootout";
	}
	
	@RequestMapping(value = "/planeShootout/planes", method = RequestMethod.GET)
	public String planes(final Locale locale, final Model model) {
		List<Plane> planes = service.getPlanes();
		model.addAttribute("planeCount", planes.size());
		model.addAttribute("planes", planes);
		return "planes";
	}
}
