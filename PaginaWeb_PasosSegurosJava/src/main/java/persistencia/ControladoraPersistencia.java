package persistencia;

import logica.Cliente;

/**
 *
 * @author kmilo
 */
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
    
    //Metodo para crear cliente
    public void crearCliente(Cliente cliente){
        clienJPA.create(cliente);
    }
    
}
