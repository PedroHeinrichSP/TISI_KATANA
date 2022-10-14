package com.ti2cc;

public class Compromisso {
	private int id;
	private char Nome;
	private String Text;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNome() {
		return this.Nome;
	}

	public void setNome(char Nome) {
		this.Nome = Nome;
	}

	public String getText() {
		return this.Text;
	}

	public void setText(String Text) {
		this.Text = Text;
	}

	public Compromisso() {
		this.id = -1;
		this.Nome = '*';
		this.Text = "";
	}

	public Compromisso(int id, String Text, char Nome) {
		this.id = id;
		this.Nome = Nome;
		this.Text = Text;
	}

	@Override
	public String toString() {
		return "Compromisso [id=" + id + ", id_imprev=" + Nome + ", Text=" + Text + "]";
	}
}
