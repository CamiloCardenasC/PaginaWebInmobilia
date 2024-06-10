package logica;

import jakarta.persistence.CascadeType;
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
    
    private String correoElectronico;
    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)//Define el tipo de fecha
    @Column(name = "fechaRegistro", updatable = false, nullable = false)//Se nombra la columna, update false es para evitar que se actualice y evitar que sea null
    private Date fechaRegistro;
    
    
    //Define que un Usuario solo puede tener un empleado.
    @OneToOne(mappedBy = "usuario")
    private Empleado empleado;
    
    //Define que un Usuarios solo puede tener un solo cliente.
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cliente cliente;

    //Constructor Vacio
    public Usuario() {
        this.fechaRegistro = new Date();
    }

    //Constructor Con parametros
    public Usuario(int idUsuario, String correoElectronico, String password, Date fechaRegistro, Empleado empleado, Cliente cliente) {
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.empleado = empleado;
        this.cliente = cliente;
    }

    //Getter y Setter
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
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
