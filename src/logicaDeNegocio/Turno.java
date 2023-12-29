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
public class Turno implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTurno;
    @Basic
    private String fechaTurno;
    @Basic
    private String horaTurno;
    @Basic
    private boolean finalizadoTurno;
    @Basic
    private String tipoDeTurno;
    @Basic
    private String descripcion;
    //Relaciones
    @OneToOne
    private Equipo unEquipo;
    @OneToOne
    private Empleado unEmpleado;
    @OneToOne
    private Cliente unCliente;
    @OneToOne
    private Sucursal unaSucursal;
    @OneToOne
    private Estado unEstadoIngreso;
    @OneToOne
    private Estado unEstadoEgreso;
    @OneToMany
    private List<OrdenDeTrabajo> ordenesDeTrabajo;
    //Constructores
    public Turno(){
        this.ordenesDeTrabajo = new LinkedList<OrdenDeTrabajo>();
    }
    
    //Metodos get
    public int getIdTurno() {
        return this.idTurno;
    }

    public String getFechaTurno() {
        return this.fechaTurno;
    }

    public String getHoraTurno() {
        return this.horaTurno;
    }

    public String getTipoDeTurno() {
        return this.tipoDeTurno;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Equipo getUnEquipo() {
        return this.unEquipo;
    }

    public Empleado getUnEmpleado() {
        return this.unEmpleado;
    }

    public Cliente getUnCliente() {
        return this.unCliente;
    }

    public boolean getFinalizadoTurno() {
        return this.finalizadoTurno;
    }

    public Sucursal getUnaSucursal() {
        return this.unaSucursal;
    }

    public Estado getUnEstadoIngreso() {
        return this.unEstadoIngreso;
    }

    public Estado getUnEstadoEgreso() {
        return this.unEstadoEgreso;
    }

    public List<OrdenDeTrabajo> getOrdenesDeTrabajo() {
        return this.ordenesDeTrabajo;
    }

    //Metodos set
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public void setHoraTurno(String horaTurno) {
        this.horaTurno = horaTurno;
    }

    public void setTipoDeTurno(String tipoDeTurno) {
        this.tipoDeTurno = tipoDeTurno;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnEquipo(Equipo unEquipo) {
        this.unEquipo = unEquipo;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public void setFinalizadoTurno(boolean finalizadoTurno) {
        this.finalizadoTurno = finalizadoTurno;
    }

    public void setUnaSucursal(Sucursal unaSucursal) {
        this.unaSucursal = unaSucursal;
    }

    public void setUnEstadoIngreso(Estado unEstadoIngreso) {
        this.unEstadoIngreso = unEstadoIngreso;
    }

    public void setUnEstadoEgreso(Estado unEstadoEgreso) {
        this.unEstadoEgreso = unEstadoEgreso;
    }
    
    public void setOrdenesDeTrabajo(List<OrdenDeTrabajo> ordenesDeTrabajo) {
        this.ordenesDeTrabajo = ordenesDeTrabajo;
    }
    //Metodos
    public void addOrdeDeTrabajo(OrdenDeTrabajo unaOrdenDeTrabajo){
        this.ordenesDeTrabajo.add(unaOrdenDeTrabajo);
    }
    
    // metodo para saber si contiene una sucursal por su numero
    public boolean contieneSucursal(int numeroSucursal){
        boolean retorno = false;
        if(this.unaSucursal.getNumeroSucursal() == numeroSucursal){
            retorno = true;
        }
        return retorno;
    }
}
