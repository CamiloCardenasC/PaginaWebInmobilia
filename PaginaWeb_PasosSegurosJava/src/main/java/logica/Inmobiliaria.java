/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author kmilo
 */
@Entity
public class Inmobiliaria implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInmobiliaria;
    
    private String nombreEmpresa;
    private String pais;
    private String departamento;
    private String ciudadMunicipio;
    private String sede;
    
    //Define que una inmobiliaria puede tener varios Empleados.
    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)//Especifica que el atributo inmobiliaria en Empleado es el propietario de la relación.
    private List<Empleado> empleado;
    
    
    //Define que una inmobiliaria puede tener varios Contratos.
    @OneToMany(mappedBy = "inmobiliaria", cascade = CascadeType.ALL)//Especifica que el atributo inmobiliaria en Contrato es el propietario de la relación.
    private List<Contrato> contrato;

    public Inmobiliaria() {
    }

    public Inmobiliaria(int idInmobiliaria, String nombreEmpresa, String pais, String departamento, String ciudadMunicipio, String sede, List<Empleado> empleado, List<Contrato> contrato) {
        this.idInmobiliaria = idInmobiliaria;
        this.nombreEmpresa = nombreEmpresa;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudadMunicipio = ciudadMunicipio;
        this.sede = sede;
        this.empleado = empleado;
        this.contrato = contrato;
    }

    public int getIdInmobiliaria() {
        return idInmobiliaria;
    }

    public void setIdInmobiliaria(int idInmobiliaria) {
        this.idInmobiliaria = idInmobiliaria;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudadMunicipio() {
        return ciudadMunicipio;
    }

    public void setCiudadMunicipio(String ciudadMunicipio) {
        this.ciudadMunicipio = ciudadMunicipio;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }

    
    
}
