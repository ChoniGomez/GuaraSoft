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

/**
 *
 * @author Choni
 */
@Entity
public class Sucursal implements Serializable {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idSucursal;
    @Basic
    private int numeroSucursal;
    @Basic 
    private String direccion;
    @Basic
    private String comentarioSucursal;
    @Basic
    private String telefono;
    //Relaciones
    @OneToMany
    private List<Proveedor> proveedores;
    @OneToMany
    private List<Articulo> articulos;
    @OneToMany
    private List<Proyecto> proyectos;
    @OneToMany
    private List<Empleado> empleados;
    //Constructores
    public Sucursal(){
        this.proveedores = new LinkedList<Proveedor>();
        this.articulos = new LinkedList<Articulo>();
        this.empleados = new LinkedList<Empleado>();
    }
    
    //Metodos get
    public int getIdSucursal() {
        return this.idSucursal;
    }

    public int getNumeroSucursal() {
        return this.numeroSucursal;
    }

    public String getComentarioSucursal() {
        return this.comentarioSucursal;
    }

    public List<Proveedor> getProveedores() {
        return this.proveedores;
    }

    public List<Articulo> getArticulos() {
        return this.articulos;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }
    
    public List<Proyecto> getProyectos(){
        return this.proyectos;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    //Metodos set
    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setNumeroSucursal(int numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public void setComentarioSucursal(String comentarioSucursal) {
        this.comentarioSucursal = comentarioSucursal;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    public void setProyectos(List<Proyecto> proyectos){
        this.proyectos = proyectos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    //Metodos
    public void addArticulo(Articulo unArticulo){
        this.articulos.add(unArticulo);
    }
    
    public void addProveedor(Proveedor unProveedor){
        this.proveedores.add(unProveedor);
    }
    
    public void addEmpleado(Empleado unEmpleado){
        this.empleados.add(unEmpleado);
    }
    
    public void addProyecto(Proyecto unProyecto) {
        this.proyectos.add(unProyecto);
    }
    
    public boolean isSucursal(int numeroSucursal){
        boolean retorno = false;
        if(this.numeroSucursal == numeroSucursal){
            retorno = true;
        }
        return retorno;
    }
    
    public boolean isId(int id){
        boolean retorno = false;
        if(this.idSucursal == id){
            retorno = true;
        }
        return retorno;
    }
}
