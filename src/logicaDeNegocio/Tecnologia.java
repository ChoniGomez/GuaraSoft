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
public class Tecnologia implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombreTecnologia;
    @Basic
    private String descripcionTecnologia;
    // Relaciones
    
    // Constructores
    public Tecnologia(){
        
    }
    
    // Metodos get
    public int getId() {
        return this.id;
    }

    public String getNombreTecnologia() {
        return this.nombreTecnologia;
    }

    public String getDescripcionTecnologia() {
        return this.descripcionTecnologia;
    }

    // Metodos set
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreTecnologia(String nombreTecnologia) {
        this.nombreTecnologia = nombreTecnologia;
    }

    public void setDescripcionTecnologia(String descripcionTecnologia) {
        this.descripcionTecnologia = descripcionTecnologia;
    }
    
    public boolean isId(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }
}
