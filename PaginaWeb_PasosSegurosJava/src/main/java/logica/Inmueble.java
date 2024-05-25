package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kmilo
 */
@Entity
public class Inmueble implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInmueble;
    
    //Define que un inmueble puede ser un solo tipo de inmueble. 
    @OneToOne
    private TipoInmueble tipoInmueble;
    
    //Define que un inmueble tiene un solo estado en el inmueble.
    @OneToOne
    private EstadoInmueble estadoInmueble;
    
    //Define que uno o varios inmuebles estan asociados a un solo empleado.
    @ManyToOne
    @JoinColumn(name = "idPersona")// Especifica la columna idPersona como clave externa para la relación.
    private Empleado empleado;
    
    private double metrosCuadrados;
    private int numeroHabitaciones;
    private int numeroBanios;
    private String ciudadMunicipio;
    private String direccionInmueble;
    private String cordenadasInmueble;
    private String descripcion;
    
    //Define que un Inmueble puede tener uno o varias reservaciones. 
    @OneToMany(mappedBy = "inmueble", cascade = CascadeType.ALL, orphanRemoval = true)//Especifica que el atributo inmueble en Reservacion es el propietario de la relación.
    private List<Reservacion> reservacion;
    
    //Defien que un inmueble puede tener un solo contrato.
    @OneToOne
    private Contrato contrato;

    public Inmueble() {
    }

    public Inmueble(int idInmueble, TipoInmueble tipoInmueble, EstadoInmueble estadoInmueble, Empleado empleado, double metrosCuadrados, int numeroHabitaciones, int numeroBanios, String ciudadMunicipio, String direccionInmueble, String cordenadasInmueble, String descripcion, List<Reservacion> reservacion, Contrato contrato) {
        this.idInmueble = idInmueble;
        this.tipoInmueble = tipoInmueble;
        this.estadoInmueble = estadoInmueble;
        this.empleado = empleado;
        this.metrosCuadrados = metrosCuadrados;
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanios = numeroBanios;
        this.ciudadMunicipio = ciudadMunicipio;
        this.direccionInmueble = direccionInmueble;
        this.cordenadasInmueble = cordenadasInmueble;
        this.descripcion = descripcion;
        this.reservacion = reservacion;
        this.contrato = contrato;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public EstadoInmueble getEstadoInmueble() {
        return estadoInmueble;
    }

    public void setEstadoInmueble(EstadoInmueble estadoInmueble) {
        this.estadoInmueble = estadoInmueble;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getNumeroBanios() {
        return numeroBanios;
    }

    public void setNumeroBanios(int numeroBanios) {
        this.numeroBanios = numeroBanios;
    }

    public String getCiudadMunicipio() {
        return ciudadMunicipio;
    }

    public void setCiudadMunicipio(String ciudadMunicipio) {
        this.ciudadMunicipio = ciudadMunicipio;
    }

    public String getDireccionInmueble() {
        return direccionInmueble;
    }

    public void setDireccionInmueble(String direccionInmueble) {
        this.direccionInmueble = direccionInmueble;
    }

    public String getCordenadasInmueble() {
        return cordenadasInmueble;
    }

    public void setCordenadasInmueble(String cordenadasInmueble) {
        this.cordenadasInmueble = cordenadasInmueble;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Reservacion> getReservacion() {
        return reservacion;
    }

    public void setReservacion(List<Reservacion> reservacion) {
        this.reservacion = reservacion;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    
    
}
