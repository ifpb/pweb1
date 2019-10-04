package br.edu.ifpb.pweb1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb1.model.Livro;
import br.edu.ifpb.pweb1.model.LivroDAO;

@WebServlet("/livros")
public class LivrosController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LivroDAO livroDAO = new LivroDAO();
		List<Livro> livros = livroDAO.listarLivros();
		req.setAttribute("livros", livros);
		req.getRequestDispatcher("livros.jsp").forward(req, resp);
	
	}
	
}
