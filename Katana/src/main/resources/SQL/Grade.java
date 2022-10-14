package com.ti2cc;

public class Grade {
	private int id;
	private int id_rotina;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getid_rotina() {
		return this.id_rotina;
	}

	public void setid_rotina(int id_rotina) {
		this.id_rotina = id_rotina;
	}

	public Grade() {
		this.id = -1;
		this.id_rotina = -1;

	}

	public Grade(int id, String id_objetivo, int id_rotina) {
		this.id = id;
		this.id_rotina = id_rotina;

	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", id_imprev=" + id_rotina +  "]";
	}
}
