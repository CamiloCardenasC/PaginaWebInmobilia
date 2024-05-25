package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kmilo
 */
@Entity
public class Reservacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idReservacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReservacion;
    
    private String estadoReservacion;
    private String comentario;
    
    // Define que muchas reservaciones pueden estar asociadas a un solo cliente.
    @ManyToOne
    @JoinColumn(name = "idPersona") // Especifica la columna idPersona como clave externa para la relación.
    private Cliente cliente;
    
    // Define que muchas reservaciones pueden estar asociadas a un solo inmueble.
    @ManyToOne
    @JoinColumn(name = "idInmueble") // Especifica la columna idInmueble como clave externa para la relación.
    private Inmueble inmueble;

    public Reservacion() {
    }

    public Reservacion(int idReservacion, Date fechaReservacion, String estadoReservacion, String comentario, Cliente cliente, Inmueble inmueble) {
        this.idReservacion = idReservacion;
        this.fechaReservacion = fechaReservacion;
        this.estadoReservacion = estadoReservacion;
        this.comentario = comentario;
        this.cliente = cliente;
        this.inmueble = inmueble;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getEstadoReservacion() {
        return estadoReservacion;
    }

    public void setEstadoReservacion(String estadoReservacion) {
        this.estadoReservacion = estadoReservacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    
    
}
