package br.edu.ifpb.control;

import br.edu.ifpb.model.dao.UsuarioDAO;
import br.edu.ifpb.model.entidades.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/cadastrar")
public class CadastroServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuario = new Usuario();
        usuario.setCidade(req.getParameter("cidade"));
        usuario.setEmail(req.getParameter("email"));
        usuario.setDataNascimento(Date.valueOf(req.getParameter("nascimento")));
        usuario.setGenero(Usuario.Genero.valueOf(req.getParameter("genero").toUpperCase()));
        usuario.setPais(req.getParameter("pais"));
        usuario.setPrimeiroNome(req.getParameter("primeiroNome"));
        usuario.setUltimoNome(req.getParameter("ultimoNome"));
        usuario.setTelefone(req.getParameter("telefone"));
        usuario.setSenha(req.getParameter("senha"));

        try {
            usuarioDAO.criarUsuario(usuario);
            resp.setHeader("Content-type", "text/html");
            resp.getOutputStream().println("<h1>Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendError(400);
        }


    }
}
