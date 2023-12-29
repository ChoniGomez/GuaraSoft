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
import javax.persistence.OneToOne;

/**
 *
 * @author Choni
 */
@Entity
public class Detalle implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int cantidad;
    @Basic 
    private float precioUnitario;
    @Basic 
    private float precioTotal;
    
    // Relaciones
    @OneToOne
    private Articulo unArticulo;
            
    // Constructores
    public Detalle(){
        
    }
    // Metodos get
    public float getPrecioUnitario(){
        return this.precioUnitario;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public Articulo getArticulo(){
        return this.unArticulo;
    }
    
    public int getId(){
        return this.id;
    }
    
    public float getPrecioTotal(){
        return this.precioTotal;
    }
    // Metodos set
    public void setPrecioUnitario(float precioUnitario){
        this.precioUnitario = precioUnitario;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setArticulo(Articulo unArticulo){
        this.unArticulo = unArticulo;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setPrecioTotal(float precioTotal){
        this.precioTotal = precioTotal;
    }
}
