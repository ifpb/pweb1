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

@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Long inicio = System.currentTimeMillis();
		chain.doFilter(request, response);
		Long fim = System.currentTimeMillis();
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		double tempoRequisicao = (fim - inicio) / 1000.00;
		httpRequest.getServletContext().log("Requisição para "+httpRequest.getContextPath()+ " levou "+tempoRequisicao+" segundos");
	}

	@Override
	public void destroy() {
	}

}
