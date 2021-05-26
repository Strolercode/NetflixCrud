package com.model;

public class Subscriptor {
	
private int id;
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String servicio;
	
	private String fechaNacimiento;
	
	private Plan plan;
	
	private String estatus;
	
	

	public Subscriptor() {
		// TODO Auto-generated constructor stub
	}


	public Subscriptor(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String servicio,
			String fechaNacimiento, Plan plan, String estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.servicio = servicio;
		this.fechaNacimiento = fechaNacimiento;
		this.plan = plan;
		this.estatus = estatus;
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


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getServicio() {
		return servicio;
	}


	public void setServicio(String servicio) {
		this.servicio = servicio;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String string) {
		this.fechaNacimiento = string;
	}

	public Plan getPlan() {
		return plan;
	}


	public void setPlan(Plan plan) {
		this.plan = plan;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	@Override
	public String toString() {
		return "usuario [\nid=" + id + ", \nnombre=" + nombre + ", \napellidoPaterno=" + apellidoPaterno
				+ ", \napellidoMaterno=" + apellidoMaterno + ", \nservicio=" + servicio + ", \nfechaNacimiento="
				+ fechaNacimiento + ", \nEl plan del usuario es=" + plan + ", \nestatus=" + estatus + "]";
	}
	
	

}
