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

import br.senai.sc.edu.projetomaria.model.Familia;
import br.senai.sc.edu.projetomaria.resource.Config;

public class FamiliaReader {
	
	private Path path;
	private static final Logger LOGGER = LogManager.getLogger();
	//private static final String ID_FAMILIA_COMERCIAL = "ID_FAMILIA_COMERCIAL";
	private static final String COD_FAMILIA_COMERCIAL = "COD_FAMILIA_COMERCIAL";
	private static final String NOME_FAMILIA_COMERCIAL = "NOME_FAMILIA_COMERCIAL";
	
	/*public FamiliaReader(Path path) {
			this.path = path;

	}*/
	private static final String[] mapeamentoColunasArquivo = { COD_FAMILIA_COMERCIAL, NOME_FAMILIA_COMERCIAL };
	
	public List<Familia> readFamilia(Path pathArquivo){
		
		CSVParser parseArquivos = null;

		CSVFormat formatadorCsv = CSVFormat.DEFAULT.withHeader(mapeamentoColunasArquivo).withDelimiter(Config.CSV_DELIMITADOR);

		List<Familia> listaRegistros = new LinkedList<>();

		try (FileReader leitorDeArquivos = new FileReader(pathArquivo.toFile())) {
			
			parseArquivos = new CSVParser(leitorDeArquivos, formatadorCsv);
			
			List<CSVRecord> csvRecords = parseArquivos.getRecords();

			
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord registro = csvRecords.get(i);
				Familia familia = new Familia();
				//familia.setId(id);
				familia.setCodigo(registro.get(COD_FAMILIA_COMERCIAL));
				familia.setNome(registro.get(NOME_FAMILIA_COMERCIAL));
				listaRegistros.add(familia);
			}
			return listaRegistros;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return Collections.emptyList();
	}
	
	
	public List<Familia> readFamiliaInterable() throws IOException {
		try(BufferedReader br = Files.newBufferedReader(this.path)){
			Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader(COD_FAMILIA_COMERCIAL, NOME_FAMILIA_COMERCIAL).parse(br);
			
			ArrayList<Familia> list = new ArrayList<>();

			for (CSVRecord csvRecord : records) {
				String codigo = csvRecord.get(COD_FAMILIA_COMERCIAL);
				String nome = csvRecord.get(NOME_FAMILIA_COMERCIAL);
				Familia familia = new Familia();
				familia.setCodigo(codigo);
				familia.setNome(nome);
				list.add(familia);
			}
			return list;
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
		}
		return Collections.emptyList();
	}
}
