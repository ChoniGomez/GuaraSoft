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
public class Proyecto implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private boolean terminado;
    @Basic
    private String fechaInicio;
    @Basic
    private String fechaFin;
    @Basic
    private int horasAnalisis;
    @Basic
    private int horasDisenio;
    @Basic
    private int horasProgramacion;
    // Relaciones
    @OneToOne
    private Empleado unEncargado;
    @OneToMany
    private List<Empleado> programadores;
    @OneToMany
    private List<Empleado> diseniadores;
    @OneToMany
    private List<Empleado> analistas;
    @OneToMany
    private List<Cuota> cuotas;
    @OneToMany
    private List<Tecnologia> tecnologias;
    @OneToMany
    private List<OrdenDeTrabajo> ordenesDeTrabajo;
    // Constructores
    public Proyecto(){
        this.analistas = new LinkedList<Empleado>();
        this.programadores = new LinkedList<Empleado>();
        this.diseniadores = new LinkedList<Empleado>();
        this.cuotas = new LinkedList<Cuota>();
        this.tecnologias = new LinkedList<Tecnologia>();
        this.ordenesDeTrabajo = new LinkedList<OrdenDeTrabajo>();
    }

    // Metodos get
    public int getId() {
        return this.id;
    }

    public boolean isTerminado() {
        return this.terminado;
    }

    public boolean getTerminado() {
        return this.terminado;
    }
    
    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public Empleado getUnEncargado() {
        return this.unEncargado;
    }

    public List<Empleado> getProgramadores() {
        return this.programadores;
    }

    public List<Empleado> getDiseniadores() {
        return this.diseniadores;
    }

    public List<Empleado> getAnalistas() {
        return this.analistas;
    }

    public int getHorasAnalisis() {
        return this.horasAnalisis;
    }

    public int getHorasDisenio() {
        return this.horasDisenio;
    }

    public int getHorasProgramacion() {
        return this.horasProgramacion;
    }

    public List<Cuota> getCuotas() {
        return this.cuotas;
    }

    public List<Tecnologia> getTecnologias() {
        return this.tecnologias;
    }

    public List<OrdenDeTrabajo> getOrdenesDeTrabajo() {
        return this.ordenesDeTrabajo;
    }
    
    // Metodos set
    public void setId(int id) {
        this.id = id;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setUnEncargado(Empleado unEncargado) {
        this.unEncargado = unEncargado;
    }

    public void setProgramadores(List<Empleado> programadores) {
        this.programadores = programadores;
    }

    public void setDiseniadores(List<Empleado> diseniadores) {
        this.diseniadores = diseniadores;
    }

    public void setAnalistas(List<Empleado> analistas) {
        this.analistas = analistas;
    }

    public void setHorasAnalisis(int horasAnalisis) {
        this.horasAnalisis = horasAnalisis;
    }

    public void setHorasDisenio(int horasDisenio) {
        this.horasDisenio = horasDisenio;
    }

    public void setHorasProgramacion(int horasProgramacion) {
        this.horasProgramacion = horasProgramacion;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public void setOrdenesDeTrabajo(List<OrdenDeTrabajo> ordenesDeTrabajo) {
        this.ordenesDeTrabajo = ordenesDeTrabajo;
    }
    
    // Metodos
    public void addProgramadores(Empleado unProgramador) {
        this.programadores.add(unEncargado);
    }

    public void addDiseniadores(Empleado unDiseniador) {
        this.diseniadores.add(unDiseniador);
    }

    public void addCuota(Cuota unaCuota) {
        this.cuotas.add(unaCuota);
    }
    
    public void addAnalistas(Empleado unAnalista) {
        this.analistas.add(unAnalista);
    }
    
    public void addTecnologia(Tecnologia unaTecnologia) {
        this.tecnologias.add(unaTecnologia);
    }
    
    public void addOrdenDeTrabajo(OrdenDeTrabajo unaOrdenDeTrabajo) {
        this.ordenesDeTrabajo.add(unaOrdenDeTrabajo);
    }
    
    public boolean isId(int id){
        boolean retorno = false;
        if(this.id == id){
            retorno = true;
        }
        return retorno;
    }
}
