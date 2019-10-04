package br.edu.ifpb.pweb1.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LivroDAO {
	
	private List<Livro> livros = Arrays.asList(
			new Livro(1l, "Harry Potter e Pedra Filosofal", "J.K. Rowling", "23112311232", "Livro de maior sucesso de J.K. Rowling"),
			new Livro(2l, "Senhor dos Anéis", "J.R.R. Tolkien", "12312312", "Livro de 5000 páginas"),
			new Livro(3l, "Ponto de Impacto", "Dan Brown", "231321321", "Livro mais fraco de Dan Brown")
			);

	public Optional<Livro> listarPorId(Long id) {
		return livros.stream().filter( livro -> livro.getId().equals(id)).findFirst();
	}
	
	public Optional<Livro> listarPorIsbn(String isbn) {
		return livros.stream().filter(livro -> livro.getIsbn().equals(isbn)).findFirst();
	}
	
	public List<String> listarAutores() {
		return livros.stream().map(Livro::getAutor).collect(Collectors.toList());
	}
	
	public List<Livro> listarLivros() {
		return livros;
	}
	
	public void adicionarLivro(Livro livro) { 
		this.livros.add(livro);
	}
	
	public void removerLivro(Livro livro) {
		this.livros.remove(livro);
	}
	
}
