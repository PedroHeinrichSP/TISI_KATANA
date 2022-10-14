package com.ti2cc;

public class Aluno {
	private int id;
	private int id_grade;
	private String id_objetivo;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getid_grade() {
		return this.id_grade;
	}

	public void setid_grade(int id_grade) {
		this.id_grade = id_grade;
	}

	public String getid_objetivo() {
		return this.id_objetivo;
	}

	public void setid_objetivo(String id_objetivo) {
		this.id_objetivo = id_objetivo;
	}

	public Aluno() {
		this.id = -1;
		this.id_grade = -1;
		this.id_objetivo = "";
	}

	public Aluno(int id, String id_objetivo, int id_grade) {
		this.id = id;
		this.id_grade = id_grade;
		this.id_objetivo = id_objetivo;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", id_imprev=" + id_grade + ", id_objetivo=" + id_objetivo + "]";
	}
}
