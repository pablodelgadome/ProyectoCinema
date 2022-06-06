package com.example.demo.models;

public class SalaModel {

	private int id;
	
	private boolean tridimensional;

	public SalaModel(int id, boolean tridimensional) {
		super();
		this.id = id;
		this.tridimensional = tridimensional;
	}

	public SalaModel() {
		super();
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
