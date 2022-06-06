package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Comentario;
import com.example.demo.entity.Pelicula;
import com.example.demo.models.ComentarioModel;

public interface ComentarioService {

	List<ComentarioModel> listAllComentarios();
	Comentario addComentario(Comentario comentario);
	int removeComentario(int id);
	Comentario updateComentario(ComentarioModel ComentarioModel);
	ComentarioModel transform(Comentario Comentario);
	Comentario transform(ComentarioModel Comentariomodel);
	List<ComentarioModel> findByPelicula(Pelicula Pelicula);
	
}
