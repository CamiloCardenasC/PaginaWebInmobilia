package servlet;


import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.UUID;
import logica.Cliente;
import logica.ControladoraLogica;

/**
 *
 * @author kmilo
 */
@MultipartConfig
@WebServlet(name = "SvPerfilUsuario", urlPatterns = {"/SvPerfilUsuario"})
public class SvPerfilUsuario extends HttpServlet {
    
    private ControladoraLogica control = new ControladoraLogica();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
            HttpSession sessionCliente = (HttpSession) request.getSession();
            Cliente cliente = (Cliente) sessionCliente.getAttribute("usuario");
            
            if(cliente != null){
                // Nombre del archivo de la foto
                String fotoPerfilCliente = cliente.getFotoPerfil();

                if (fotoPerfilCliente != null) {
                    // Configurar la ruta de la imagen
                    String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
                    File file = new File(uploadPath + File.separator + fotoPerfilCliente);

                    if (file.exists()) {
                        // Configurar la respuesta HTTP para enviar la imagen
                        response.setContentType("image/jpeg"); // Cambia el tipo de contenido según el tipo de imagen
                        response.setContentLengthLong(file.length());

                        // Leer el archivo y escribirlo en la respuesta
                        try(FileInputStream inputStream = new FileInputStream(file);
                                OutputStream outputStream = response.getOutputStream()){
                            byte[] buffer =  new byte[1024];
                            int bytesRead;
                            while((bytesRead = inputStream.read(buffer)) != -1){
                                outputStream.write(buffer, 0, bytesRead);
                            }

                        }
                    } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // Imagen no encontrada
                    }
                } else{
                    response.sendError(HttpServletResponse.SC_NOT_FOUND); // Foto de perfil no configurada
                }
            } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // Cliente no encontrado
                }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            //Obtenemos el archivo de la foto de perfil
            Part filePart = request.getPart("fotoPerfil");
            String fileName = null;
            if (filePart != null && filePart.getSize() > 0) {
                // Generar un nombre de archivo único
                String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                String fileExtension = "";
                int i = originalFileName.lastIndexOf('.');
                if (i > 0) {
                    fileExtension = originalFileName.substring(i);
                }
                fileName = UUID.randomUUID().toString() + fileExtension;
                
                String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdir();
                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);
            }

            //Obtenemos los datos que vamos actualizar
            String nombreCl = request.getParameter("nombreCliente");
            String apellidosCl = request.getParameter("apellidosCliente");
            String telefonoCl = request.getParameter("telefonoCliente");
            String facebookCl = request.getParameter("facebook");
            String twitterCl = request.getParameter("twitter");
            String correoPubliCl = request.getParameter("p-email");
            String telefonoPubliCl = request.getParameter("telefonoCliente");

            
            //obtenemos el cliente de la sesion
            HttpSession sessionCliente = (HttpSession) request.getSession();
            Cliente cliente = (Cliente) sessionCliente.getAttribute("usuario");
            
            
            if (cliente != null) {
                
                // Actualizar los datos del cliente solo si se han proporcionado
                if (fileName != null) {
                    cliente.setFotoPerfil(fileName);
                }
                if (nombreCl != null && !nombreCl.trim().isEmpty()) {
                    cliente.setNombrePersona(nombreCl);
                }
                if (apellidosCl != null && !apellidosCl.trim().isEmpty()) {
                    cliente.setApellidosPersona(apellidosCl);
                }
                if (telefonoCl != null && !telefonoCl.trim().isEmpty()) {
                    cliente.setTelefonoPersona(telefonoCl);
                }
                if (facebookCl != null && !facebookCl.trim().isEmpty()) {
                    cliente.setFacebook(facebookCl);
                }
                if (twitterCl != null && !twitterCl.trim().isEmpty()) {
                    cliente.setTwitter(twitterCl);
                }
                if (correoPubliCl != null && !correoPubliCl.trim().isEmpty()) {
                    cliente.setCorreoPublico(correoPubliCl);
                }
                if (telefonoPubliCl != null && !telefonoPubliCl.trim().isEmpty()) {
                    cliente.setTelefonoPublico(telefonoPubliCl);
                }
                
                
                //Llamamos a la controladora logica para actulizar datos
                control.editarCliente(cliente);
                
                //Actualizamos el cliente de la session
                sessionCliente.setAttribute("usuario", cliente);
                
                response.sendRedirect("perfilUsuario.jsp");
                
            } else{
                // Cliente no encontrado, redirigir con un mensaje de error
                response.sendRedirect("indexHome.jsp");
                
            }
        } catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("error404.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
