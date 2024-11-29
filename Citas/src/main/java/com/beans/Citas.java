package com.beans;

public class Citas {
	private int idCita;
	private String fechaCita;
	private double costoCita;
	private Odontologo odon;
	private String paciente;
	private String horaCita;
	
	public Citas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public String getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	public double getCostoCita() {
		return costoCita;
	}

	public void setCostoCita(double costoCita) {
		this.costoCita = costoCita;
	}

	public Odontologo getOdon() {
		return odon;
	}

	public void setOdon(Odontologo odon) {
		this.odon = odon;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}
	
	
	
}
