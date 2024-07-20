package logica;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author kmilo
 */
public class ControladoraLogica {
 
    //Se instancia a la controladoraPersistencia para ingresar a los atributos de JPAController
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();
   
    
    //Se crea una Lista para guardar todos los clientes 
    public List<Cliente> getClientes(){
        return controlPersis.getClientes();
    }
    
    
    //Metodo para crear un cliente y asociarlo a un usuario
    public void crearCliente(Cliente cliente){
        
        
        // Crear el usuario para el cliente
        Usuario usu = new Usuario();
        usu.setCorreoElectronico(cliente.getCorreoElectronico());// Se usa el correo como nombre de usuario
        usu.setPassword(cliente.getPassword()); //La contraseña del usuario es la misma que la del cliente

        
        
        //Se asocia el cliente con el Usuario
        cliente.setUsuario(usu);
        
        //se le asigna una foto de perfil predeterminada
        if (cliente.getFotoPerfil() == null || cliente.getFotoPerfil().isEmpty()) {
            cliente.setFotoPerfil("/img/foto_predeterminada.jpg");
        }
        
        controlPersis.crearCliente(cliente);//Se ingresa al controlPersistencia para ingrear al metodo create
    }

    //Se crea una lista para guardar todos los usuarios que retorne ControlPersitencia
    public List<Usuario> getUsuarios(){
    
        return controlPersis.getUsuarios();
    }    
    
  
    //Metodo de Autenticacion donde recibe dos parametros
    public boolean autenticarUsuario(String correoElectronico, String password) {
        
        //Se obtiene lista de usuarios donde ingresa a la controladora de Persistencia
        List<Usuario> listaUsuarios = controlPersis.getUsuarios();
        
       // Buscar el usuario por correo electrónico y verificar la contraseña
       return listaUsuarios.stream()
               .filter(usu -> usu.getCorreoElectronico().equals(correoElectronico))
               .anyMatch(usu -> BCrypt.checkpw(password, usu.getPassword()));
    }
    
    
    public Cliente obtenerClienteAutenticado(String correoElectronico){
        
        //Se recupera todos los clientes
        List<Cliente> listaClientes = controlPersis.getClientes();
        
        // Buscar el cliente que coincida con el correo electrónico
        return listaClientes.stream()
                .filter(cl -> cl.getCorreoElectronico().equals(correoElectronico))
                .findFirst()
                .orElse(null); // Si no se encuentra un cliente que coincida, devolver null
                
    }
    
    //metodo para editar informacion cliente 
    public void editarCliente(Cliente cliente) throws Exception{
        controlPersis.editCliente(cliente);
    }
}
