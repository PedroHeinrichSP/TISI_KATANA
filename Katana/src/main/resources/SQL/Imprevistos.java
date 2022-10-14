package com.ti2cc;

public class Imprevistos {
	private int id;
	private String Motivos;
	private String Historico;
	private String Consequencias;
	
	public Imprevistos() {
		this.id = -1;
		this.Motivos = "";
		this.Historico = "";
		this.Consequencias = "";
	}
	
	public Imprevistos(int id, String Motivos, String Historico, String Consequencias) {
		this.id = id;
		this.Motivos = Motivos;
		this.Historico = Historico;
		this.Consequencias = Consequencias;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getMotivos() {
		return Motivos;
	}

	public void setMotivos(String Motivos) {
		this.Motivos = Motivos;
	}

	public String getHistorico() {
		return Historico;
	}

	public void setHistorico(String Historico) {
		this.Historico = Historico;
	}

	public String getConsequencias() {
		return Consequencias;
	}

	public void setConsequencias(String Consequencias) {
		this.Consequencias = Consequencias;
	}

	@Override
	public String toString() {
		return "Imprevistos [id=" + id + ", Motivos=" + Motivos + ", Historico=" + Historico + ", Consequencias=" + Consequencias + "]";
	}	
}
