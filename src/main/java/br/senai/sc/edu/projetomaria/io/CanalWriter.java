package br.senai.sc.edu.projetomaria.io;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.senai.sc.edu.projetomaria.dao.CanalDAO;
import br.senai.sc.edu.projetomaria.model.Canal;
import br.senai.sc.edu.projetomaria.resource.Config;

public class CanalWriter {
	
	private static final String SEPARADORLINHAS = "\n";
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Object[] colunasArquivo = { "ID_CANAL", "DESCRICAO" };
	

	public void generateRelatorio(Path nomeArquivo) throws IOException {
		CSVPrinter csvCompiladorDeArquivos = null;

		CSVFormat formatacaoCsv = CSVFormat.DEFAULT.withRecordSeparator(SEPARADORLINHAS).withDelimiter(Config.CSV_DELIMITADOR);

		try (FileWriter escritorDeArquivos = new FileWriter(nomeArquivo.toFile())) {

			csvCompiladorDeArquivos = new CSVPrinter(escritorDeArquivos, formatacaoCsv);

			csvCompiladorDeArquivos.printRecord(colunasArquivo);

				CanalDAO dao = new CanalDAO();
				List<Canal> canais = new ArrayList<>();
				canais = dao.getCanais();
				for (Canal canal : canais) {
					csvCompiladorDeArquivos.printRecord(canal.getId(), canal.getDescricao());
				}
		
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
	}

}
