package filtros;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

@WebFilter(
        urlPatterns = "/*",
        filterName = "LogFilter"
)
public class LogFilter implements Filter {

    File arquivoLog;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        arquivoLog = new File("/tmp/filtro.log");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        System.out.println("Logfilter chamado");

        HttpServletRequest httpRequest = (HttpServletRequest)request;

        String linha = String.format("Endereco=%s,Data=%s\n",httpRequest.getRequestURI(), ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY-HH:mm:ss")));

        try (FileOutputStream os = new FileOutputStream(arquivoLog, true)) {
            os.write(linha.getBytes());
        }
    }

    @Override
    public void destroy() {
        arquivoLog.delete();
    }
}
