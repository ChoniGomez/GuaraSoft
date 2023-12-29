/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Choni
 */
@Entity
public abstract class ComprobanteComercial implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idComprobante;
    @Basic
    private String fechaComprobante;
    @Basic
    private String horaComprobante;
    @Basic
    private float totalComprobante;
    @Basic
    private String tipoDeComprobate;
    // Relaciones
    @OneToMany
    private List<Detalle> detalles;
    @OneToOne
    private Sucursal unaSucursal;
    // Constructores
    public ComprobanteComercial(){
        this.detalles = new LinkedList<Detalle>();
    }
    
    // Metodos set
    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public void setFechaComprobante(String fechaComprobante) {
        this.fechaComprobante = fechaComprobante;
    }

    public void setTotalComprobante(float totalComprobante) {
        this.totalComprobante = totalComprobante;
    }
    
    public void setHoraComprobante(String horaComprobante){
        this.horaComprobante = horaComprobante;
    }

    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }
        
    public void setTipoComprobante(String tipoComprobante){
        this.tipoDeComprobate = tipoComprobante;
    }

    public void setUnaSucursal(Sucursal unaSucursal) {
        this.unaSucursal = unaSucursal;
    }
    
    // Metodos get
    public int getIdComprobante() {
        return this.idComprobante;
    }

    public String getFechaComprobante() {
        return this.fechaComprobante;
    }

    public float getTotalComprobante() {
        return this.totalComprobante;
    }
    
    public String getHoraComprobante(){
        return this.horaComprobante;
    }
    
    public List<Detalle> getDetalles() {
        return this.detalles;
    }
    
    public String getTipoComprobante(){
        return this.tipoDeComprobate;
    }

    public Sucursal getUnaSucursal() {
        return this.unaSucursal;
    }
    
    // Metodos
    public void addDetalle(Detalle unDetalle){
        this.detalles.add(unDetalle);
    }
    
    public void clearDetalles(){
        this.detalles.clear();
    }
    
    public boolean isId(int id){
        boolean retorno = false;
        if(this.idComprobante == id){
            retorno = true;
        }
        return retorno;
    }
    
    // metodo para saber si contiene una sucursal por su numero
    public boolean contieneSucursal(int numeroSucursal){
        boolean retorno = false;
        if(this.unaSucursal.getNumeroSucursal() == numeroSucursal){
            retorno = true;
        }
        return retorno;
    }
    
    // metodo para saber la fecha del comprobante
    public boolean isFechaComprobante(String fecha){
        boolean retorno = false;
        if(this.fechaComprobante.equals(fecha)){
            retorno = true;
        }
        return retorno;
    }
}
