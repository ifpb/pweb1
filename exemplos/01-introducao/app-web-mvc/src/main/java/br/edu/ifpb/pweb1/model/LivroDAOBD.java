package br.edu.ifpb.pweb1.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAOBD implements LivroDAO {

	private Conexao conexao;

	public LivroDAOBD() throws SQLException {
		this.conexao = new Conexao();
	}

	public Optional<Livro> listarPorId(Long id) throws Exception {
		this.conexao.conectar();
		String query = "SELECT * FROM livro WHERE id = ?";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setLong(1, id);
		ResultSet result = statement.executeQuery();
		Livro livro = null;
		while (result.next()) {
			livro = new Livro();
			livro.setAutor(result.getString("autor"));
			livro.setDescricao(result.getString("descricao"));
			livro.setIsbn(result.getString("isbn"));
			livro.setTitulo(result.getString("titulo"));
			livro.setId(result.getLong("id"));
		}
		this.conexao.desconectar();
		return Optional.ofNullable(livro);
	}

	public Optional<Livro> listarPorIsbn(String isbn) throws Exception {
		this.conexao.conectar();
		String query = "SELECT * FROM livro WHERE isbn = ?";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setString(1, isbn);
		ResultSet result = statement.executeQuery();
		Livro livro = null;
		while (result.next()) {
			livro = new Livro();
			livro.setAutor(result.getString("autor"));
			livro.setDescricao(result.getString("descricao"));
			livro.setIsbn(result.getString("isbn"));
			livro.setTitulo(result.getString("titulo"));
			livro.setId(result.getLong("id"));
		}
		this.conexao.desconectar();
		return Optional.ofNullable(livro);
	}

	public List<Livro> listarPorAutor(String autor) throws Exception {
		this.conexao.conectar();
		String query = "SELECT * FROM livro WHERE autor LIKE ?";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setString(1, "%" + autor + "%");
		ResultSet result = statement.executeQuery();
		List<Livro> livros = new ArrayList<>();
		while (result.next()) {
			Livro livro = new Livro();
			livro.setAutor(result.getString("autor"));
			livro.setDescricao(result.getString("descricao"));
			livro.setIsbn(result.getString("isbn"));
			livro.setTitulo(result.getString("titulo"));
			livro.setId(result.getLong("id"));
			livros.add(livro);
		}
		this.conexao.desconectar();
		return livros;
	}

	public List<String> listarAutores() throws Exception {
		this.conexao.conectar();
		String query = "SELECT autor FROM livro";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<String> autores = new ArrayList<>();
		while (result.next()) {
			autores.add(result.getString("autor"));
		}
		this.conexao.desconectar();
		return autores;
	}

	public List<Livro> listarLivros() throws Exception {
		this.conexao.conectar();
		String query = "SELECT * FROM livro";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<Livro> livros = new ArrayList<>();
		while (result.next()) {
			Livro livro = new Livro();
			livro.setAutor(result.getString("autor"));
			livro.setDescricao(result.getString("descricao"));
			livro.setIsbn(result.getString("isbn"));
			livro.setTitulo(result.getString("titulo"));
			livro.setId(result.getLong("id"));
			livros.add(livro);
		}
		this.conexao.desconectar();
		return livros;
	}

	public void adicionarLivro(Livro livro) throws Exception {
		this.conexao.conectar();
		String query = "INSERT INTO livro (autor, descricao, isbn, titulo) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setString(1, livro.getAutor());
		statement.setString(2, livro.getDescricao());
		statement.setString(3, livro.getIsbn());
		statement.setString(4, livro.getTitulo());
		statement.executeUpdate();
		this.conexao.desconectar();
	}

	public void removerLivro(Livro livro) throws Exception {
		this.conexao.conectar();
		String query = "DELETE FROM livro WHERE id = ?";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setLong(1, livro.getId());
		statement.executeUpdate();
		this.conexao.desconectar();
	}

}
