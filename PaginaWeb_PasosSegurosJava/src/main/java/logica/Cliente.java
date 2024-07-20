package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kmilo
 */
//Especifica que la clase definida es una Entity Class
@Entity
public class Cliente extends Persona implements Serializable{
    
    @Column(name = "FOTO_PERFIL")
    private String fotoPerfil;
    
    @Column(name = "FACEBOOK")
    private String facebook;
    
    @Column(name = "TWITTER")
    private String twitter;
    
    @Email // Debe ser un formato de correo electrónico válido
    @Column(name = "CORREO_ELECTRONICO_PUBLICO")
    private String correoPublico;
    
    @Pattern(regexp = "^[\\d\\+\\-\\(\\)]+$", message = "El formato del numero de telefono es incorrecto")
    @Column(name = "TELEFONO_PUBLICO")
    private String telefonoPublico;
    
    
    //Define que un cliente puede tener muchas reservaciones.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) //Especifica que el atributo cliente en Reservacion es el propietario de la relación.
    private List<Reservacion> reservacion;
    
    //Define que un cliente puede tener muchos contratos.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) //Especifica que el atributo cliente en Contrato es el propietario de la relación.
    private List<Contrato> contrato;
    
    //Define que un cliente solo puede tener un solo usuario
    @OneToOne(cascade = CascadeType.ALL) //Cascade define que todas las acciones que se realicen con el objeto principal debe repetirse para todos los objetos.
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    //Constructor Vacio
    public Cliente() {
    }

    //Constructor con parametros
    public Cliente(String fotoPerfil, String facebook, String twitter, String correoPublico, String telefonoPublico, List<Reservacion> reservacion, List<Contrato> contrato, Usuario usuario, int idPersona, String nombrePersona, String apellidosPersona, Date fechaNacimiento, String telefonoPersona, String correoElectronico, String password) {
        super(idPersona, nombrePersona, apellidosPersona, fechaNacimiento, telefonoPersona, correoElectronico, password);
        this.fotoPerfil = fotoPerfil;
        this.facebook = facebook;
        this.twitter = twitter;
        this.correoPublico = correoPublico;
        this.telefonoPublico = telefonoPublico;
        this.reservacion = reservacion;
        this.contrato = contrato;
        this.usuario = usuario;
    }


    //Getter y Setter
    public List<Reservacion> getReservacion() {
        return reservacion;
    }

    public void setReservacion(List<Reservacion> reservacion) {
        this.reservacion = reservacion;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getCorreoPublico() {
        return correoPublico;
    }

    public void setCorreoPublico(String correoPublico) {
        this.correoPublico = correoPublico;
    }

    public String getTelefonoPublico() {
        return telefonoPublico;
    }

    public void setTelefonoPublico(String telefonoPublico) {
        this.telefonoPublico = telefonoPublico;
    }
    
}
