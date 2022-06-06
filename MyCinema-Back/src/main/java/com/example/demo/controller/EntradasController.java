package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.EntradaService;

@Controller
@RequestMapping("/entradas")
public class EntradasController {
	
	@Autowired
	@Qualifier("EntradaService")
	private EntradaService entradaService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/historial")
	public ModelAndView listOfertasUser()
	{
		ModelAndView mav = new ModelAndView("entradas");
		mav.addObject("entradas", entradaService.listAllEntradas());
		return mav;
	}

}
