package br.senai.sc.edu.projetomaria.io;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.senai.sc.edu.projetomaria.model.Historico;
import br.senai.sc.edu.projetomaria.resource.Config;
import br.senai.sc.edu.projetomaria.resource.Messages;

public class HistoricoWriter {

	private static final String SEPARADORLINHAS = "\n";
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Object[] colunasArquivo = { "mes_ano", "produto_sku", "id_canal", "quantidade" };

	public void writeCsvFile(Path nomeArquivo, List<Historico> registro) {

		CSVPrinter csvCompiladorDeArquivos = null;

		CSVFormat formatacaoCsv = CSVFormat.DEFAULT.withRecordSeparator(SEPARADORLINHAS).withDelimiter(Config.CSV_DELIMITADOR);

		try (FileWriter escritorDeArquivos = new FileWriter(nomeArquivo.toFile())) {

			csvCompiladorDeArquivos = new CSVPrinter(escritorDeArquivos, formatacaoCsv);

			csvCompiladorDeArquivos.printRecord(colunasArquivo);

			for (Historico historico : registro) {
				csvCompiladorDeArquivos.printRecord(historico.getPeriodo(),
						 historico.getProduto().getSku(), historico.getCanal(), historico.getQuantidade());
			}

			LOGGER.info(Messages.ARQUIVO_CRIADO_COM_SUCESSO);

		} catch (Exception expc) {

			LOGGER.warn(Messages.ERRO_ESCRITOR_DE_ARQUIVO, expc);
			
		}
	}
}
