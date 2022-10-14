package com.ti2cc;

public class Objetivos {
	private int id;
	private String Projetos;
	private String Disciplinas;

	public Objetivos() {
		this.id = -1;
		this.Projetos = "";
		this.Disciplinas = "";
	}

	public Objetivos(int id, String Projetos, String Disciplinas) {
		this.id = id;
		this.Projetos = Projetos;
		this.Disciplinas = Disciplinas;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getProjetos() {
		return Projetos;
	}

	public void setProjetos(String Projetos) {
		this.Projetos = Projetos;
	}

	public String getDisciplinas() {
		return Disciplinas;
	}

	public void setDisciplinas(String Disciplinas) {
		this.Disciplinas = Disciplinas;
	}

	@Override
	public String toString() {
		return "Objetivos [id=" + id + ", Projetos=" + Projetos + ", Disciplinas=" + Disciplinas + "]";
	}
}
