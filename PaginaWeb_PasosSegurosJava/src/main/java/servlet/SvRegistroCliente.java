package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import logica.Cliente;
import logica.ControladoraLogica;
import logica.Usuario;


/**
 *
 * @author kmilo
 */
@WebServlet(name = "SvRegistroCliente", urlPatterns = {"/SvRegistroCliente"})
public class SvRegistroCliente extends HttpServlet {

    ControladoraLogica control = new ControladoraLogica();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Tomamos los datos del formulario y lo guardamos
        String nombreUsu = request.getParameter("nombreUsuario");
        String apellidosUsu = request.getParameter("apellidosUsuario");
        String fechaNaci = request.getParameter("fechaNacimiento");
        String telefonoUsu = request.getParameter("telefonoUsuario");
        String emailUsu = request.getParameter("emailUsuario");
        String passwordUsu = request.getParameter("passwordUsuario");
        
        //parseamos la fecha ya que al recolectarse del formulario esta en String
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaNacimiento = null;
        
        try {
            fechaNacimiento = formato.parse(fechaNaci);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Se crea un usuario
        Usuario usu = new Usuario();
        usu.setNombreUsuario(emailUsu); // Asignar el email como nombre de usuario
        usu.setPassword(passwordUsu); 
        
        //Se Crea el cliente
        Cliente cliente = new Cliente();
        cliente.setNombrePersona(nombreUsu);
        cliente.setApellidosPersona(apellidosUsu);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setTelefonoPersona(telefonoUsu);
        cliente.setCorreoElectronico(emailUsu);
        cliente.setPassword(passwordUsu);
        cliente.setUsuario(usu);
        
        //Persistir el cliente y el usuario
        control.crearCliente(cliente);
        
        response.sendRedirect("RegistroCliente.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
