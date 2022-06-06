package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pelicula;
import com.example.demo.entity.Usuario;
import com.example.demo.models.PeliculaModel;
import com.example.demo.models.UsuarioModel;


public interface PeliculaService {

	List<PeliculaModel> listAllPeliculas();
	Pelicula addPelicula(PeliculaModel PeliculaModel);
	int removePelicula(int id);
	Pelicula updatePelicula(PeliculaModel PeliculaModel);
	PeliculaModel transform(Pelicula pelicula);
	Pelicula transform(PeliculaModel PeliculaModel);
	List<PeliculaModel> findByCategoria(String categoria);
	List<PeliculaModel> findByTitulo(String titulo);
	PeliculaModel findPelicula(int id);
	
}
