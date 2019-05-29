package filtros;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(
//        urlPatterns = {"/*"},
//        filterName = "TipoRespostaHtmlFilter",
//        dispatcherTypes = DispatcherType.REQUEST)
public class TipoRespostaHtmlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Filtro TipoRespostaHtml chamado");

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Content-type", "text/html");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
