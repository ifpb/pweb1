package br.com.edu.ifpb.pweb1.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		if (login.equals("admin") && senha.equals("admin")) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", login);
			resp.sendRedirect("inicial.jsp");
		} else {
			resp.sendError(401);
		}
		
	}
	
}
