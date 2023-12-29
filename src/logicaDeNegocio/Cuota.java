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
public class Cuota implements Serializable{
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private double monto;
    @Basic 
    private String tipoDeCuota;
    
    // Relaciones
            
    // Constructores
    public Cuota(){
        
    }

    // Metodos get
    public int getId() {
        return this.id;
    }

    public double getMonto() {
        return this.monto;
    }

    public String getTipoDeCuota() {
        return this.tipoDeCuota;
    }
    
    // Metodos set
    public void setId(int id) {
        this.id = id;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setTipoDeCuota(String tipoDeCuota) {
        this.tipoDeCuota = tipoDeCuota;
    }
    
    public boolean isCuota(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }    
}
