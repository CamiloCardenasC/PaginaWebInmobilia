package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kmilo
 */
@Entity
public class Cliente extends Persona implements Serializable{
    
    //Define que un cliente puede tener muchas reservaciones.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) //Especifica que el atributo cliente en Reservacion es el propietario de la relación.
    private List<Reservacion> reservacion;
    
    //Define que un cliente puede tener muchos contratos.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) //Especifica que el atributo cliente en Contrato es el propietario de la relación.
    private List<Contrato> contrato;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(List<Reservacion> reservacion, List<Contrato> contrato, Usuario usuario, int idPersona, String nombrePersona, String apellidosPersona, Date fechaNacimiento, String telefonoPersona, String correoElectronico, String password) {
        super(idPersona, nombrePersona, apellidosPersona, fechaNacimiento, telefonoPersona, correoElectronico, password);
        this.reservacion = reservacion;
        this.contrato = contrato;
        this.usuario = usuario;
    }

    public List<Reservacion> getReservacion() {
        return reservacion;
    }

    public void setReservacion(List<Reservacion> reservacion) {
        this.reservacion = reservacion;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}
