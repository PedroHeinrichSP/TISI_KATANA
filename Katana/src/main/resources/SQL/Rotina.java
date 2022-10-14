package com.ti2cc;

public class Rotina {
	private int id;
	private int id_imprevistos;
	private String habitos;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_imprevistos() {
		return this.id_imprevistos;
	}

	public void setId_imprevistos(int id_imprevistos) {
		this.id_imprevistos = id_imprevistos;
	}

	public String getHabitos() {
		return this.habitos;
	}

	public void setHabitos(String habitos) {
		this.habitos = habitos;
	}

	public Rotina() {
		this.id = -1;
		this.id_imprevistos = -1;
		this.habitos = "";
	}

	public Rotina(int id, String habitos, int id_imprevistos) {
		this.id = id;
		this.id_imprevistos = id_imprevistos;
		this.habitos = habitos;
	}

	@Override
	public String toString() {
		return "Rotina [id=" + id + ", id_imprev=" + id_imprevistos + ", habitos=" + habitos + "]";
	}
}
