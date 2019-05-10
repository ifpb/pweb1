package controle;

import modelo.Livro;
import modelo.LivroDAO;
import modelo.LivroDAOBD;
import modelo.LivroDAOClasse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/livros-id")
public class LivroPorIdServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
    	LivroDAO livroDAO = new LivroDAOBD();
    	Long id = Long.parseLong(req.getParameter("id"));
    	Livro livro = livroDAO.recuperarPorId(id).orElseThrow( () -> new ServletException("ID não existe"));
    	try {
    		req.setAttribute("livro", livro);
			req.getRequestDispatcher("livro.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
