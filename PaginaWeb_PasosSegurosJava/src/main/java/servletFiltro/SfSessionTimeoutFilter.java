package servletFiltro;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 *
 * @author kmilo
 */
public class SfSessionTimeoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
        
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) 
            throws IOException, ServletException {
       
        //Se instancia el httpServlet Resp y Req 
        HttpServletRequest httpRequest = (HttpServletRequest) sr;
        HttpServletResponse httpResponse = (HttpServletResponse) sr1;
        
        //Se crea una variable session false
        HttpSession session = httpRequest.getSession(false);
        
        
        
        //La condicional indica que si la session se cierra o es null se va a dirigir a la pagina inicial
        if(session == null || session.getAttribute("usuario") == null){
            //Si la session es invalida, se redirigira a indexHome
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/inicioSesion.jsp");
        } else {
            // de lo contrario, si es valida continua con el request "sr"
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {
        
    }

}
