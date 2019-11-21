package br.com.edu.ifpb.pweb1.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AutenticacaoFilter", urlPatterns = "/restrito/*")
public class AutenticaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		String usuarioLogado = (String) session.getAttribute("usuarioLogado");
//		String paginaAtual = httpRequest.getPathInfo();
		if (usuarioLogado == null) {
			//nao está logado, deve redirecionar
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("../index.jsp");
		} else {
			//está logado, deve continuar o caminho normal.
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
