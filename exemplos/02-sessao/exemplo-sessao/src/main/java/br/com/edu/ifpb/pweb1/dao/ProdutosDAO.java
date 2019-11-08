package br.com.edu.ifpb.pweb1.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import br.com.edu.ifpb.pweb1.entidades.Produto;

public class ProdutosDAO {
	
	public List<Produto> listarProdutos() {
		Produto produto1 = new Produto(1l, "Pincel de quadro cor preta", 5.00f);
		Produto produto2 = new Produto(2l, "Pincel de quadro cor azul", 3.00f);
		Produto produto3 = new Produto(3l, "Pincel de quadro cor vermelha", 7.00f);
		Produto produto4 = new Produto(4l, "Água mineral", 2.00f);
		Produto produto5 = new Produto(5l, "Água com gás", 2.50f);
		Produto produto6 = new Produto(6l, "Coxinha", 5.00f);
		Produto produto7 = new Produto(7l, "Pastel", 5.00f);
		Produto produto8 = new Produto(8l, "Cuscuz com queijo", 10.00f);
		Produto produto9 = new Produto(9l, "Misto quente de Jean", 3.00f);
		
		return Arrays.asList(produto1,produto2,produto3,produto4,produto5,
				produto6,produto7,produto8,produto9);
	}
	
	public Optional<Produto> recuperaPorId(Long id) {
		return listarProdutos().stream().filter( produto -> produto.getId().equals(id)).findFirst();
	}

}
