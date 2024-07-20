package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import logica.Cliente;
import logica.ControladoraLogica;
import logica.Usuario;
import org.apache.commons.io.IOUtils;
import org.mindrot.jbcrypt.BCrypt;


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
        
        //Se encripta la contraseña
        String hashedPassword = BCrypt.hashpw(passwordUsu, BCrypt.gensalt());
        
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
        usu.setCorreoElectronico(emailUsu); // Asignar el email como nombre de usuario
        usu.setPassword(hashedPassword); 
        
        //Se Crea el cliente
        Cliente cliente = new Cliente();
        cliente.setNombrePersona(nombreUsu);
        cliente.setApellidosPersona(apellidosUsu);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setTelefonoPersona(telefonoUsu);
        cliente.setCorreoElectronico(emailUsu);
        cliente.setPassword(hashedPassword);
        cliente.setUsuario(usu);
        
        // Generar un nombre único para la foto predeterminada
        String uniqueFileName = UUID.randomUUID().toString() + "_foto_predeterminada.jpg";

        // Ruta de la foto predeterminada en el sistema de archivos
        String sourcePath = "C:\\Users\\kmilo\\Documents\\PRIMER_PROYECTO_SOFTWARE\\PaginaWeb_PasosSegurosJava\\src\\main\\webapp\\img\\foto_predeterminada.jpg";

        // Ruta de la carpeta donde se guardarán las fotos
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        // Crear la carpeta si no existe
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Copiar la foto predeterminada a la nueva ubicación con un nombre único
        File sourceFile = new File(sourcePath);
        File destFile = new File(uploadPath + File.separator + uniqueFileName);
        try (InputStream inputStream = new FileInputStream(sourceFile)) {
            Files.copy(inputStream, destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServletException("Error al guardar la foto predeterminada", e);
        }

        // Asignar el nombre de archivo de la foto al cliente
        cliente.setFotoPerfil(uniqueFileName);
        
        //Persistir el cliente y el usuario
        control.crearCliente(cliente);
        
        //Se redirije a la pagina de Inicio
        response.sendRedirect("inicioSesion.jsp");
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
