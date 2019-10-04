import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String nome = req.getParameter("nome");
		String profissao = req.getParameter("profissao");
		String alertaChato = req.getParameter("alertaChato");
		
		if (alertaChato != null) {
			resp.getOutputStream().println("<script type='text/javascript'>window.alert('alerta chato');</script>");
		}
		
		resp.getOutputStream().println("<h1>Olá, "+ nome+"</h1>");
		resp.getOutputStream().println("<h2>Sua profissão é: "+ profissao+"</h2>");
		
		resp.setContentType("text/html");
		
	}

}
