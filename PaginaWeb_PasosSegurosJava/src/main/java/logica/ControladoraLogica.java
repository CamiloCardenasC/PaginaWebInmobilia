package logica;

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
        usu.setNombreUsuario(cliente.getCorreoElectronico());// Se usa el correo como nombre de usuario
        usu.setPassword(cliente.getPassword()); //La contraseña del usuario es la misma que la del cliente
        
        //Se asocia el cliente con el Usuario
        cliente.setUsuario(usu);
        controlPersis.crearCliente(cliente);//Se ingresa al controlPersistencia para ingrear al metodo create
    }
    
}
