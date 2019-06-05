import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exemplo")
public class ServletExemplo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] paises = { "Brasil", "Argentina", "Itália", "Alemanha", "Haiti"};
        req.setAttribute("paises", paises);
        req.getSession().setAttribute("tipoUsuario", "Administrador");
        req.getRequestDispatcher("jstl-exemplo.jsp").forward(req, resp);
    }
}
