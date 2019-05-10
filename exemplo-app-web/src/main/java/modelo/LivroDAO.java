package modelo;

import java.util.List;
import java.util.Optional;

public interface LivroDAO {

	public List<String> recuperarISBNs();

	public List<String> recuperarISBNs(String autor);

	public List<Livro> buscarPorAutor(String autor);
	
	public List<Livro> listarLivros();
	 
	public Optional<Livro> recuperarPorId(Long id);
	
	public Livro criarLivro(Livro livro);
	
	public Livro atualizarLivro(Livro livro);
	
	public void removerLivro(Long id);
	
}
