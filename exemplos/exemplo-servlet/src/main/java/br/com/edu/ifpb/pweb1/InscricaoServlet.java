package br.com.edu.ifpb.pweb1;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.edu.ifpb.pweb1.model.Participante;

@WebServlet("/inscricao")
public class InscricaoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inscricoesAbertas = req.getServletContext().getInitParameter("inscricoesAbertas");
		
		if (inscricoesAbertas.equals("sim")) {
			String nome = req.getParameter("nome");
			String email = req.getParameter("email");
			String estado = req.getParameter("estado");

			Participante participante = new Participante(nome, email, estado);

			req.setAttribute("participante", participante);
			req.getRequestDispatcher("confirmacao.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("inscricoesFechadas.jsp");
		}
	}

}
