package Testes_;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.senai.sc.edu.projetomaria.stat.CalculoPI;

public class Teste_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> lh = new LinkedList<Integer>();
		lh.add(3139); lh.add(6328); lh.add(5246); lh.add(5354); lh.add(5615); lh.add(3862);
		lh.add(7341); lh.add(5500); lh.add(5993); lh.add(6108); lh.add(6352); lh.add(5265);
		lh.add(5491); lh.add(6859); lh.add(5627); lh.add(8018); lh.add(5629); lh.add(5345);
		lh.add(7112); lh.add(8123); lh.add(7684); lh.add(5220); lh.add(5462); lh.add(6363);
		lh.add(8495); lh.add(7190); lh.add(4264); lh.add(6950); lh.add(6283); lh.add(10147);
		lh.add(11849); lh.add(10394); lh.add(5650); lh.add(6332); lh.add(5810); lh.add(7261);
		lh.add(9621); lh.add(7165); lh.add(8660); lh.add(11279); lh.add(11468); lh.add(11499);
		lh.add(12913); lh.add(8789); lh.add(7521); lh.add(15593); lh.add(10333); lh.add(16920);
		lh.add(13820); lh.add(12812); lh.add(14062); lh.add(14532); lh.add(9026); lh.add(12956);
		lh.add(15940); lh.add(11920); lh.add(13437); lh.add(14796); lh.add(12023); lh.add(11728);
		lh.add(14398); lh.add(11320); lh.add(12741); lh.add(11162); lh.add(9474);
		
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		String dataInicio = "01/03/2013";
		String dataFim = "01/01/2021";
		
		DateTime data1 = fmt.parseDateTime(dataInicio);
		DateTime data2 = fmt.parseDateTime(dataFim);
		
		List<Integer> lh2 = new LinkedList<>(lh);
//		CalculoPI mv2 = new CalculoPI(2, lh2, data1, data2);
//		mv2.calcularMediaMovel();
//		mv2.calcuarSuavizacaoExponencial(0.33);
//		mv2.calcularEqmMM();
//		mv2.calcularEqmSV();
//		
		
//		CalculoPI mv4 = new CalculoPI(4, data1, data2, 1.0);
//		List<Double> lh4 = new LinkedList<>(lh);
//		mv4.setListaHistorico(lh4);
//		mv4.calcularMediaMovel();
//		mv4.calcuarSuavizacaoExponencial(0.32);
//		mv4.calcularEqmMM();
//		mv4.calcularEqmSV();
//		
//		CalculoPI mv6 = new CalculoPI(6, data1, data2, 1.0);
//		List<Double> lh6 = new LinkedList<>(lh);
//		mv6.setListaHistorico(lh6);
//		mv6.calcularMediaMovel();
//		mv6.calcuarSuavizacaoExponencial(0.31);
//		mv6.calcularEqmMM();
//		mv6.calcularEqmSV();
//		
//		CalculoPI mv8 = new CalculoPI(8, data1, data2, 1.0);
//		List<Double> lh8 = new LinkedList<>(lh);
//		mv8.setListaHistorico(lh8);
//		mv8.calcularMediaMovel();
//		mv8.calcuarSuavizacaoExponencial(0.31);
//		mv8.calcularEqmMM();
//		mv8.calcularEqmSV();
//		
//		System.out.println(mv2.escreveListaMedia());
//		System.out.println(mv2.escreveListaExponencial());
//		System.out.println(mv2.escreveErroQuaMedioMM());
//		System.out.println(mv2.escreveErroQuaMedioSV());
//		
//		System.out.println(mv4.escreveListaMedia());
//		System.out.println(mv4.escreveListaExponencial());
//		System.out.println(mv4.escreveErroQuaMedioMM());
//		System.out.println(mv4.escreveErroQuaMedioSV());
//		
//		System.out.println(mv6.escreveListaMedia());
//		System.out.println(mv6.escreveListaExponencial());
//		System.out.println(mv6.escreveErroQuaMedioMM());
//		System.out.println(mv6.escreveErroQuaMedioSV());
//		
//		System.out.println(mv8.escreveListaMedia());
//		System.out.println(mv8.escreveListaExponencial());
//		System.out.println(mv8.escreveErroQuaMedioMM());
//		System.out.println(mv8.escreveErroQuaMedioSV());
//		
//		mv2.calcularMenorAlpha();
//		System.out.println(mv2.escreverMenorAlpha());
//		mv4.calcularMenorAlpha();
//		System.out.println(mv4.escreverMenorAlpha());
//		mv6.calcularMenorAlpha();
//		System.out.println(mv6.escreverMenorAlpha());
//		mv8.calcularMenorAlpha();
//		System.out.println(mv8.escreverMenorAlpha());
//		
//		
//		System.out.println(mv2.escreveErroQuaMedioMM());
//			System.out.println(mv2.escreveErroQuaMedioSV());
//		System.out.println(mv4.escreveErroQuaMedioMM());
//			System.out.println(mv4.escreveErroQuaMedioSV());
//		System.out.println(mv6.escreveErroQuaMedioMM());
//			System.out.println(mv6.escreveErroQuaMedioSV());
//		System.out.println(mv8.escreveErroQuaMedioMM());
//			System.out.println(mv8.escreveErroQuaMedioSV());
//		
//		
//		
		
//		Grafico grafico = new Grafico(mv2.getListaMediaMovel(), data1);
//		grafico.criarGrafico(mv2.getListaMediaMovel(), mv2.getDataInicioPrevisao());
	}

}
