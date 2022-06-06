package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Entrada {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int precio;
	
	private Date fecha;
	
	private int fila;
	
	private int butaca;
	
	@ManyToOne
	@JoinColumn(name="complementoId")
	private Complemento complemento;
	
	@ManyToOne
	@JoinColumn(name="salaId")
	private Sala sala;
	
	@ManyToOne
	@JoinColumn(name="usuarioId")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="peliculaId")
	private Pelicula pelicula;

	public Entrada(int id, int precio, Date fecha, int fila, int butaca, Complemento complemento, Sala sala,
			Usuario usuario,Pelicula pelicula) {
		super();
		this.id = id;
		this.precio = precio;
		this.fecha = fecha;
		this.complemento = complemento;
		this.sala = sala;
		this.usuario = usuario;
		this.pelicula = pelicula;
		this.fila = fila;
		this.butaca = butaca;
	}
	
	public Entrada()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getButaca() {
		return butaca;
	}

	public void setButaca(int butaca) {
		this.butaca = butaca;
	}

	public Complemento getComplemento() {
		return complemento;
	}

	@JsonIgnore
	public void setComplemento(Complemento complemento) {
		this.complemento = complemento;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}	
	
}
