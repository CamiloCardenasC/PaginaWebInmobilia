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
public class TipoInmueble implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTipoInmueble;
    
    private String tipoInmueble;
    private String descripcionTipoInmueble;
    
    //Define que un inmueble solo pueder ser un solo tipo de inmueble.
    @OneToOne
    private Inmueble inmueble;

    public TipoInmueble() {
    }

    public TipoInmueble(int idTipoInmueble, String tipoInmueble, String descripcionTipoInmueble, Inmueble inmueble) {
        this.idTipoInmueble = idTipoInmueble;
        this.tipoInmueble = tipoInmueble;
        this.descripcionTipoInmueble = descripcionTipoInmueble;
        this.inmueble = inmueble;
    }

    public int getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(int idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getDescripcionTipoInmueble() {
        return descripcionTipoInmueble;
    }

    public void setDescripcionTipoInmueble(String descripcionTipoInmueble) {
        this.descripcionTipoInmueble = descripcionTipoInmueble;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
    
    
}
