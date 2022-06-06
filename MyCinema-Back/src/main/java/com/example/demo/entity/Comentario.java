package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String comentario;
	
	private int valoracion;
	
	@ManyToOne
	@JoinColumn(name="peliculaId")
	private Pelicula pelicula;
	
	@ManyToOne
	@JoinColumn(name="usuarioId")
	private Usuario usuario;

	public Comentario(int id, String comentario, int valoracion) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.valoracion = valoracion;
	}

	public Comentario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
