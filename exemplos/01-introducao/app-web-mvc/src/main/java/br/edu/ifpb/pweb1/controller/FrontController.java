package br.edu.ifpb.pweb1.controller;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String nomeComando = req.getRequestURI().split("/")[2];
			nomeComando += "Controller";
			nomeComando = String.valueOf(nomeComando.charAt(0)).toUpperCase() + nomeComando.substring(1, nomeComando.length());
			Command comando = (Command) Class.forName("br.edu.ifpb.pweb1.controller."+nomeComando).newInstance();
			comando.execute(req, resp);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			resp.sendError(404);
		} catch (Exception e) {
			resp.sendError(500);
		}
	}
	
}
