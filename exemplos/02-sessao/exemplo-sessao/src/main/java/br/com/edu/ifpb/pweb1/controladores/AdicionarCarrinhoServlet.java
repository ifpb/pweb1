package br.com.edu.ifpb.pweb1.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.edu.ifpb.pweb1.dao.ProdutosDAO;
import br.com.edu.ifpb.pweb1.entidades.Produto;

@WebServlet("/adicionarCarrinho")
public class AdicionarCarrinhoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		ProdutosDAO produtosDAO = new ProdutosDAO();
		Produto produto = produtosDAO.recuperaPorId(id).orElseThrow(() -> new ServletException());
		List<Produto> produtosCarrinho = (List<Produto>) req.getSession().getAttribute("produtosCarrinho");
		if (produtosCarrinho == null) {
			produtosCarrinho = new ArrayList();
		}
		produtosCarrinho.add(produto);
		req.getSession().setAttribute("produtosCarrinho", produtosCarrinho);
		resp.sendRedirect("carrinho.jsp");
	}
	
}
