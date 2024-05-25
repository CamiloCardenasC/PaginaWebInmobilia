package logica;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kmilo
 */
@Entity
public class Permisos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPermisos;
    
    private String permisos;
    private String descripcionPermisos;
    
    //Define que un permiso pueden ser de varios empleados.
    @ManyToMany(mappedBy = "permisos")
    private List<Empleado> empleados;

    public Permisos() {
    }

    public Permisos(int idPermisos, String permisos, String descripcionPermisos, List<Empleado> empleados) {
        this.idPermisos = idPermisos;
        this.permisos = permisos;
        this.descripcionPermisos = descripcionPermisos;
        this.empleados = empleados;
    }

    public int getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(int idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getDescripcionPermisos() {
        return descripcionPermisos;
    }

    public void setDescripcionPermisos(String descripcionPermisos) {
        this.descripcionPermisos = descripcionPermisos;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    
}
