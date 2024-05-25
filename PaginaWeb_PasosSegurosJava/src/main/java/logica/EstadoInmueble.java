package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.io.Serializable;

/**
 *
 * @author kmilo
 */
@Entity
public class EstadoInmueble implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEstadoInmueble;
    
    private String estadoInmueble;
    private String descripcionEstado;
    
    //Define que un inmueble puede tener un solo estado.
    @OneToOne
    private Inmueble inmueble;

    public int getIdEstadoInmueble() {
        return idEstadoInmueble;
    }

    public void setIdEstadoInmueble(int idEstadoInmueble) {
        this.idEstadoInmueble = idEstadoInmueble;
    }

    public String getEstadoInmueble() {
        return estadoInmueble;
    }

    public void setEstadoInmueble(String estadoInmueble) {
        this.estadoInmueble = estadoInmueble;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    
    
}
