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
public class EnvioTercero implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombreTercero;
    @Basic
    private double precio;
    // Relaciones
    
    // Constructores
    public EnvioTercero(){
        
    }
    
    // Metodos set
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreTercero(String nombreTercero) {
        this.nombreTercero = nombreTercero;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Metodos get
    public int getId() {
        return this.id;
    }

    public String getNombreTercero() {
        return this.nombreTercero;
    }

    public double getPrecio() {
        return this.precio;
    }
}
