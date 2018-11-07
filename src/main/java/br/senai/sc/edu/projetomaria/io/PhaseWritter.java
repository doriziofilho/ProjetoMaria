package br.senai.sc.edu.projetomaria.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import br.senai.sc.edu.projetomaria.dao.ProdutoDAO;
import br.senai.sc.edu.projetomaria.model.Phase;

public class PhaseWritter {

	private static final String separadorLinhas = "\n";
	private static final Object[] colunasArquivo = { "SKU_PHASE_IN", "SKU_PHASE_OUT" };
	//private static final Logger LOGGER = LogManager.getLogger();

	public void gerarArquivoPhase(Path path) {

		FileWriter escritorDeArquivos = null;

		CSVPrinter csvCompiladorDeArquivos = null;

		CSVFormat formatacaoCsv = CSVFormat.DEFAULT.withRecordSeparator(separadorLinhas).withDelimiter(';');

		try {
			escritorDeArquivos = new FileWriter(path.toString());

			csvCompiladorDeArquivos = new CSVPrinter(escritorDeArquivos, formatacaoCsv);
			
			try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path.toString()))) {
				
				CSVPrinter csvPrinter = new CSVPrinter(writer, formatacaoCsv);
				csvCompiladorDeArquivos.printRecord(colunasArquivo);
				{	
					ProdutoDAO dao = new ProdutoDAO();
					for (Phase ph : dao.exportarPhase()) {
						csvCompiladorDeArquivos.printRecord(ph.getSkuNew(), ph.getSkuOld());
					}
					csvPrinter.flush();
					csvPrinter.close();
				}
			
			}catch (Exception e) {
				e.printStackTrace();
			}
				System.out.println("O arquivo CSV criado com sucesso!");
			
		}catch (Exception e) {

			System.out.println("Erro no escritorDeArquivos!");
			e.printStackTrace();
		} finally {
			try {
				escritorDeArquivos.flush();
				escritorDeArquivos.close();
				csvCompiladorDeArquivos.close();
			} catch (IOException e) {
				System.out.println("Erro ao enviar/fechar o escritorDeArquivos/csvCompiladorDeArquivos!");
				e.printStackTrace();
			}
		}
	}
}