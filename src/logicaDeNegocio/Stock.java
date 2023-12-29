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
public class Stock implements Serializable{
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int cantidadMinima;
    @Basic
    private int cantidadReal;
    // Relaciones
    
    // Constructores
    public Stock(){
        
    }
    
    // Metodos set
    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public void setCantidadReal(int cantidadReal) {
        this.cantidadReal = cantidadReal;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    // Metodos get
    public int getCantidadMinima() {
        return this.cantidadMinima;
    }

    public int getCantidadReal() {
        return this.cantidadReal;
    }

    public int getId() {
        return this.id;
    }
     
    // metodos de clases
    public void reponerStock(int cantidad){
        this.cantidadReal = this.cantidadReal + cantidad;
    }
    
    public boolean isId(int id){
        boolean retorno;
        if(this.id == id){
            retorno = true;
        }
        else{
            retorno = false;
        }
        return retorno;
    }
}
