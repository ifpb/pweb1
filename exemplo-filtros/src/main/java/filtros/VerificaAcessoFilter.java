package filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(
//        urlPatterns = "/*",
//        filterName = "VerificaAcessoFilter",
//        dispatcherTypes = DispatcherType.REQUEST,
//        initParams = {@WebInitParam(name = "numeroMaximoAcessos", value = "10")}
//)
public class VerificaAcessoFilter implements Filter {

    Integer numeroMaximoRequisicoes;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        numeroMaximoRequisicoes = Integer.parseInt(filterConfig.getInitParameter("numeroMaximoAcessos"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Filtro VerificaAcessoFilter chamado");

        Integer totalRequisicoes = (Integer) request.getServletContext().getAttribute("totalRequisicoes");

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (totalRequisicoes <= numeroMaximoRequisicoes) {
            chain.doFilter(request, response);
            request.getServletContext().setAttribute("totalRequisicoes", totalRequisicoes+1);
        } else {
            request.getRequestDispatcher("acessonegado").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        numeroMaximoRequisicoes = null;
    }
}
