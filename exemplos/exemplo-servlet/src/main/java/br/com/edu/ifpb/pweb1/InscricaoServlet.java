package br.com.edu.ifpb.pweb1;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.text.DefaultEditorKit.CopyAction;

import br.com.edu.ifpb.pweb1.model.Participante;

@WebServlet("/inscricao")
@MultipartConfig(
		location = "/tmp",
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 15
		)
public class InscricaoServlet extends HttpServlet {

	private void processarEnvioDeArquivo(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Part part = req.getPart("foto");
		if (!part.getContentType().equals("image/jpeg") && !part.getContentType().equals("image/jpg") &&
				!part.getContentType().contentEquals("image/png")) {
			throw new ServletException("arquivo inválido");
		}
		
		Path path = new File("/Users/diegopessoa/uploads/"+part.getSubmittedFileName()).toPath();
		
		Files.copy(part.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processarEnvioDeArquivo(req, resp);
		
		String inscricoesAbertas = getInitParameter("inscricoesAbertas");
		
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
