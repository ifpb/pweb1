import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer numeroMaximoRequisicoes = Integer.parseInt(req.getServletContext().getInitParameter("numeroMaximoAcessos"));
        Integer totalRequisicoes = 0;

        if (req.getSession(true).getAttribute("totalRequisicoes") == null) {
            req.getSession().setAttribute("totalRequisicoes", 0);
        } else {
            totalRequisicoes = (Integer) req.getSession(true).getAttribute("totalRequisicoes");
        }

        resp.setHeader("Content-type", "text/html");

        if (totalRequisicoes <= numeroMaximoRequisicoes) {
            resp.getOutputStream().println("<h1>Acesso "+totalRequisicoes+" Liberado</h1>");
        } else {
            resp.getOutputStream().println("<h1>Acesso Negado, número máximo de requisições atingido</h1>");
        }

        req.getSession().setAttribute("totalRequisicoes", totalRequisicoes+1);

    }
}
