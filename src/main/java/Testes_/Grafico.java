package Testes_;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Grafico extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/yyyy");
	
	public Grafico(List<Double> Lista,
					List<Double> Lista_2,
					List<Double> Lista_3,
					List<Double> Lista_4,
					List<Double> Lista_5,
					List<Double> Lista_6, 
					DateTime dataInicio) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(950, 700);
		setLocationRelativeTo(null);
		criarGrafico(Lista, Lista_2, Lista_3, Lista_4, Lista_5, Lista_6, dataInicio);
		setVisible(true);
	}
	
	public void criarGrafico(List<Double> Lista,
							List<Double> Lista_2,
							List<Double> Lista_3,
							List<Double> Lista_4,
							List<Double> Lista_5,
							List<Double> Lista_6,
							DateTime dataInicio) {
		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
		List<Double> previsao = Lista;
		List<Double> previsao_2 = Lista_2;
		List<Double> previsao_3 = Lista_3;
		List<Double> previsao_4 = Lista_4;
		List<Double> previsao_5 = Lista_5;
		List<Double> previsao_6 = Lista_6;
		DateTime dataIni = dataInicio;
		
		for(int i = 2; i < previsao.size(); i++) {
			String datax = fmt.print(dataIni.plusMonths(i));
			dataSet.setValue(previsao.get(i), "Previsao MM - 2" ,String.valueOf(datax));
		}
		for(int j = 4; j < previsao_2.size(); j++) {
			String datax = fmt.print(dataIni.plusMonths(j));
			dataSet.setValue(previsao_2.get(j), "Previsao MM - 4" ,String.valueOf(datax));
		}
		for(int k = 6; k < previsao_3.size(); k++) {
			String datax = fmt.print(dataIni.plusMonths(k));
			dataSet.setValue(previsao_3.get(k), "Previsao MM - 6" ,String.valueOf(datax));
		}
		for(int l = 2; l < previsao_4.size(); l++) {
			String datax = fmt.print(dataIni.plusMonths(l));
			dataSet.setValue(previsao_4.get(l), "Previsao SE - 2" ,String.valueOf(datax));
		}
		for(int m = 2; m < previsao_5.size(); m++) {
			String datax = fmt.print(dataIni.plusMonths(m));
			dataSet.setValue(previsao_5.get(m), "Previsao SE - 4" ,String.valueOf(datax));
		}
		for(int n = 2; n < previsao_6.size(); n++) {
			String datax = fmt.print(dataIni.plusMonths(n));
			dataSet.setValue(previsao_6.get(n), "Previsao SE - 6" ,String.valueOf(datax));
		}
		
		JFreeChart grafico = ChartFactory.createLineChart(
				"Grafico Teste",
				"Data - teste",
				"Valor",
				dataSet,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
				);
		ChartPanel painel = new ChartPanel(grafico);
		add(painel);
	}

	
}
