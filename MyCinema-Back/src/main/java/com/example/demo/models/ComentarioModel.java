package com.example.demo.models;

import com.example.demo.entity.Pelicula;
import com.example.demo.entity.Usuario;

public class ComentarioModel {

	private int id;
	
	private Pelicula pelicula;
	
	private Usuario usuario;
	
	private String comentario;
	
	private int valoracion;

	public ComentarioModel() {
		super();
	}

	public ComentarioModel(int id, Pelicula pelicula, Usuario usuario, String comentario,
			int valoracion) {
		super();
		this.id = id;
		this.pelicula = pelicula;
		this.usuario = usuario;
		this.comentario = comentario;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula_id(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Usuario getusuario() {
		return usuario;
	}

	public void setusuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	
	
}
