package br.senai.sc.edu.projetomaria.io;

import java.io.FileWriter;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import Testes_.Grafico;
import br.senai.sc.edu.projetomaria.model.Resultado;
import br.senai.sc.edu.projetomaria.resource.Config;
import br.senai.sc.edu.projetomaria.resource.Messages;

public class EstimativaWritter {
	DecimalFormat df = new DecimalFormat(",000");
	DecimalFormat df2 = new DecimalFormat("0.000");
	DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/yyyy");
	DateTimeFormatter fmt1 = DateTimeFormat.forPattern("dd/MM/yyyy");

	private static final String SEPARADORCOLUNAS = "\n";
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Object[] colunasArquivo = {"Sku", "mes_ano","Historico", "Demanda", "Previs�o MM-2", "previs�o MM-4", "previs�o MM-6",
													"Suav. Ex. - MM-2", "Suav. Ex. - MM-4", "Suav. Ex. - MM-6" };

public void escrever(Path nomeArquivo,  DateTime dataInicial, DateTime dataPrevisao) {
		CSVPrinter csvCompiladorDeArquivos = null;

		CSVFormat formatacaoCsv = CSVFormat.DEFAULT.withRecordSeparator(SEPARADORCOLUNAS).withDelimiter(Config.CSV_DELIMITADOR);

		try (FileWriter escritorDeArquivos = new FileWriter(nomeArquivo.toFile())) {

			csvCompiladorDeArquivos = new CSVPrinter(escritorDeArquivos, formatacaoCsv);

			Estimativa estimativa = new Estimativa();
			List<Resultado> listaResultado = new LinkedList<>();
			listaResultado  = estimativa.calculo(dataInicial, dataPrevisao);
			
			Iterator<Resultado> it = listaResultado.iterator();
			
			while (it.hasNext()) {
				csvCompiladorDeArquivos.printRecord(colunasArquivo);
				Resultado resultado = it.next();
				for (int i = 0; i < resultado.getListaMediaMovel_2().size(); i++) {
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),
													fmt.print(resultado.getDataInicioPrevisao().plusMonths(i+1)),
													df.format(resultado.getListaHistorico().get(i)),
													df.format(resultado.getListaMediaMovel_2().get(i)),
													df.format(resultado.getListaMediaMovel_4().get(i)),
													df.format(resultado.getListaMediaMovel_6().get(i)),
													df.format(resultado.getListaSuavizacaoExponencial_2().get(i)),
													df.format(resultado.getListaSuavizacaoExponencial_4().get(i)),
													df.format(resultado.getListaSuavizacaoExponencial_6().get(i))
													);
				}
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getEqm_2()) + "  < -- Erro Quadratico M�dio MM 2");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getEqm_4()) + "  < -- Erro Quadratico M�dio MM 4");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getEqm_6()) + "  < -- Erro Quadratico M�dio MM 6");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getEqmSV_2()) + "  < -- Erro Quadratico M�dio Suav. Exp 2");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getEqmSV_4()) + "  < -- Erro Quadratico M�dio Suav. Exp 4");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getEqmSV_6()) + "  < -- Erro Quadratico M�dio Suav. Exp 6");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df2.format(resultado.getValorAlpha_2()) + "  < -- Menor Valor de ALPHA para Suav. Exp 2");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df2.format(resultado.getValorAlpha_4()) + "  < -- Menor Valor de ALPHA para Suav. Exp 4");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df2.format(resultado.getValorAlpha_6()) + "  < -- Menor Valor de ALPHA para Suav. Exp 6");
				csvCompiladorDeArquivos.printRecord(resultado.getSKU(),df.format(resultado.getMenorEqm()) + "  < -- Menor Erro Quadratico.");
				
				Grafico grafico = new Grafico(resultado.getListaMediaMovel_2(),
						resultado.getListaMediaMovel_4(),
						resultado.getListaMediaMovel_6(),
						resultado.getListaSuavizacaoExponencial_2(),
						resultado.getListaSuavizacaoExponencial_4(),
						resultado.getListaSuavizacaoExponencial_6(),
						dataInicial);
			}
			
			LOGGER.info(Messages.ARQUIVO_CRIADO_COM_SUCESSO);

		} catch (Exception expc) {

			LOGGER.warn(Messages.ERRO_ESCRITOR_DE_ARQUIVO, expc);
			
		}
	}
}
