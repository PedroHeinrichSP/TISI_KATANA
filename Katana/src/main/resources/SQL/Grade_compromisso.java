package com.ti2cc;

public class Grade_compromisso {
	private int id_grade;
	private int id_compromisso;

	public int getId() {
		return this.id_grade;
	}

	public void setId(int id_grade) {
		this.id_grade = id_grade;
	}

	public int getid_compromisso() {
		return this.id_compromisso;
	}

	public void setid_compromisso(int id_compromisso) {
		this.id_compromisso = id_compromisso;
	}

	public Grade_compromisso() {
		this.id_grade = -1;
		this.id_compromisso = -1;

	}

	public Grade_compromisso(int id_grade, String id_objetivo, int id_compromisso) {
		this.id_grade = id_grade;
		this.id_compromisso = id_compromisso;

	}

	@Override
	public String toString() {
		return "Grade_compromisso [id=" + id_grade + ", id_imprev=" + id_compromisso +  "]";
	}
}
