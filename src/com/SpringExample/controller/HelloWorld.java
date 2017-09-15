package com.SpringExample.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.SpringExample.vo.NuevoUsuario;

@Controller
@EnableWebMvc
public class HelloWorld {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView info(@RequestParam(value = "key") String key,
			Model model) {
		// info?key=webos

		System.out.println("" + key);
		return new ModelAndView("welcome", "message", "success" + key);
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public ModelAndView profileId(@PathVariable("id") int ownerId) {

		String message = "" + ownerId;

		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping(value = "/exceptionExample", method = RequestMethod.GET)
	public ModelAndView exceptionExample() throws Exception {
		throw new Exception();
	}

	@RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
	public ModelAndView getPages(@PathVariable("type") String type) {

		return new ModelAndView("welcome", "message", "probando");

	}

	@RequestMapping(value = "/nuevoUsuario", produces = "application/json; charset=utf-8")
	public @ResponseBody
	NuevoUsuario nuevoUsuario(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String nombre = "";

		if ("POST".equals(request.getMethod())) {
			// POST
		} else {
			// GET
			if (request.getParameterMap().containsKey("nombre") != false) {
				nombre = request.getParameter("nombre").toString();
			}
		}

		NuevoUsuario nuevoUsuario = new NuevoUsuario();
		nuevoUsuario.setNombre(nombre);

		System.out.println("" + nuevoUsuario.getNombre());

		return nuevoUsuario;

	}
}
