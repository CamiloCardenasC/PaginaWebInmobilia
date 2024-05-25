package logica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kmilo
 */
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    
    private String nombreUsuario;
    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaRegistro", updatable = false, nullable = false)
    private Date fechaRegistro;
    
    
    //Define que un Usuario solo puede tener un empleado.
    @OneToOne(mappedBy = "usuario")
    private Empleado empleado;
    
    //Define que un Usuarios solo puede tener un solo cliente.
    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    public Usuario() {
        this.fechaRegistro = new Date();
    }

    public Usuario(int idUsuario, String nombreUsuario, String password, Date fechaRegistro, Empleado empleado, Cliente cliente) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
}
