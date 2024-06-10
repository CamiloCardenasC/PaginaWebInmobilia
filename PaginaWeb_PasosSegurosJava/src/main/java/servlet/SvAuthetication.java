package servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.ControladoraLogica;

/**
 *
 * @author kmilo
 */
@WebServlet(name = "SvAuthetication", urlPatterns = {"/SvAuthetication"})
public class SvAuthetication extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession miSession = request.getSession(false);
        
        if(miSession != null){
            miSession.invalidate();
        }
        response.sendRedirect("indexHome.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Se guardan los datos del formulario que envia el usuario
        String correoElectronico = request.getParameter("correoElectronico");
        String password = request.getParameter("password");
        
        //Se crea una variable booleana para guaradar 
        boolean autenticacion = control.autenticarUsuario(correoElectronico,password);
        
        
        
        if(autenticacion){
            HttpSession miSession = request.getSession(true);
            miSession.setAttribute("correoElectronico", correoElectronico);
            response.sendRedirect("indexHome.jsp");
        } else {
            
            request.setAttribute("error", "El correo electronico y/o la contraseña son incorrectos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("inicioSesion.jsp");
            dispatcher.forward(request, response);
        }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
