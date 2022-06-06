package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pelicula {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String titulo;
	
	private String valoracion;
	
	private String productor;

	private String duracion;
	
	private String sinapsis;
	
	private String categoria;
	
	private String imagen;
	
	@OneToMany(mappedBy="pelicula")
	private List<Comentario> comentarios;

	public Pelicula(int id, String titulo, String valoracion, String productor, String duracion, String sinapsis, String categoria, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.valoracion = valoracion;
		this.productor = productor;
		this.duracion = duracion;
		this.sinapsis = sinapsis;
		this.categoria = categoria;
		this.imagen = imagen;
	}
	
	public Pelicula()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getSinapsis() {
		return sinapsis;
	}

	public void setSinapsis(String sinapsis) {
		this.sinapsis = sinapsis;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
}
