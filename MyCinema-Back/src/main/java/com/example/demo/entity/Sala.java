package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sala {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private boolean tridimensional;
	
	@OneToMany(mappedBy="sala", orphanRemoval=true)
	private List<Entrada> entradas = new ArrayList<>();

	public Sala(int id, boolean tridimensional) 
	{
		super();
		this.id = id;
		this.tridimensional = tridimensional;
	}
	
	public Sala()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isTridimensional() {
		return tridimensional;
	}

	public void setTridimensional(boolean tridimensional) {
		this.tridimensional = tridimensional;
	}
	
	
	
}
