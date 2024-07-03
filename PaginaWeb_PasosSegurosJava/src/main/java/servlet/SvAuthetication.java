package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Validator;
import logica.Cliente;
import logica.ControladoraLogica;
import org.owasp.encoder.Encode;

/**
 *
 * @author kmilo
 */
@WebServlet(name = "SvAuthetication", urlPatterns = {"/SvAuthetication"})
public class SvAuthetication extends HttpServlet {

    private ControladoraLogica control = new ControladoraLogica();
    
    @Inject
    private Validator validator;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logout = request.getParameter("logout");
        
        if("true".equals(logout)){
            //Codigo para cerrar Sesion del Usuario
            HttpSession miSession = request.getSession(false);
            //condicion para verificar si la sesion se abierta, si es false se cerrarar la sesion
            if(miSession != null){
                miSession.invalidate();
            }
            response.sendRedirect("indexHome.jsp");
        } else{
            response.sendRedirect("indexHome.jsp");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Se guardan los datos del formulario que envia el usuario y se Sanean
        String correoElectronico = request.getParameter("correoElectronico");
        String password = request.getParameter("password");
        
        if(correoElectronico == null || password == null ||
                correoElectronico.trim().isEmpty() || password.trim().isEmpty()){
            
            request.setAttribute("error", "Correo electrónico y/o contraseña no pueden estar vacíos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("indexHome.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        String saneoCorreoElectronico = Encode.forHtml(correoElectronico.trim());
        String saneoPassword = Encode.forHtml(password.trim());
        
  
        //Se crea una variable para guardar el resultado de control de logica donde se verifica los parametros coinsiden
        boolean autenticacion = control.autenticarUsuario(saneoCorreoElectronico,saneoPassword);
        
        
        //Este if indica que si autenticacion es true, se va acrear una sesion con el correo del usuario y lo va a redirigir a la pagina inicio
        if(autenticacion){
            
            Cliente cliente = control.obtenerClienteAutenticado(saneoCorreoElectronico);
            
            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("usuario", cliente);
            response.sendRedirect("indexHome.jsp");
        } else {
            //de lo contrario si es false, va a responder con un mesaje de error en la pagina de inicio
            request.setAttribute("error", "El correo electronico y/o la contraseña son incorrectos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("inicioSesion.jsp");
            dispatcher.forward(request, response);
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Servlet de autenticación de usuarios";
    }// </editor-fold>

}
