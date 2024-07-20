package persistencia;

import logica.Cliente;
import logica.Usuario;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author kmilo
 */
@Component
public class ControladoraPersistencia {
    
    //Se instancian todas las Entity Class
    CargoJpaController cargoJPA = new CargoJpaController();
    ClienteJpaController clienJPA = new ClienteJpaController();
    ContratoJpaController contraJPA = new ContratoJpaController();
    EmpleadoJpaController empleJPA = new EmpleadoJpaController();
    EstadoInmuebleJpaController estadoInmuJPA = new EstadoInmuebleJpaController();
    InmobiliariaJpaController inmobiJPA = new InmobiliariaJpaController();
    InmuebleJpaController inmueJPA = new InmuebleJpaController();
    PermisosJpaController permiJPA = new PermisosJpaController();
    PersonaJpaController persoJPA = new PersonaJpaController();
    ReservacionJpaController ReserJPA = new ReservacionJpaController();
    TipoContratoJpaController tipoContraJPA = new TipoContratoJpaController();
    TipoInmuebleJpaController tipoInmueJPA = new TipoInmuebleJpaController();
    UsuarioJpaController usuaJPA = new UsuarioJpaController();

    //Constructor vacio
    public ControladoraPersistencia() {
    }
    
    public List<Cliente> getClientes() {
        return clienJPA.findClienteEntities();
    }
    
    //Metodo para crear cliente
    public void crearCliente(Cliente cliente){
        clienJPA.create(cliente);
    }
    
    //Se crea un metodo List para que busque y guarde todos los usuarios que se encuentren en la BD
    public List<Usuario> getUsuarios(){
        return usuaJPA.findUsuarioEntities();
    }
    
    //Metodo para editar información Cliente
    public void editCliente(Cliente cliente) throws Exception{
        clienJPA.edit(cliente);
    }
}
