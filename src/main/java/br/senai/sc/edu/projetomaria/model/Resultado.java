package br.senai.sc.edu.projetomaria.model;

import java.text.DecimalFormat;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Resultado {
	private Integer sku;
	private Integer periodoTotal;
	private Integer[] periodoUtilizado;
	private Double resultadoMedia;
	private Double resultadoMedia2;
	private Double resultadoMedia3;
	private Double resultadoMedia4;
	private Double erroQuadraticoMedio;
	
	private List<Double> listaMediaMovel_2;
	private List<Double> listaSuavizacaoExponencial_2;
	private List<Double> listaMediaMovel_4;
	private List<Double> listaSuavizacaoExponencial_4;
	private List<Double> listaMediaMovel_6;
	private List<Double> listaSuavizacaoExponencial_6;
	private List<Double> listaHistorico;
	private double eqm_2;
	private double eqm_4;
	private double eqm_6;
	private double eqmSV_2;
	private double eqmSV_4;
	private double eqmSV_6;
	DecimalFormat df = new DecimalFormat(",000");
	DecimalFormat df2 = new DecimalFormat(",000.00");
	DecimalFormat df3 = new DecimalFormat("0.000");
	DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/yyyy");
	private DateTime dataInicioPrevisao;
	private DateTime dataFinalPrevisao;
	private DateTime dataResultado;
	private Double menorValor_2;
	private Double menorValor_4;
	private Double menorValor_6;
	private Double valorAlpha_2;
	private Double valorAlpha_4;
	private Double valorAlpha_6;
	private Double menorEqm;
		
	public Resultado() {		
	}

	/*public Resultado(Integer sku, List<Double> listaMediaMovel, List<Double> listaSuavizacaoExponencial, double eqm,
			double eqmSV, DateTime dataInicioPrevisao, DateTime dataFinalPrevisao) {
		super();
		this.sku = sku;
		this.listaMediaMovel = listaMediaMovel;
		this.eqm = eqm;
		this.eqmSV = eqmSV;
		this.dataInicioPrevisao = dataInicioPrevisao;
		this.dataFinalPrevisao = dataFinalPrevisao;
	}*/

	public List<Double> getListaHistorico() {
		return listaHistorico;
	}

	public Double getMenorEqm() {
		return menorEqm;
	}

	public void setMenorEqm(Double menorEqm) {
		this.menorEqm = menorEqm;
	}

	public void setListaHistorico(List<Double> listaHistorico) {
		this.listaHistorico = listaHistorico;
	}

	public DateTime getDataResultado() {
		return dataResultado;
	}

	public void setDataResultado(DateTime dataResultado) {
		this.dataResultado = dataResultado;
	}

	public Double getMenorValor_2() {
		return menorValor_2;
	}

	public void setMenorValor_2(Double menorValor_2) {
		this.menorValor_2 = menorValor_2;
	}

	public Double getMenorValor_4() {
		return menorValor_4;
	}

	public void setMenorValor_4(Double menorValor_4) {
		this.menorValor_4 = menorValor_4;
	}

	public Double getMenorValor_6() {
		return menorValor_6;
	}

	public void setMenorValor_6(Double menorValor_6) {
		this.menorValor_6 = menorValor_6;
	}

	public Double getValorAlpha_2() {
		return valorAlpha_2;
	}

	public void setValorAlpha_2(Double valorAlpha_2) {
		this.valorAlpha_2 = valorAlpha_2;
	}

	public Double getValorAlpha_4() {
		return valorAlpha_4;
	}

	public void setValorAlpha_4(Double valorAlpha_4) {
		this.valorAlpha_4 = valorAlpha_4;
	}

	public Double getValorAlpha_6() {
		return valorAlpha_6;
	}

	public void setValorAlpha_6(Double valorAlpha_6) {
		this.valorAlpha_6 = valorAlpha_6;
	}

	public List<Double> getListaMediaMovel_2() {
		return listaMediaMovel_2;
	}

	public void setListaMediaMovel_2(List<Double> listaMediaMovel_2) {
		this.listaMediaMovel_2 = listaMediaMovel_2;
	}

	public List<Double> getListaSuavizacaoExponencial_2() {
		return listaSuavizacaoExponencial_2;
	}

	public void setListaSuavizacaoExponencial_2(List<Double> listaSuavizacaoExponencial_2) {
		this.listaSuavizacaoExponencial_2 = listaSuavizacaoExponencial_2;
	}

	public List<Double> getListaMediaMovel_4() {
		return listaMediaMovel_4;
	}

	public void setListaMediaMovel_4(List<Double> listaMediaMovel_4) {
		this.listaMediaMovel_4 = listaMediaMovel_4;
	}

	public List<Double> getListaSuavizacaoExponencial_4() {
		return listaSuavizacaoExponencial_4;
	}

	public void setListaSuavizacaoExponencial_4(List<Double> listaSuavizacaoExponencial_4) {
		this.listaSuavizacaoExponencial_4 = listaSuavizacaoExponencial_4;
	}

	public List<Double> getListaMediaMovel_6() {
		return listaMediaMovel_6;
	}

	public void setListaMediaMovel_6(List<Double> listaMediaMovel_6) {
		this.listaMediaMovel_6 = listaMediaMovel_6;
	}

	public List<Double> getListaSuavizacaoExponencial_6() {
		return listaSuavizacaoExponencial_6;
	}

	public void setListaSuavizacaoExponencial_6(List<Double> listaSuavizacaoExponencial_6) {
		this.listaSuavizacaoExponencial_6 = listaSuavizacaoExponencial_6;
	}

	public double getEqm_2() {
		return eqm_2;
	}

	public void setEqm_2(double eqm_2) {
		this.eqm_2 = eqm_2;
	}

	public double getEqm_4() {
		return eqm_4;
	}

	public void setEqm_4(double eqm_4) {
		this.eqm_4 = eqm_4;
	}

	public double getEqm_6() {
		return eqm_6;
	}

	public void setEqm_6(double eqm_6) {
		this.eqm_6 = eqm_6;
	}

	public double getEqmSV_2() {
		return eqmSV_2;
	}

	public void setEqmSV_2(double eqmSV_2) {
		this.eqmSV_2 = eqmSV_2;
	}

	public double getEqmSV_4() {
		return eqmSV_4;
	}

	public void setEqmSV_4(double eqmSV_4) {
		this.eqmSV_4 = eqmSV_4;
	}

	public double getEqmSV_6() {
		return eqmSV_6;
	}

	public void setEqmSV_6(double eqmSV_6) {
		this.eqmSV_6 = eqmSV_6;
	}

	public DateTime getDataInicioPrevisao() {
		return dataInicioPrevisao;
	}

	public void setDataInicioPrevisao(DateTime dataInicioPrevisao) {
		this.dataInicioPrevisao = dataInicioPrevisao;
	}

	public DateTime getDataFinalPrevisao() {
		return dataFinalPrevisao;
	}

	public void setDataFinalPrevisao(DateTime dataFinalPrevisao) {
		this.dataFinalPrevisao = dataFinalPrevisao;
	}

	public String getResultadoMedia4() {
		return String.format("%.2f",resultadoMedia4);
	}

	public void setResultadoMedia4(Double resultadoMedia4) {
		this.resultadoMedia4 = resultadoMedia4;
	}

	public String getResultadoMedia2() {
		return String.format("%.2f",resultadoMedia2);
	}

	public void setResultadoMedia2(Double resultadoMedia2) {
		this.resultadoMedia2 = resultadoMedia2;
	}

	public Integer getSKU() {
		return sku;
	}

	public void setSKU(Integer sku) {
		this.sku = sku;
	}

	public Integer getPeriodoTotal() {
		return periodoTotal;
	}

	public void setPeriodoTotal(Integer periodoTotal) {
		this.periodoTotal = periodoTotal;
	}

	public Integer[] getPeriodoUtilizado() {
		return periodoUtilizado;
	}

	public void setPeriodoUtilizado(Integer[] periodoUtilizado) {
		this.periodoUtilizado = periodoUtilizado;
	}

	public String getResultadoMedia() {
		return String.format("%.2f",resultadoMedia);
	}

	public void setResultadoMedia(Double resultadoMedia) {
		this.resultadoMedia = resultadoMedia;
	}

	public String getErroQuadraticoMedio() {
		return String.format("%.2f",erroQuadraticoMedio);
	}

	public void setErroQuadraticoMedio(Double erroQuadraticoMedio) {
		this.erroQuadraticoMedio = erroQuadraticoMedio;
	}
	public String getResultadoMedia3() {
		return String.format("%.2f",resultadoMedia3);
	}

	public void setResultadoMedia3(Double resultadoMedia3) {
		this.resultadoMedia3 = resultadoMedia3;
	}
}
