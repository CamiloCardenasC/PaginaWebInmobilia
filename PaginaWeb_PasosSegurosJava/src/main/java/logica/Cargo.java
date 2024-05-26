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

//Especifica que la clase definida es una Entity Class
@Entity
public class Cargo implements Serializable {
    
    //Permite definir que el idCargo sera la Primary Key al ser mappeado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Define se generara automaticamente
    private int idCargo;
    
    private String cargo;
    private String descripcionCargo;
    
    //Define que un empleado solo puede tener un cargo.
    @OneToOne
    private Empleado empleado;

    //Constructor vacio
    public Cargo() {
    }
    
    //Constructor con parametros
    public Cargo(int idCargo, String cargo, String descripcionCargo, Empleado empleado) {
        this.idCargo = idCargo;
        this.cargo = cargo;
        this.descripcionCargo = descripcionCargo;
        this.empleado = empleado;
    }

    //Getter y Setter
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    
}

