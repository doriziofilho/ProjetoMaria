package br.senai.sc.edu.projetomaria.model;

public class Produto implements ValidableModel {

	private Integer sku;
	private String descricao;
	private String codFamilia;

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodFamilia() {
		return codFamilia;
	}

	public void setCodFamilia(String codFamilia) {
		this.codFamilia = codFamilia;
	}

	@Override
	public String toString() {
		return "Produto [sku=" + sku + ", descricao=" + descricao + "]";
	}

	@Override
	public boolean isValid() {
		boolean ok = true;
		if (this.descricao != null && this.descricao.isEmpty()) {
			ok = false;
		}
		return ok;
	}

}
