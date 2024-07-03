package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kmilo
 */
@Entity
public class Empleado extends Persona implements Serializable{
    
    //Define que un Empleado solo puede tener un solo cargo.
    @OneToOne
    private Cargo cargo;
    
    
    //Define que un empleado puede tener varios inmuebles.
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL) //Especifica que el atributo empleado en Inmueble es el propietario de la relación.
    private List<Inmueble> inmueble;
    
    //Define que Varios empleados es de una sola inmobiliaria
    @ManyToOne
    @JoinColumn(name = "idInmobiliaria")
    private Inmobiliaria inmobiliaria;
    
    
    //Define que un empleado puede tener varios permisos.
    @ManyToMany
    @JoinTable(name = "empleado_permisos", joinColumns = @JoinColumn(name = "idPersona"),//Especifica el nombre de la tabla intermedia entre permisos y empleados
            inverseJoinColumns = @JoinColumn(name = "idPermisos"))
    private Set<Permisos> permisos;
    
    //Define que un empleado tiene un solo Usuario
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(Cargo cargo, List<Inmueble> inmueble, Inmobiliaria inmobiliaria, Set<Permisos> permisos, Usuario usuario, int idPersona, String nombrePersona, String apellidosPersona, Date fechaNacimiento, String telefonoPersona, String correoElectronico, String password) {
        super(idPersona, nombrePersona, apellidosPersona, fechaNacimiento, telefonoPersona, correoElectronico, password);
        this.cargo = cargo;
        this.inmueble = inmueble;
        this.inmobiliaria = inmobiliaria;
        this.permisos = permisos;
        this.usuario = usuario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Inmueble> getInmueble() {
        return inmueble;
    }

    public void setInmueble(List<Inmueble> inmueble) {
        this.inmueble = inmueble;
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }

    public void setInmobiliaria(Inmobiliaria inmobiliaria) {
        this.inmobiliaria = inmobiliaria;
    }

    public Set<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permisos> permisos) {
        this.permisos = permisos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
}
