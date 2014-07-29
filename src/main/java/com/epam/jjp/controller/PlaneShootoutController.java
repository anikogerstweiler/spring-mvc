package com.epam.jjp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.epam.jjp.domain.City;
import com.epam.jjp.domain.Game;
import com.epam.jjp.domain.Plane;
import com.epam.jjp.domain.Plane.PlaneType;
import com.epam.jjp.domain.Route;
import com.epam.jjp.service.PlaneShootoutService;

@Controller
@SessionAttributes({"cityForm", "routeForm"})
public class PlaneShootoutController {
	private static final Logger LOG = LoggerFactory.getLogger(PlaneShootoutController.class);
	
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
	public String addCityAttributes(final CityForm cityForm, final PlaneType type, final Integer likelihood, final Integer firePower, final Model model) {
		LOG.info("[" + type + "," + likelihood + "," + firePower + "]");
		if (type != null) {
			cityForm.setLikelihood(type, likelihood);
			cityForm.setFirePower(type, firePower);
		}
		
		populateData(model);
		return "cityAttributes";
	}
	
	@RequestMapping(value = "/planes/addCity", method = RequestMethod.POST, params = "step=done")
	public String addCityDone(final CityForm cityForm, final SessionStatus sessionStatus, final Model model) {
		City city = new City();
		city.setName(cityForm.getName());
		city.setLikelihoods(cityForm.getLikelihoods());
		city.setFirePowers(cityForm.getFirePowers());
		service.addCity(city);
		
		sessionStatus.setComplete();
		
		populateData(model);
		return "planes";
	}
	
	@RequestMapping(value = "/planes/addRoute", method = RequestMethod.POST, params = "step=routeAttributes")
	public String addRoute(final RouteForm routeForm, final Model model) {
		populateData(model);
		return "routeAttributes";
	}
	
	@RequestMapping(value = "/planes/addRoute", method = RequestMethod.POST, params = "step=done")
	public String addRouteDone(final RouteForm routeForm, final SessionStatus sessionStatus, final Model model) {
		Route route = new Route();
		route.setName(routeForm.getName());
		route.setStart(service.getCityByName(routeForm.getStart()));
		route.setGoal(service.getCityByName(routeForm.getGoal()));
		List<String> cities = routeForm.getEnRouteCities();
		List<City> tmp = new ArrayList<>();
		for (String c : cities) {
			City city = service.getCityByName(c);
			tmp.add(city);
		}
		route.setEnRouteCities(tmp);
		service.addRoute(route);
		
		sessionStatus.setComplete();
		
		populateData(model);
		return "planes";
	}
	
	@RequestMapping(value = "planes/addGame", method = RequestMethod.POST)
	public String addGame(final GameForm gameForm,  String route,  String plane, final Model model) {
		if (plane != null && route != null) {
			Game game = new Game();

			game.addPlaneRoute(service.getPlaneByName(plane), service.getRouteByName(route));
			service.addGame(game);
		}
		
		populateData(model);
		return "planes";

	}
	
	 @RequestMapping(value = "/planes/playGame", method = RequestMethod.GET, produces="text/html; charset=utf-8")
	 public @ResponseBody String playGame(final Model model) {
		Game game = service.getGame();
		String result = game.start();
		LOG.info("result: " + result);
		
		return result;
	 }
	
	
	private void populateData(final Model model) {
		model.addAttribute("planeTypes", PlaneType.values());
		
		model.addAttribute("cities", service.getCities());
		model.addAttribute("planes", service.getPlanes());
		model.addAttribute("routes", service.getRoutes());
	}
}