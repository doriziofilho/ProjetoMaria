package br.senai.sc.edu.projetomaria.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.senai.sc.edu.projetomaria.model.Phase;
import br.senai.sc.edu.projetomaria.model.Produto;
import br.senai.sc.edu.projetomaria.resource.Messages;

public class ProdutoDAO extends AbstractDAO {
	private static final Logger LOGGER = LogManager.getLogger();
	int total;

	public List<Produto> listarTodos() throws IOException {
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		try {
			String sql = "select * from produto";
			Statement stmt = getConnection().createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Produto p = new Produto();
				p.setCodFamilia(rs.getString("COD_FAMILIA_COMERCIAL"));
				p.setDescricao(rs.getString("NOME_PRODUTO"));
				p.setSku(rs.getInt("SKU"));

				listaProdutos.add(p);
			}

			for (Produto produto : listaProdutos) {
				LOGGER.info("=== {} | {} ===", produto.toString(), Messages.PROJETO_VERSAO); //$NON-NLS-1$
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProdutos;
	}

	public List<Produto> exportarProdutos() {
		String sql = "SELECT * FROM PRODUTO;";

		List<Produto> p = new ArrayList<>();
		try (Connection conn = getConnection();
				Statement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				Produto produtos = null;
				produtos = new Produto();
				produtos.setCodFamilia(rs.getString("COD_FAMILIA_COMERCIAL"));
				produtos.setDescricao(rs.getString("NOME_PRODUTO"));
				produtos.setSku(rs.getInt("SKU"));
				
				p.add(produtos);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return p;
	}

	public List<Phase> exportarPhase() {
		String sql = "SELECT * FROM SKU_PHASE;";

		List<Phase> ph = new ArrayList<>();
		try (Connection conn = getConnection();
				Statement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				Phase phase = null;
				phase = new Phase();
				phase.setSkuNew(Integer.parseInt(rs.getString("SKU_PHASE_IN")));
				phase.setSkuOld(Integer.parseInt(rs.getString("SKU_PHASE_OUT")));
				ph.add(phase);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return ph;
	}

	public void salvarProdutos(List<Produto> list) {
		String sql = "";
		int successes = 0;
		total = 0;

		for (Produto p : list) {
			/*sql = "INSERT INTO PRODUTO(" + "SKU," + "NOME_PRODUTO," + "ID_FAMILIA_COMERCIAL) VALUES (" + p.getSku()
					+ ",'" + p.getDescricao() + "'," + p.getIdComercial() + ");";*/
			sql = "INSERT INTO PRODUTO VALUES (" + p.getCodFamilia() + ",'" + p.getDescricao() + "'," + p.getSku() + ")"
					+ " ON DUPLICATE KEY UPDATE COD_FAMILIA_COMERCIAL = "+ p.getCodFamilia() + ", NOME_PRODUTO = '" +p.getDescricao() +"';";
			
			try (Connection conn = getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.execute();
				successes++;
			} catch (SQLIntegrityConstraintViolationException eSql) {
				LOGGER.info(Messages.ERRO_ID_FAMILIA);
				
					
			}catch (SQLException e) {
				LOGGER.error(e);
			}
			total++;
		}
		LOGGER.info(successes + " de " + total + " " + Messages.SUCCESS_PRODUTO);
	}
/*
	public void updateProduto(List<Produto> skuIgual) {
		String sql = "";
		int successes = 0;
		total = 0;

		for (Produto p : skuIgual) {
			sql = "UPDATE produto SET NOME_PRODUTO = '" + p.getDescricao()
					+ "', " + "ID_FAMILIA_COMERCIAL = " + p.getIdComercial()
					+ " WHERE SKU = " + p.getSku() + ";";
			try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.executeUpdate();
				successes++;
			} catch (SQLException e) {
				LOGGER.debug(e);
			}
			total++;
		}
		LOGGER.info(successes + " de " + total + " " + Messages.SUCCESS_PRODUTO);
	}*/

	public void insertSkuPhase(List<Phase> phase) {
		String sql = "";
		int successes = 0;
		total = 0;
	
		for (Phase p : phase) {
			
			sql = "INSERT INTO sku_phase( SKU_PHASE_IN, SKU_PHASE_OUT) VALUES (" + p.getSkuNew() + ","
					+ p.getSkuOld() + ") ON DUPLICATE KEY UPDATE SKU_PHASE_IN = "+p.getSkuNew()+", SKU_PHASE_OUT = "+p.getSkuOld()+";";

			try (Connection conn = getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.execute();
				successes++;
			} catch (SQLException e) {
				LOGGER.debug(e);
			}
			total++;
		}
		LOGGER.info(successes + " de " + total + " " + Messages.SUCCESS_PRODUTO);
	}

	public void deleteProd(List<Produto> list) {
		String sql = "";
		int successes = 0;
		total = 0;

		for (Produto p : list) {
			sql = "DELETE FROM PRODUTO WHERE SKU = " + p.getSku() + ";";
			try (Connection conn = getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);) {
				stmt.execute();
				successes++;
			} catch (SQLException e) {
				LOGGER.debug(e);
			}
			total++;
		}
		LOGGER.info(successes + " de " + total + " " + Messages.SUCCESS_PRODUTO);
	}
}
