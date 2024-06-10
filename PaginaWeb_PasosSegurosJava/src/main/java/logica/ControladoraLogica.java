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
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //Metodo para crear un cliente y asociarlo a un usuario
    public void crearCliente(Cliente cliente){
        
        // Crear el usuario para el cliente
        Usuario usu = new Usuario();
        usu.setCorreoElectronico(cliente.getCorreoElectronico());// Se usa el correo como nombre de usuario
        usu.setPassword(cliente.getPassword()); //La contraseña del usuario es la misma que la del cliente
        
        //Se asocia el cliente con el Usuario
        cliente.setUsuario(usu);
        controlPersis.crearCliente(cliente);//Se ingresa al controlPersistencia para ingrear al metodo create
    }

    //Se crea una lista para guardar todos los usuarios que retorne ControlPersitencia
    public List<Usuario> getUsuarios(){
    
        return controlPersis.getUsuarios();
    }    
    
    //Metodo de Autenticacion donde recibe dos parametros
    public boolean autenticarUsuario(String correoElectronico, String password) {
        
        //
        boolean ingreso = false;
        
        //Se obtiene lista de usuarios donde ingresa a la controladora de Persistencia
        List<Usuario> listaUsuarios = controlPersis.getUsuarios();
        
        //Se crea un for each para buscar el usuario por correo electronico
        for(Usuario usu: listaUsuarios){
            
            if (usu.getCorreoElectronico().equals(correoElectronico)) {
                //Se compara la contraseña ingresada con la contraseña encriptada almacenada
                if (BCrypt.checkpw(password, usu.getPassword())) {
                    ingreso = true;
                    break; //Se sale del bucle si se encuentra alguna coincidencia
                }
            }
        }
        return ingreso;
    }
}
