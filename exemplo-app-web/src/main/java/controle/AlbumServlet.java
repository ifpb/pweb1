package controle;

import modelo.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebInitParam;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.ZonedDateTime;
import java.util.List;


@WebServlet(urlPatterns="/albuns",
		initParams = { @WebInitParam(name = "curso", value = "ADS"),
				@WebInitParam(name="disciplina", value="pweb1")} )
@MultipartConfig(
		location = "/tmp",
		maxFileSize = 1024*1024*20, //20MB
		maxRequestSize = 1024*1024*30, // 30MB
		fileSizeThreshold = 1024*1024*40 // 40MB
)

public class AlbumServlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    	//todo: fazer listagem de álbuns
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    	String curso = req.getServletContext().getInitParameter("curso");
    	String disciplina = req.getServletContext().getInitParameter("disciplina");

    	String titulo = req.getParameter("titulo");
    	String autor = req.getParameter("autor");
    	boolean publicado = Boolean.parseBoolean(req.getParameter("publicado"));
		Part filePart = null;
		try {
			filePart = req.getPart("foto");
			if (filePart.getSize()!=0){
				String nomeArquivo =  "/home/luz/Documentos/imagens/foto_" + filePart.getName();
				filePart.write( nomeArquivo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}


		Album album = new Album(titulo, autor, publicado);

    	//todo: fazer upload de arquivo e atribuí-lo ao album
		try {
			String nomeArquivo = ZonedDateTime.now().toInstant().getEpochSecond() + '-' + req.getPart("foto").getSubmittedFileName();
			album.getArquivos().add(nomeArquivo);
			InputStream is = req.getPart("foto").getInputStream();

			Files.copy(is, Paths.get("/Users/diegopessoa/arquivos/"+nomeArquivo));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

		AlbumDAO albumDAO = AlbumDAOClasse.getInstance();
		albumDAO.criarAlbum(album);

		try {
			req.setAttribute("albuns", albumDAO.listarAlbuns());
			req.getRequestDispatcher("albuns.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
