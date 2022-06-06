package com.example.demo.models;

import java.sql.Date;

import com.example.demo.entity.Complemento;
import com.example.demo.entity.Pelicula;
import com.example.demo.entity.Sala;
import com.example.demo.entity.Usuario;

public class EntradaModel {

	private int id;
	
	private int precio;
	
	private Date fecha;
	
	private int fila;
	
	private int butaca;
	
	private Complemento complemento;
	
	private Sala sala;
	
	private Usuario usuario;
	
	private Pelicula pelicula;

	public EntradaModel(int id, int precio, Date fecha, int fila, int butaca, Complemento complemento,
			Sala sala, Usuario usuario, Pelicula pelicula) {
		super();
		this.id = id;
		this.precio = precio;
		this.fecha = fecha;
		this.fila = fila;
		this.butaca = butaca;
		this.complemento = complemento;
		this.sala = sala;
		this.usuario = usuario;
		this.pelicula = pelicula;
	}

	public EntradaModel() {
		super();
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
