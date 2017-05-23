package com.springexperiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth/")
public class AnthenticationController {

	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public String loginHandler() {
		return "../login/";
	}
}
