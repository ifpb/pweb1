package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import modelo.conexao.ConnectionFactory;

public class LivroDAOClasse implements LivroDAO {

	private List<Livro> livros = new ArrayList();
	
	public LivroDAOClasse() {
		livros.add(new Livro(1, "Livro 1", "ABC", "José da Silva"));
		livros.add(new Livro(2, "Anjos e demônios", "SDASDASDS", "Dan Brown"));
		livros.add(new Livro(3, "Livro 3", "ABC", "José de Almeida"));
	}
	
	public List<Livro> listarLivros() {
		return livros;
	}

	public List<String> recuperarISBNs() {
		return livros.stream().map( (livro) -> livro.getIsbn()).collect(Collectors.toList());
	}

	public List<String> recuperarISBNs(String autor) {
		return livros.stream().filter( (livro) -> livro.getAutor().equals(autor)).map( (livro) -> livro.getIsbn()).collect(Collectors.toList());
	}

	public List<Livro> buscarPorAutor(String autor) {
		return livros.stream().filter( (livro) -> livro.getAutor().equals(autor) ).collect(Collectors.toList());
	}

	public Optional<Livro> recuperarPorId(Long id) {
		return livros.stream().filter( (livro) -> livro.getId().equals(id) ).findFirst();
	}

	public Livro criarLivro(Livro livro) {
		livros.add(livro);
		return livro;
	}

	public Livro atualizarLivro(Livro livroAtualizado) {
		livros = livros.stream().map( (livro) ->  {
			if (livro.getId().equals(livroAtualizado.getId())) {
				return livroAtualizado;
			} else {
				return livro;
			}
		}).collect(Collectors.toList());
		return livroAtualizado;
	}

	public void removerLivro(Long id) {
		livros = livros.stream().filter( livro -> !livro.getId().equals(id)).collect(Collectors.toList());
	}
	
}
