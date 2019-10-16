package br.edu.ifpb.pweb1.model;

import java.util.List;
import java.util.Optional;

public interface LivroDAO {
	public Optional<Livro> listarPorId(Long id) throws Exception;
	
	public Optional<Livro> listarPorIsbn(String isbn) throws Exception;
	
	public List<String> listarAutores() throws Exception;
	
	public List<Livro> listarLivros() throws Exception;
	
	public void adicionarLivro(Livro livro) throws Exception;
	
	public void removerLivro(Livro livro) throws Exception;
	
	public List<Livro> listarPorAutor(String autor) throws Exception;
}
