package br.senai.sc.edu.projetomaria.io;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.senai.sc.edu.projetomaria.model.Phase;
import br.senai.sc.edu.projetomaria.resource.Config;
import br.senai.sc.edu.projetomaria.resource.Messages;

public class PhaseReader {

	private static final String SKU_PHASE_IN = "sku_phase_in";
	private static final String SKU_PHASE_OUT = "sku_phase_out";

	private static final Logger LOGGER = LogManager.getLogger();

	private static final String[] mapeamentoColunasArquivo = { SKU_PHASE_IN, SKU_PHASE_OUT };	
	
	public List<Phase> lerCsvPhase(Path caminho) {
		CSVParser parseArquivos = null;

		CSVFormat formatadorCsv = CSVFormat.DEFAULT.withHeader(mapeamentoColunasArquivo).withDelimiter(Config.CSV_DELIMITADOR);

		List<Phase> listaRegistros = new LinkedList<>();
		
		boolean wrongInserts = false;

		try (FileReader leitorDeArquivos = new FileReader(caminho.toFile())) {
			
			parseArquivos = new CSVParser(leitorDeArquivos, formatadorCsv);
			
			List<CSVRecord> csvRecords = parseArquivos.getRecords();

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord registro = csvRecords.get(i);
				Phase phase = new Phase();
				phase.setSkuNew(this.parseInt(registro.get(SKU_PHASE_IN)));
				phase.setSkuOld(this.parseInt(registro.get(SKU_PHASE_OUT)));
				listaRegistros.add(phase);
				
				/*if (!phase.isValid()) {
					wrongInserts = true; 
					LOGGER.warn("A linha " + i + " está fora do padrão, registro ignorado.");
				}*/
			}
			return listaRegistros;
		}catch (Exception e){
 			LOGGER.error(e.getMessage(), e);
		}
		
		if (wrongInserts) {
			LOGGER.info(Messages.DADOS_NAO_INSERIDOS);
		}else {
			LOGGER.info(Messages.LEITURA_REALIZADA);
		}
		
		return Collections.emptyList();
	}

	protected int parseInt(String valor) {
		Integer retorno = null;
		try {
			retorno = Integer.parseInt(valor);
		} catch (NumberFormatException e) {
			LOGGER.warn(Messages.ERRO_AO_CONVERTER, e);
		}
		return retorno == null ? -1 : retorno;
	}
	
}