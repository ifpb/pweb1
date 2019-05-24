package br.edu.ifpb.model.dao;

import br.edu.ifpb.model.conexao.ConnectionFactory;
import br.edu.ifpb.model.entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO {


	private Connection conexao;

	public UsuarioDAO() {
		ConnectionFactory factory = new ConnectionFactory();
		this.conexao = factory.getConnection();
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList();
		try {
			Statement statement = this.conexao.createStatement();
			statement.execute("SELECT * FROM usuarios");
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setDataNascimento(resultSet.getDate("dataNascimento"));
				usuario.setGenero(Usuario.Genero.valueOf(resultSet.getString("genero")));
				usuario.setPais(resultSet.getString("pais"));
				usuario.setPrimeiroNome(resultSet.getString("primeiroNome"));
				usuario.setUltimoNome(resultSet.getString("ultimoNome"));
				usuario.setId(resultSet.getLong("id"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setSenha(resultSet.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Optional<Usuario> recuperarPorId(Long id) {
		Optional<Usuario> usuarioOptional = Optional.empty();
		try {
			PreparedStatement statement = this.conexao.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setDataNascimento(resultSet.getDate("dataNascimento"));
				usuario.setGenero(Usuario.Genero.valueOf(resultSet.getString("genero")));
				usuario.setPais(resultSet.getString("pais"));
				usuario.setPrimeiroNome(resultSet.getString("primeiroNome"));
				usuario.setUltimoNome(resultSet.getString("ultimoNome"));
				usuario.setId(resultSet.getLong("id"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setSenha(resultSet.getString("senha"));
				usuarioOptional = usuarioOptional.of(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioOptional;
	}

	public void criarUsuario(Usuario usuario) throws SQLException {
		PreparedStatement statement = this.conexao.prepareStatement("INSERT INTO usuarios (primeiroNome, ultimoNome, datanascimento, genero, telefone, senha, email, cidade, pais) VALUES (?,?,?,?,?,?,?,?,?) ");
		statement.setString(1, usuario.getPrimeiroNome());
		statement.setString(2, usuario.getUltimoNome());
		statement.setDate(3, usuario.getDataNascimento());
		statement.setString(4, usuario.getGenero().toString());
		statement.setString(5, usuario.getTelefone());
		statement.setString(6, usuario.getSenha());
		statement.setString(7, usuario.getEmail());
		statement.setString(8, usuario.getCidade());
		statement.setString(9, usuario.getPais());
		statement.executeUpdate();
	}

}
