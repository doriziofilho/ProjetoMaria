package br.senai.sc.edu.projetomaria;
import java.text.DecimalFormat;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class CalculoPI {

	private Deque<Double> Media;
	private double soma;
	private double eqm;
	private double eqmSV;
	private int tamMediaMovel;
	private int previsao;
	private List<Double> listaMediaMovel;
	private List<Double> listaHistorico;
	private List<Double> listaSuavizacaoExponencial;
	private Deque<Double> mediaMovel;
	DecimalFormat df = new DecimalFormat(",000");
	DecimalFormat df2 = new DecimalFormat(",000.00");
	DecimalFormat df3 = new DecimalFormat("0.#");
	DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/yyyy");
	private Double menorValor;
	private Double valorAlpha;
	private DateTime dataInicioPrevisao;
	private DateTime dataFinalPrevisao;
	private double alpha;
	
	public CalculoPI() {
		super();
	}

	public CalculoPI(int tamMediaMovel, List<Double> listaHistorico, DateTime dataInicioPrevisao,
			DateTime dataFinalPrevisao) {
		super();
		this.tamMediaMovel = tamMediaMovel;
		this.listaHistorico = listaHistorico;
		this.dataInicioPrevisao = dataInicioPrevisao;
		this.dataFinalPrevisao = dataFinalPrevisao;
	}

	public Double getMenorValor() {
		return menorValor;
	}

	public void setMenorValor(Double menorValor) {
		this.menorValor = menorValor;
	}

	public Double getValorAlpha() {
		return valorAlpha;
	}

	public void setValorAlpha(Double valorAlpha) {
		this.valorAlpha = valorAlpha;
	}

	public double getEqmSV() {
		return eqmSV;
	}

	public void setEqmSV(double eqmSV) {
		this.eqmSV = eqmSV;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
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

	public double getEqm() {
		return eqm;
	}

	public void setEqm(double eqm) {
		this.eqm = eqm;
	}

	public Deque<Double> getMediaMovel() {
		return mediaMovel;
	}

	public void setMediaMovel(Deque<Double> mediaMovel) {
		this.mediaMovel = mediaMovel;
	}

	public Deque<Double> getMedia() {
		return Media;
	}

	public void setMedia(Deque<Double> media) {
		Media = media;
	}

	public double getSoma() {
		return soma;
	}

	public void setSoma(double soma) {
		this.soma = soma;
	}

	public int getTamMediaMovel() {
		return tamMediaMovel;
	}

	public void setTamMediaMovel(int tamMediaMovel) {
		this.tamMediaMovel = tamMediaMovel;
	}

	public int getPrevisao() {
		return previsao;
	}

	public void setPrevisao(int previsao) {
		this.previsao = previsao;
	}

	public List<Double> getListaSuavizacaoExponencial() {
		return listaSuavizacaoExponencial;
	}

	public void setListaSuavizacaoExponencial(List<Double> listaSuavizacaoExponencial) {
		this.listaSuavizacaoExponencial = listaSuavizacaoExponencial;
	}

	public List<Double> getListaMediaMovel() {
		return listaMediaMovel;
	}

	public void setListaMediaMovel(List<Double> listaMediaMovel) {
		this.listaMediaMovel = listaMediaMovel;
	}

	public List<Double> getListaHistorico() {
		return listaHistorico;
	}

	public void setListaHistorico(List<Double> listaHistorico) {
		this.listaHistorico = listaHistorico;
			
	}
		
	public void calcularMediaMovel(){
		mediaMovel = new LinkedList<Double>();
		listaMediaMovel = new LinkedList<Double>();
		double soma = 0.0;
		for (int j = 0; j < calcularNumeroPrevisoes(); j++) {
			listaHistorico.add(0.0);
		}
		for ( int i = 0; i < listaHistorico.size(); i++) {
			if(mediaMovel.size() < tamMediaMovel) {
				listaMediaMovel.add(0.0);
				soma += listaHistorico.get(i);
				mediaMovel.add(listaHistorico.get(i));
			}else{
				if(listaHistorico.get(i) == 0.0) {
					listaMediaMovel.add(i, soma / tamMediaMovel);
					listaHistorico.set(i, soma / tamMediaMovel);
					soma -= mediaMovel.removeFirst();
					soma += listaMediaMovel.get(i);
					mediaMovel.add(listaMediaMovel.get(i));
			}else {
				listaMediaMovel.add(soma / tamMediaMovel);
				soma -= mediaMovel.removeFirst();
				soma += listaHistorico.get(i);
				mediaMovel.add(listaHistorico.get(i));
			}
			}
		}
	}
	
	public void calcularEqmMM() { 
		double soma = 0.0;
		int tamanho = calcularPeriodo() - this.getTamMediaMovel();
		for (int i = 0; i < tamanho; i++) {
			soma += Math.pow(Math.abs(getListaHistorico().get(i+getTamMediaMovel()) - getListaMediaMovel().get(i+getTamMediaMovel())), 2);
		}
		eqm = soma / tamanho;
	}
	
	public void calcularEqmSV() { 
		double soma = 0.0;
		int tamanho = getListaHistorico().size();
		for (int i = 0; i < tamanho; i++) {
			soma += Math.pow(Math.abs(getListaHistorico().get(i) - getListaSuavizacaoExponencial().get(i)), 2);
		}
		eqmSV = soma / tamanho;
	}
	
	public String escreveErroQuaMedioMM() {
		String eqm ="";
		eqm = "O EQM para a Média Movel de " + getTamMediaMovel() + " é de: " + df.format(getEqm()) + '\n';
		return eqm;
	
	}	
	
	public String escreveErroQuaMedioSV() {
		String eqm ="";
		eqm = "O EQM para a Média Exponencial: " + getTamMediaMovel() + " é de: " + df.format(getEqmSV()) + '\n';
		return eqm;
	}
	
	public String escreveListaMedia() {
		String mediaMovel = "";
		for (int i = 0; i < calcularPeriodo(); i++) {
			mediaMovel += "Demanda mês: " + 
					(fmt.print(getDataInicioPrevisao().plusMonths(i)))  + " - " + 
					df.format(listaHistorico.get(i)) + " Previsão: " + (i+1) +
					" - " + df.format(getListaMediaMovel().get(i))+"\n";
		}
		return mediaMovel;
			
	}
		
	public int calcularPeriodo() {
		return Months.monthsBetween(getDataInicioPrevisao(), getDataFinalPrevisao()).getMonths()+1;
	
	}
	public int calcularNumeroPrevisoes() {
		/*lembrar de zerar a data para previsoes definitivas*/
		DateTime hoje = new DateTime(2018, 10, 01,0,0,0);  
		return Months.monthsBetween(hoje, getDataFinalPrevisao()).getMonths();
	}

	public void calcuarSuavizacaoExponencial(Double alpha) {
		this.alpha = alpha;
		List<Double> prev = getListaHistorico();
		listaSuavizacaoExponencial = new LinkedList<>();
		double suave = 0.0;
		listaSuavizacaoExponencial.add((double)prev.get(0));
		for (int i = 1; i < prev.size(); i++) {
			suave = listaSuavizacaoExponencial.get(i-1) + alpha * (prev.get(i-1) - listaSuavizacaoExponencial.get(i-1));
			listaSuavizacaoExponencial.add(suave);
		}
		
	}

	public String escreveListaExponencial() {
		String suavizacao = "";
		for (int i = 0; i < calcularPeriodo(); i++) {
			suavizacao += "Demanda para o mês: " + 
					(fmt.print(getDataInicioPrevisao().plusMonths(i)))  + " - " + 
					df.format(getListaHistorico().get(i)) + " Suavização: " + (i+1) +
					" - " + df.format(getListaSuavizacaoExponencial().get(i))+"\n";
		}
		return suavizacao;
	}
	
	public void calcularMenorAlpha() {
		double i = 0.01;
		double valor;
		double menorValor = 0;
		double menorAlpha = 0;
		while (i <= 1.0) {
			setAlpha(i);
			this.calcuarSuavizacaoExponencial(i);
			this.calcularEqmSV();
			valor = this.getEqmSV();
			if(menorValor == 0.0){
				menorValor = this.getEqmSV();
				menorAlpha = i;
			}else {			
			if (valor < menorValor  ) {
				menorValor = valor;
				menorAlpha = i;
			}
			i += 0.01;
		}
			setValorAlpha(menorAlpha);
			setMenorValor(menorValor);
		}
		
	}
	public String escreverMenorAlpha() {
		String AlphaM = "";
		AlphaM += "O menor valor para alpha é : " + df3.format(getValorAlpha()) + " - O valor do menor EQM: é " + df.format(getMenorValor());
		return AlphaM;	
	}
	
}
