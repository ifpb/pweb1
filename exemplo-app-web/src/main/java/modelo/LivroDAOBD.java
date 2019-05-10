package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.conexao.ConnectionFactory;

public class LivroDAOBD implements LivroDAO {

	private List<Livro> livros = new ArrayList();
	
	private Connection conexao;
	
	public LivroDAOBD() {
		ConnectionFactory factory = new ConnectionFactory();
		this.conexao = factory.getConnection();
	}

	@Override
	public List<String> recuperarISBNs() {
		return null;
	}

	@Override
	public List<String> recuperarISBNs(String autor) {
		return null;
	}

	@Override
	public List<Livro> buscarPorAutor(String autor) {
		return null;
	}

	public List<Livro> listarLivros() {
		List<Livro> livros = new ArrayList();
		try {
			Statement statement = this.conexao.createStatement();
			statement.execute("SELECT * FROM livros");
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				livros.add(new Livro(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getString("isbn"), resultSet.getString("autor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}

	public Optional<Livro> recuperarPorId(Long id) {
		Optional<Livro> livro = Optional.empty();
		try {
			PreparedStatement statement = this.conexao.prepareStatement("SELECT * FROM livros WHERE id = ?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				livro = livro.of(new Livro(resultSet.getInt("id"), resultSet.getString("titulo"), resultSet.getString("isbn"), resultSet.getString("autor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public Livro criarLivro(Livro livro) {
		try {
			PreparedStatement statement = this.conexao.prepareStatement("INSERT INTO livros (id, titulo, isbn, autor) VALUES (?,?,?,?) ");
			statement.setLong(1, livro.getId());
			statement.setString(2, livro.getTitulo());
			statement.setString(3, livro.getIsbn());
			statement.setString(4, livro.getAutor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public Livro atualizarLivro(Livro livro) {
		try {
			PreparedStatement statement = this.conexao.prepareStatement("UPDATE livros SET titulo = ?, isbn = ?, autor = ? WHERE id = ?");
			statement.setString(1, livro.getTitulo());
			statement.setString(2, livro.getIsbn());
			statement.setString(3, livro.getAutor());
			statement.setLong(4, livro.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public void removerLivro(Long id) {
		try {
			PreparedStatement statement = this.conexao.prepareStatement("DELETE FROM livros WHERE id = ?");
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
