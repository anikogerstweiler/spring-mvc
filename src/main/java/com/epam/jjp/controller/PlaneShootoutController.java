package com.epam.jjp.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlaneShootoutController {
	@RequestMapping(value = "/planeShootout", method = RequestMethod.GET)
	public String planeShootout(final Locale locale, final Model model) {
		return "planeShootout";
	}
}
