package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Pelicula;
import com.example.demo.models.PeliculaModel;
import com.example.demo.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	@Qualifier("peliculaService")
	private PeliculaService peliculaService;
	
	private static  String FORM="Form_peliculas";
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/listPeliculas")
	public ModelAndView listOfertasUser()
	{
		ModelAndView mav = new ModelAndView("peliculas");
		mav.addObject("peliculas", peliculaService.listAllPeliculas());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addPelicula")
	public String addPelicula(@ModelAttribute("pelicula")PeliculaModel PeliculaModel,Model model)
	{
		if(PeliculaModel.getId()==0)
			peliculaService.addPelicula(PeliculaModel);
		else
			peliculaService.updatePelicula(PeliculaModel);
		
		return "redirect:/peliculas/listPeliculas";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value={"/formPelicula/", "/formPelicula/{id}"})
	public String formPelicula(@PathVariable(name="id", required=false)Integer id,Model model)
	{
		if(id==null)
			model.addAttribute("pelicula",new Pelicula());
		else
			model.addAttribute("pelicula",peliculaService.findPelicula(id));
		return FORM;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deletePelicula(@PathVariable("id")int id)
	{
		peliculaService.removePelicula(id);
		return "redirect:/peliculas/listPeliculas";
	}
	
}
