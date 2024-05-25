package logica;

import persistencia.ControladoraPersistencia;

/**
 *
 * @author kmilo
 */
public class ControladoraLogica {
 
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearCliente(Cliente cliente){
        // Crear el usuario para el cliente
        Usuario usu = new Usuario();
        usu.setNombreUsuario(cliente.getCorreoElectronico());// Se usa el correo como nombre de usuario
        usu.setPassword(cliente.getPassword()); //La contraseña del usuario es la misma que la del cliente
        
        
        cliente.setUsuario(usu);
        controlPersis.crearCliente(cliente);
    }
    
}
