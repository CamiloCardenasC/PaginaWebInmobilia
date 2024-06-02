package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author kmilo
 */

//Define que la clase es una Entity Class para el mappeo
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Define que esta clase heredara sus atributos y metodos, y tendra una tabla separada
public class Persona implements Serializable {
    
    @Id //@Id declara la propiedad identificadora de esta entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersona;
    
    private String nombrePersona;
    private String apellidosPersona;
    
    @Temporal(TemporalType.DATE)//Define el tipo de fecha 
    private Date fechaNacimiento;
    
    private String telefonoPersona;
    private String correoElectronico;
    private String password;

    //Constructor Vacio
    public Persona() {
    }
    
    //Constructor con parametros
    public Persona(int idPersona, String nombrePersona, String apellidosPersona, Date fechaNacimiento, 
            String telefonoPersona, String correoElectronico, String password) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidosPersona = apellidosPersona;
        this.fechaNacimiento = fechaNacimiento;
        this.telefonoPersona = telefonoPersona;
        this.correoElectronico = correoElectronico;
        this.password = password;
    }


    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }


    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
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

}
