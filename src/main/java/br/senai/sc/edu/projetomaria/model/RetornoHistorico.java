package br.senai.sc.edu.projetomaria.model;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class RetornoHistorico {

	private List<Double> listaValor = new ArrayList<Double>();
	private List<DateTime> listaDataSku = new ArrayList<DateTime>();
	
	public RetornoHistorico() {
		super();
	}

	public RetornoHistorico(List<Double> listaValor, List<DateTime> listaDataSku) {
		this.listaValor = listaValor;
		this.listaDataSku = listaDataSku;
	}

	public List<Double> getListaValor() {
		return listaValor;
	}

	public void setListaValor(List<Double> listaValor) {
		this.listaValor = listaValor;
	}

	public List<DateTime> getListaDataSku() {
		return listaDataSku;
	}

	public void setListaDataSku(List<DateTime> listaDataSku) {
		this.listaDataSku = listaDataSku;
	}
	
	
}
