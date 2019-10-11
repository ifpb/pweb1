package br.edu.ifpb.pweb1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb1.model.Livro;
import br.edu.ifpb.pweb1.model.LivroDAO;

public class LivrosController implements Command {

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		LivroDAO livroDAO = new LivroDAO();
		List<Livro> livros = livroDAO.listarLivros();
		req.setAttribute("livros", livros);
		req.getRequestDispatcher("livros.jsp").forward(req, resp);
	}
	
}
