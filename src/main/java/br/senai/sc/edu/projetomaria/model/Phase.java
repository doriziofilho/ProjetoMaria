package br.senai.sc.edu.projetomaria.model;

public class Phase {
	private int skuOld;
	private int skuNew;
	private Produto produto;
	
	public int getSkuOld() {
		return skuOld;
	}
	public void setSkuOld(int skuOld) {
		this.skuOld = skuOld;
	}
	public int getSkuNew() {
		return skuNew;
	}
	public void setSkuNew(int skuNew) {
		this.skuNew = skuNew;
	}
	
	@Override
	public String toString() {
		return "Phase [sku_phase_in=" + skuNew + ", sku_phase_out=" + skuOld + "]";
	}

	public boolean isValid() {
		boolean ok = true;
		if (this.produto.getSku() == 0 ) {
			ok = false;
		}
		return ok;
	}
}
