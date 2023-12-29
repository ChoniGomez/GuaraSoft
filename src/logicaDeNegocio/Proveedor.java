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
public class Proveedor implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String razonSocial;
    @Basic
    private String correoElectronico;
    @Basic
    private String direccion;
    @Basic
    private String localidad;
    @Basic
    private String telefono;
    @Basic
    private String pais;
    @Basic
    private String cuit;
    @Basic
    private String situacionTributaria;
    // Relaciones
    
    // Constructores
    public Proveedor(){
        
    }

    // Metodos get
    public String getCuit() {
        return this.cuit;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public String getSituacionTributaria() {
        return this.situacionTributaria;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getPais() {
        return this.pais;
    }

    public int getId() {
        return this.id;
    }
          
    // Metodos set
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setSituacionTributaria(String situacionTributaria) {
        this.situacionTributaria = situacionTributaria;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
    public boolean isId(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }
}
