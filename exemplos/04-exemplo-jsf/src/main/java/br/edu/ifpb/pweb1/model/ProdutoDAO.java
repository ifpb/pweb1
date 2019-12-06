package br.edu.ifpb.pweb1.model;

import java.util.List;
import java.util.Optional;

import br.edu.ifpb.pweb1.entidades.Produto;

public interface ProdutoDAO {
	public Optional<Produto> listarPorId(Long id) throws Exception;
	
	public List<Produto> listarProdutos() throws Exception;
	
	public void adicionarProduto(Produto produto) throws Exception;
	
	public void removerProduto(Produto produto) throws Exception;
}
