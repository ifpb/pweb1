package includes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pagina")
public class PaginaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setHeader("Content-type", "text/html");
        resp.getOutputStream().println("<html>");
        resp.getOutputStream().println("<head>");
        resp.getOutputStream().println("<title>Página teste</title>");
        resp.getOutputStream().println("</head>");
        resp.getOutputStream().println("<body>");
        req.getRequestDispatcher("conteudoprincipal").include(req, resp);
        resp.getOutputStream().println("</body>");
        resp.getOutputStream().println("</html>");


    }
}
