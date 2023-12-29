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
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Choni
 */
@Entity
public class Empresa implements Serializable {
    // Atributos
    @Basic
    private String cuit;
    @Id
    private String razonSocial;
    @Basic
    private String direccion;
    @Basic
    private String telefono;
    @Basic
    private String correoElectronico;
    
    // Relaciones
    @OneToMany
    private List<Articulo> articulos;
    @OneToMany
    private List<FacturaCompra> facturasCompras;
    @OneToMany
    private List<FacturaVenta> facturasVentas;
    @OneToMany
    private List<Tique> tiques;
    @OneToMany
    private List<Empleado> empleados;
    @OneToMany
    private List<Cliente> clientes;
    @OneToMany
    private List<Proveedor> proveedores;
    @OneToMany
    private List<Turno> turnos;
    @OneToMany
    private List<Sucursal> sucursales;

    // Constructores
    public Empresa(){
        this.articulos = new LinkedList<Articulo>();
        this.clientes = new LinkedList<Cliente>();
        this.facturasCompras = new LinkedList<FacturaCompra>();
        this.facturasVentas = new LinkedList<FacturaVenta>();
        this.tiques = new LinkedList<Tique>();
        this.empleados = new LinkedList<Empleado>();
        this.proveedores = new LinkedList<Proveedor>();
        this.turnos = new LinkedList<Turno>();
        this.sucursales = new LinkedList<Sucursal>();
    }

    // Metodos get
    public String getCuit() {
        return this.cuit;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public List<Articulo> getArticulos() {
        return this.articulos;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public List<Proveedor> getProveedores() {
        return this.proveedores;
    }

    public List<FacturaCompra> getFacturasCompras() {
        return this.facturasCompras;
    }

    public List<FacturaVenta> getFacturasVentas() {
        return this.facturasVentas;
    }

    public List<Tique> getTiques() {
        return this.tiques;
    }

    public List<Turno> getTurnos() {
        return this.turnos;
    }

    public List<Sucursal> getSucursales() {
        return this.sucursales;
    }
    
    // Metodos set
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public void setFacturasCompras(List<FacturaCompra> facturasCompras) {
        this.facturasCompras = facturasCompras;
    }

    public void setFacturasVentas(List<FacturaVenta> facturasVentas) {
        this.facturasVentas = facturasVentas;
    }

    public void setTiques(List<Tique> tiques) {
        this.tiques = tiques;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }
    
    // Metodo add
    public void addArticulo(Articulo unArticulo){
        this.articulos.add(unArticulo);
    }
    
    public void addCliente(Cliente unCliente){
        this.clientes.add(unCliente);
    }
    
    public void addEmpleado(Empleado unEmpleado){
        this.empleados.add(unEmpleado);
    }
    
    public void addProveedor(Proveedor unProveedor){
        this.proveedores.add(unProveedor);
    }
    
    public void addTurno(Turno unTurno){
        this.turnos.add(unTurno);
    }
    
    public void addSucursal(Sucursal unaSucursal){
        this.sucursales.add(unaSucursal);
    }
    
    public void deleteProveedores(){
        this.proveedores.clear();
    }
    
    public void deleteArticulos(){
        this.articulos.clear();
    }
}
