package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Complemento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String nombre;
	
	private int cantidad;
	
	private String tamanio;
	
	@OneToMany(mappedBy="complemento", orphanRemoval=true)
	private List<Entrada> entradas = new ArrayList<>();

	public Complemento() {
		super();
	}

	public Complemento(int id, String nombre, int cantidad, String tamanio, List<Entrada> entradas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.tamanio = tamanio;
		this.entradas = entradas;
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

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	
	
	
}
