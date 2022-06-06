package com.example.demo.models;

public class UsuarioModel {

	private int id;
	
	private String dni;
	
	private String role;
	
	private String nombre;

	private String email;
	
	private String password;
	
	private String token;

	public UsuarioModel() {
		super();
	}

	public UsuarioModel(int id, String dni, String role, String nombre, String email, String password, String token) {
		super();
		this.id = id;
		this.dni = dni;
		this.role = role;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
