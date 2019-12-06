package br.edu.ifpb.pweb1.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifpb.pweb1.entidades.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {

	private Conexao conexao;

	public ProdutoDAOImpl() throws SQLException {
		this.conexao = new Conexao();
	}

	public Optional<Produto> listarPorId(Long id) throws Exception {
		this.conexao.conectar();
		String query = "SELECT * FROM produto WHERE id = ?";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setLong(1, id);
		ResultSet result = statement.executeQuery();
		Produto produto = null;
		while (result.next()) {
			produto = new Produto();
			produto.setDescricao(result.getString("descricao"));
			produto.setId(result.getLong("id"));
			produto.setNome(result.getString("nome"));
			produto.setPreco(result.getFloat("preco"));
		}
		this.conexao.desconectar();
		return Optional.ofNullable(produto);
	}

	public List<Produto> listarProdutos() throws Exception {
		this.conexao.conectar();
		String query = "SELECT * FROM produto";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		ResultSet result = statement.executeQuery();
		List<Produto> produtos = new ArrayList<>();
		while (result.next()) {
			Produto produto = new Produto();
			produto.setDescricao(result.getString("descricao"));
			produto.setId(result.getLong("id"));
			produto.setNome(result.getString("nome"));
			produto.setPreco(result.getFloat("preco"));
			produtos.add(produto);
		}
		this.conexao.desconectar();
		return produtos;
	}

	public void adicionarProduto(Produto produto) throws Exception {
		this.conexao.conectar();
		String query = "INSERT INTO produto (nome, descricao, preco) VALUES (?, ?, ?)";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setString(1, produto.getNome());
		statement.setString(2, produto.getDescricao());
		statement.setDouble(3, produto.getPreco());
		statement.executeUpdate();
		this.conexao.desconectar();
	}

	public void removerProduto(Produto produto) throws Exception {
		this.conexao.conectar();
		String query = "DELETE FROM produto WHERE id = ?";
		PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
		statement.setLong(1, produto.getId());
		statement.executeUpdate();
		this.conexao.desconectar();
	}

}
