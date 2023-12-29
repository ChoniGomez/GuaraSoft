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
public class Articulo implements Serializable {
        
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @Basic
    private String descripcion;
    @Basic
    private String codigoBarra;
    @Basic
    private float precioCosto;
    @Basic
    private float precioVenta;
    @Basic
    private float descuentoMayorista;
    
    // Relaciones
    @OneToOne
    private Stock unStock;
    
    // Constructores
    public Articulo(){
        
    }
    // Metodos get
    public String getNombre(){
        return this.nombre;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public String getCodigoBarra(){
        return this.codigoBarra;
    }
    
    public float getPrecioCosto(){
        return this.precioCosto;
    }
    
    public float getPrecioVenta(){
        return this.precioVenta;
    }
    
    public float getDescuentoMayorista(){
        return this.descuentoMayorista;
    }
    
    public Stock getStock(){
        return this.unStock;
    }

    public int getId() {
        return this.id;
    }
    
    
    // Metodos set
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public void setCodigoBarra(String codigoBarra){
        this.codigoBarra = codigoBarra;
    }
    
    public void setPrecioCosto(float precioCosto){
        this.precioCosto = precioCosto;
    }
    
    public void setPrecioVenta(float precioVenta){
        this.precioVenta = precioVenta;
    }
    
    public void setDescuentoMayorista(float descuentoMayorista){
        this.descuentoMayorista = descuentoMayorista;
    }
 
    public void setStock(Stock unStock){
        this.unStock = unStock;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // metodos
    public boolean isId(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }
    
    public boolean esMenorOIgualCantidadoRequerida(int cantidadRequerida){
        boolean retorno = false;
        if(cantidadRequerida <= this.unStock.getCantidadReal()){
            retorno = true;
        }
        return retorno;
    }
}
