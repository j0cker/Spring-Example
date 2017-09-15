package com.SpringExample.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandling {
	// @RequestHandler methods

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleError(Exception ex) {
		System.out.println("entro");
		ModelAndView model = new ModelAndView();
		model.addObject("exception", ex);
		model.setViewName("error");
		return model;
	}

}
