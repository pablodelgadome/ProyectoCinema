package com.example.demo.models;

public class ComplementoModel {

	private int id;
	
	private String nombre;
	
	private int cantidad;
	
	private String tamanio;

	public ComplementoModel() {
		super();
	}

	public ComplementoModel(int id, String nombre, int cantidad, String tamanio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tamanio = tamanio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}
	
	
}
