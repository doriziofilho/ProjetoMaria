package br.senai.sc.edu.projetomaria;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MediaMovel {

	Deque<Double> Media;
	double soma;
	int tamMediaMovel;
	int previsao;
	List<Double> listaMediaMovel;
	List<Double> listaHistorico;
	Deque<Double> mediaMovel;
	
	public MediaMovel() {
		super();
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


	public List<Double> calcularMediaMovel(){
		mediaMovel = new LinkedList<Double>();
		listaMediaMovel = new LinkedList<Double>();
		
		for (int j = 0; j < previsao; j++) {
			listaHistorico.add(0.0);
		}
		
		
		for ( int i = 0; i < (listaHistorico.size()); i++) {
			if(mediaMovel.size() < tamMediaMovel) {
				listaMediaMovel.add(0.0);
				soma += listaHistorico.get(i);
				mediaMovel.add(listaHistorico.get(i));
			}else{
				if(listaHistorico.get(i) == 0.00) {					
					listaMediaMovel.add(soma/tamMediaMovel);
					soma -= mediaMovel.removeFirst();
					
					soma += listaMediaMovel.get(i);
					System.out.println(i+" "+listaHistorico.get(i)+" "+listaMediaMovel.get(i));			
					
					mediaMovel.add(listaMediaMovel.get(i));
				}else {
				
					listaMediaMovel.add(soma/tamMediaMovel);
					soma -= mediaMovel.removeFirst();
					
					soma += listaHistorico.get(i);
					System.out.println(i+" "+listaHistorico.get(i)+" "+listaMediaMovel.get(i));			
					
					mediaMovel.add(listaHistorico.get(i));
				}
			}
		}	
		return listaMediaMovel;
		
		}
	
}
