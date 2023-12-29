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
public class OrdenDeTrabajo implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrdenDeTrabajo;
    @Basic
    private String fechaSolicitud;
    @Basic
    private String horaSolicitud;
    @Basic
    private int tiempoEstimado;
    @Basic
    private String tipoDeTiempo;// dias u horas;
    @Basic
    private double costoTotal;
    // Relaciones
    @OneToOne
    private Articulo unArticulo;
    @OneToOne
    private Empleado unEmpleado;
    @OneToOne
    private EnvioTercero unEnvioTercero;
    // Constructores
    public OrdenDeTrabajo(){
        
    }
    
    // Metodos set
    public void setIdOrdenDeTrabajo(int idOrdenDeTrabajo) {
        this.idOrdenDeTrabajo = idOrdenDeTrabajo;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setHoraSolicitud(String horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public void setTipoDeTiempo(String tipoDeTiempo) {
        this.tipoDeTiempo = tipoDeTiempo;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setUnArticulo(Articulo unArticulo) {
        this.unArticulo = unArticulo;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public void setUnEnvioTercero(EnvioTercero unEnvioTercero) {
        this.unEnvioTercero = unEnvioTercero;
    }

    // Metodos get
    public int getIdOrdenDeTrabajo() {
        return this.idOrdenDeTrabajo;
    }

    public String getFechaSolicitud() {
        return this.fechaSolicitud;
    }

    public String getHoraSolicitud() {
        return this.horaSolicitud;
    }

    public int getTiempoEstimado() {
        return this.tiempoEstimado;
    }

    public String getTipoDeTiempo() {
        return this.tipoDeTiempo;
    }

    public double getCostoTotal() {
        return this.costoTotal;
    }

    public Articulo getUnArticulo() {
        return this.unArticulo;
    }

    public Empleado getUnEmpleado() {
        return this.unEmpleado;
    }

    public EnvioTercero getUnEnvioTercero() {
        return this.unEnvioTercero;
    }
    
}
