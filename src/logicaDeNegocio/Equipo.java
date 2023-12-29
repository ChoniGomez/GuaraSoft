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
public class Equipo implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String anio;
    @Basic
    private String marca;
    //Relaciones
    
    //Constructores
    public Equipo(){
        
    }
    
    //Metodos set
    public void setId(int id) {
        this.id = id;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Metodos get
    public int getId() {
        return this.id;
    }

    public String getAnio() {
        return this.anio;
    }

    public String getMarca() {
        return this.marca;
    }
    
    // metodos
    public boolean isId(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }
}
