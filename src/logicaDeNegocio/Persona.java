/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Choni
 */
@Entity
public abstract class Persona implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private String telefono;
    @Basic
    private String correoElectronico;
    @Basic
    private String domicilio;
    @Basic
    private String dni;
    @Basic
    private String cuil;
    
    // Relaciones
    
    // Constructores
    public Persona(){
        
    }

    // Metodos get
    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public String getDomicilio() {
        return this.domicilio;
    }

    public String getDni() {
        return this.dni;
    }

    public String getCuil() {
        return this.cuil;
    }
    
    public int getId() {
        return this.id;
    }
    
    // Metodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    // Metodos
    public boolean isId(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }
}
