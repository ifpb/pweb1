package br.com.edu.ifpb.pweb1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foto")
public class FotoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
		File file = new File("/Users/diegopessoa/uploads/"+nome);
		
		if (file.exists()) {
			if (nome.contains(".jpg")) {
				resp.setContentType("image/jpg");
			} else if (nome.contains(".png")) {
				resp.setContentType("image/png");
			}
			resp.getOutputStream().write(Files.readAllBytes(file.toPath()));
		} else {
			resp.sendError(400);
		}
		
	}
	
}
