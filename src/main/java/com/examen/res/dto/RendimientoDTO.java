package com.examen.res.dto;

public class RendimientoDTO {
	
	private Integer year;
	private Double saldoInicial;
	private Double aportacionInic;
	private Double Rendimiento;
	private Double saldoFinal;
	private Double gananciaInv;
	
	
	public Double getGananciaInv() {
		return gananciaInv;
	}
	public void setGananciaInv(Double gananciaInv) {
		this.gananciaInv = gananciaInv;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public Double getAportacionInic() {
		return aportacionInic;
	}
	public void setAportacionInic(Double aportacionInic) {
		this.aportacionInic = aportacionInic;
	}
	public Double getRendimiento() {
		return Rendimiento;
	}
	public void setRendimiento(Double rendimiento) {
		Rendimiento = rendimiento;
	}
	public Double getSaldoFinal() {
		return saldoFinal;
	}
	public void setSaldoFinal(Double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
	
	
	
}
