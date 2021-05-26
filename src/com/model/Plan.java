package com.model;

public class Plan {

	
	private int idPlan;

	private String nombre;

	private float importef;
	

	public Plan() {

	}

	public Plan(int idPlan, String nombre, float importef) {
		super();
		this.idPlan = idPlan;
		this.nombre = nombre;
		this.importef = importef;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getImportef() {
		return importef;
	}

	public void setImportef(float importef) {
		this.importef = importef;
	}

	@Override
	public String toString() {
		return "plan [idPlan=" + idPlan + ", nombre=" + nombre + ", importef=" + importef + "]";
	}
	
}
