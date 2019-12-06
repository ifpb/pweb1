package br.edu.ifpb.pweb1.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

//Abstract Factory
public class DAOFactory {

	public static ProdutoDAO createProdutoDAO() throws SQLException {
		ProdutoDAO produtoDAO = new ProdutoDAOImpl();
		return produtoDAO;
	}

}
