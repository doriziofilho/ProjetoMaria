package br.senai.sc.edu.projetomaria.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.senai.sc.edu.projetomaria.model.Canal;
import br.senai.sc.edu.projetomaria.resource.Config;

public class CanalReader {

	private Path path;
	private static final Logger LOGGER = LogManager.getLogger();
	private static final String DESCRICAO = "DESCRICAO";
	private static final String[] mapeamentoColunasArquivo = { DESCRICAO };
	
	/*public CanalReader(Path path) {
		this.path = path;
	}*/

	boolean wrongInserts = false;
	
	public List<Canal> readCanal(Path pathArquivo){
		CSVParser parseArquivos = null;
		CSVFormat formatadorCsv = CSVFormat.DEFAULT.withHeader(mapeamentoColunasArquivo).withDelimiter(Config.CSV_DELIMITADOR);
		List<Canal> listaRegistros = new LinkedList<>();
		
		try (FileReader leitorDeArquivos = new FileReader(pathArquivo.toFile())) {
			
			parseArquivos = new CSVParser(leitorDeArquivos, formatadorCsv);
			
			List<CSVRecord> csvRecords = parseArquivos.getRecords();
			
			for (int i = 1; i <csvRecords.size(); i++) {
				CSVRecord registro = csvRecords.get(i);
				Canal canal = new Canal();
				canal.setDescricao(registro.get(DESCRICAO));
				listaRegistros.add(canal);
			}
			return listaRegistros;
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	public List<Canal> readCanalIncrement() throws IOException {
		try(BufferedReader br = Files.newBufferedReader(this.path)){
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader(DESCRICAO).parse(br);
			
			ArrayList<Canal> list = new ArrayList<>();

			for (CSVRecord csvRecord : records) {
				String descricao = csvRecord.get(DESCRICAO);
				Canal canal = new Canal();
				canal.setDescricao(descricao);
				list.add(canal);
			}
			return list;
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
}
