package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Integer sessoesAtivas = 1;
        if (se.getSession().getServletContext().getAttribute("sessoesAtivas") == null) {
            se.getSession().getServletContext().setAttribute("sessoesAtivas", 1);
        } else {
            sessoesAtivas = (Integer) se.getSession().getServletContext().getAttribute("sessoesAtivas");
        }
        se.getSession().getServletContext().setAttribute("sessoesAtivas", sessoesAtivas+1);
        System.out.println("SESSÃO CRIADA COM ID = "+se.getSession().getId());
        System.out.println("SESSÕES ATIVAS = "+sessoesAtivas);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Integer sessoesAtivas = (Integer) se.getSession().getServletContext().getAttribute("sessoesAtivas");
        se.getSession().getServletContext().setAttribute("sessoesAtivas", sessoesAtivas-1);
        System.out.println("SESSÃO REMOVIDA DO ID = "+se.getSession().getId());
        System.out.println("SESSÕES ATIVAS = "+sessoesAtivas);
    }
}
