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
public class TipoContrato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTipoContrato;
    
    private String tipoContrato;
    private String descripcion;
    
    //Define que un contrato solo puede ser un solo tipo de contrato
    @OneToOne
    private Contrato contrato;

    public TipoContrato() {
    }

    public TipoContrato(int idTipoContrato, String tipoContrato, String descripcion, Contrato contrato) {
        this.idTipoContrato = idTipoContrato;
        this.tipoContrato = tipoContrato;
        this.descripcion = descripcion;
        this.contrato = contrato;
    }

    public int getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(int idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
    
}
