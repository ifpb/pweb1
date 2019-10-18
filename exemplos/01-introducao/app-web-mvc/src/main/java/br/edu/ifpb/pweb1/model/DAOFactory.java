package br.edu.ifpb.pweb1.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

//Abstract Factory
public class DAOFactory {

	// Template Method
	private static String TIPO_DAO;
	
	static {
		InputStream inputStream = DAOFactory.class.getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TIPO_DAO = properties.getProperty("dao.tipo");
	}

	public static LivroDAO createLivroDAO() throws SQLException {
		LivroDAO livroDAO = null;
		switch (TIPO_DAO) {
		case "BANCO":
			livroDAO = new LivroDAOBD();
			break;
		case "MEMORIA":
			livroDAO = new LivroDAOMemoria();
		}
		return livroDAO;
	}

}
