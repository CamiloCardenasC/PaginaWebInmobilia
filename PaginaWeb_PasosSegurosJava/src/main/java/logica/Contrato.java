package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author kmilo
 */
//Especifica que la clase definida es una Entity Class
@Entity
public class Contrato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrato;
    
    //Define que un contrato tiene un solo tipo de contraro.
    @OneToOne
    private TipoContrato tipoContrato;
    
    // Define que uno o varios contratos pueden estar asociadas a una sola inmobiliaria.
    @ManyToOne
    @JoinColumn(name = "idInmobiliaria")// Especifica la columna idPersona como clave externa para la relación.
    private Inmobiliaria inmobiliaria;
    
    //Define que un contrato tiene un solo inmueble.
    @OneToOne
    private Inmueble inmueble;
    
    // Define que uno o varios contratos pueden estar asociadas a un solo cliente.
    @ManyToOne
    @JoinColumn(name = "idPersona")// Especifica la columna idPersona como clave externa para la relación.
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private String descripcion;

    public Contrato() {
    }

    public Contrato(int idContrato, TipoContrato tipoContrato, Inmobiliaria inmobiliaria, Inmueble inmueble, Cliente cliente, Date fechaInicio, Date fechaFin, String descripcion) {
        this.idContrato = idContrato;
        this.tipoContrato = tipoContrato;
        this.inmobiliaria = inmobiliaria;
        this.inmueble = inmueble;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
