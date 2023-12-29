/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaz;

import java.util.List;
import logicaDeNegocio.Articulo;
import logicaDeNegocio.Cliente;
import logicaDeNegocio.CuentaCorriente;
import logicaDeNegocio.Cuota;
import logicaDeNegocio.Detalle;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.Equipo;
import logicaDeNegocio.FacturaCompra;
import logicaDeNegocio.FacturaVenta;
import logicaDeNegocio.GuaraSoft;
import logicaDeNegocio.Proveedor;
import logicaDeNegocio.Proyecto;
import logicaDeNegocio.Sucursal;
import logicaDeNegocio.Tecnologia;
import logicaDeNegocio.Tique;
import persistenciaJPA.exceptions.NonexistentEntityException;
import persistenciaJPA.exceptions.PreexistingEntityException;

/**
 *
 * @author Choni
 */
public class ControladoraInterfaz {
    GuaraSoft miControladoraLogicaDeNegocio = new GuaraSoft();
    /// CLASES
    
    //CLASE PROVEEDOR
    public void crearProveedor(String razonSocial, String correoElectronico, String direccion, String localidad, String telefono, String pais, String cuit, String situacionTributaria)throws Exception, PreexistingEntityException{
        miControladoraLogicaDeNegocio.crearProveedor(razonSocial, correoElectronico, direccion, localidad, telefono, pais, cuit, situacionTributaria);
    }
    public void modificarProveedor(int id, String razonSocial, String correoElectronico, String direccion, String localidad, String telefono, String pais, String cuit, String situacionTributaria) throws Exception, PreexistingEntityException{
        miControladoraLogicaDeNegocio.modificarProveedor(id, razonSocial, correoElectronico, direccion, localidad, telefono, pais, cuit, situacionTributaria);
    }
    public void eliminarProveedor(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        miControladoraLogicaDeNegocio.eliminarProveedor(id);
    }
    public Proveedor dameMiProveedor(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiProveedor(id);
    }
    public List<Proveedor> dameProveedores() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameProveedores();
    }
    
    // CLASE ARTICULO
    public void crearArticulo(String nombre, String descripcion, String codigoBarra, float precioCosto, float precioVenta, float descuentoMayorista, int cantidadReal, int cantidadMin, int numeroSucursal)throws Exception, PreexistingEntityException{
        miControladoraLogicaDeNegocio.crearArticulo(nombre, descripcion, codigoBarra, precioCosto, precioVenta, descuentoMayorista, cantidadReal, cantidadMin, numeroSucursal);
    }
    public void modificarArticulo(int idArticulo, String nombre, String descripcion, String codigoBarra, float precioCosto, float precioVenta, float descuentoMayorista, int idStock, int cantidadReal, int cantidadMin) throws Exception, PreexistingEntityException{
        miControladoraLogicaDeNegocio.modificarArticulo(idArticulo, nombre, descripcion, codigoBarra, precioCosto, precioVenta, descuentoMayorista, idStock, cantidadReal, cantidadMin);
    }
    public void eliminarArticulo(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        miControladoraLogicaDeNegocio.eliminarArticulo(id);
    }
    public Articulo dameMiArticulo(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiArticulo(id);
    }
    public List<Articulo> dameArticulos() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameArticulos();
    }
    
    // CLASE CLIENTE    
    // CREAR
    public void crearCliente(String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, boolean condicionCliente, String contrasenia)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearCliente(nombre, apellido, telefono, correoElectronico, domicilio, dni, cuil, condicionCliente, contrasenia);
    }
    // MODIFICAR
    public void modificarCliente(int id, String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, boolean condicionCliente, String usuario, String contrasenia) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarCliente(id, nombre, apellido, telefono, correoElectronico, domicilio, dni, cuil, condicionCliente, usuario, contrasenia);
    }
    // ELIMINAR
    public void eliminarCliente(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarCliente(id);
    }
    // DAME UNO
    public Cliente dameMiCliente(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiCliente(id);
    }
    // DAME TODOS
    public List<Cliente> dameClientes() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameClientes();
    }
    
    // CLASE TIQUE  
    // CREAR
    public void crearTique(String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, int numeroSucursal)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearTique(fechaTique, horaTique, articulos, cantidadDetalles, total, numeroSucursal);
    }
    // MODIFICAR
    public void modificarTique(int id, String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, List<Detalle> detalleEliminar, int numeroSucursal) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarTique(id, fechaTique, horaTique, articulos, cantidadDetalles, total, detalleEliminar, numeroSucursal);
    }
    // ELIMINAR
    public void eliminarTique(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarTique(id);
    }
    // DAME UNO
    public Tique dameMiTique(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiTique(id);
    }
    // DAME TODOS
    public List<Tique> dameTiques() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameTiques();
    }
    
    // CLASE SUCURSAL
    // CREAR
    public void crearSucursal(int numeroSucursal, String direccion, String telefono, String descripcion)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearSucursal(numeroSucursal, direccion, telefono, descripcion);
    }
    // MODIFICAR
    public void modificarSucursal(int id, int numeroSucursal, String direccion, String telefono, String descripcion) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarSucursal(id, numeroSucursal, direccion, telefono, descripcion);
    }
    // ELIMINAR
    public void eliminarSucursal(int id, int numeroSucursal) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarSucursal(id, numeroSucursal);
    }
    // DAME UNO
    public Sucursal dameMiSucursal(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiSucursal(id);
    }
    // DAME TODOS
    public List<Sucursal> dameSucursales() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameSucursales();
    }
    
    // CLASE FACTURA COMPRA  
    // CREAR
    public void crearFacturaCompra(Proveedor unProveedor, String numeroFactura,String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearFacturaCompra(unProveedor, numeroFactura, fechaTique, horaTique, articulos, cantidadDetalles, total);
    }
    // MODIFICAR
    public void modificarFacturaCompra(int id, String numeroFactura, String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, List<Detalle> detalleEliminar) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarFacturaCompra(id, numeroFactura, fechaTique, horaTique, articulos, cantidadDetalles, total, detalleEliminar);
    }
    // ELIMINAR
    public void eliminarFacturaCompra(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarFacturaCompra(id);
    }
    // DAME UNO
    public FacturaCompra dameMiFacturaCompra(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiFacturaCompra(id);
    }
    // DAME TODOS
    public List<FacturaCompra> dameFacturasCompras() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameFacturasCompras();
    }
    
    //CLASE EMPLEADO
    public void crearEmpleado(String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, String tipoEmpleado, float salarioMensual)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearEmpleado(nombre, apellido, telefono, correoElectronico, domicilio, dni, cuil, tipoEmpleado, salarioMensual);
    }
    public void modificarEmpleado(int id, String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, String tipoEmpleado, float salarioMensual) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarEmpleado(id, nombre, apellido, telefono, correoElectronico, domicilio, dni, cuil, tipoEmpleado, salarioMensual);
    }
    public void eliminarEmpleado(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarEmpleado(id);
    }
    public Empleado dameMiEmpleado(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiEmpleado(id);
    }
    public List<Empleado> dameEmpleados() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameEmpleados();
    }
    
    //CLASE EQUIPO
    public void crearEquipo(int idCliente, String marcaEquipo, String anioEquipo)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearEquipo(idCliente, marcaEquipo, anioEquipo);
    }
    public void modificarEquipo(int idEquipo, int idCliente, String marcaEquipo, String anioEquipo) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarEquipo(idEquipo, idCliente, marcaEquipo, anioEquipo);
    }
    public void eliminarEquipo(int idEquipo, int idCliente) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarEquipo(idEquipo, idCliente);
    }
    public Equipo dameMiEquipo(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiEquipo(id);
    }
    public List<Equipo> dameEquipos() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameEquipos();
    }
    
    //CLASE EQUIPO
    public void crearCuentaCorriente(int idCliente, double saldo)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearCuentaCorriente(idCliente, saldo);
    }
    public void modificarCuentaCorriente(int idCuentaCorriente, int idCliente, double saldo) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarCuentaCorriente(idCuentaCorriente, idCliente, saldo);
    }
    public void eliminarCuentaCorriente(int idCuentaCorriente, int idCliente) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarCuentaCorriente(idCuentaCorriente, idCliente);
    }
    public CuentaCorriente dameMiCuentaCorriente(int idCuentaCorriente)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiCuentaCorriente(idCuentaCorriente);
    }
    public List<CuentaCorriente> dameCuentasCorrientes() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameCuentasCorrientes();
    }
    
    //CLASE TECNOLOGIA
    public void crearTecnologia(String nombre, String descripcion)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearTecnologia(nombre, descripcion);
    }
    public void modificarTecnologia(int id, String nombre, String descripcion) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarTecnologia(id, nombre, descripcion);
    }
    public void eliminarTecnologia(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarTecnologia(id);
    }
    public Tecnologia dameMiTecnologia(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiTecnologia(id);
    }
    public List<Tecnologia> dameTecnologias() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameTecnologias();
    }
    
    //CLASE CUOTA
    public void crearCuota(int idProyecto, double montoCuota, String tipoCuota)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearCuota(idProyecto, montoCuota, tipoCuota);
    }
    public void modificarCuota(int idCuota, int idProyecto, double montoCuota, String tipoCuota) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarCuota(idCuota, idProyecto, montoCuota, tipoCuota);
    }
    public void eliminarCuota(int id, int idProyecto) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarCuota(id, idProyecto);
    }
    public Cuota dameMiCuota(int id)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiCuota(id);
    }
    public List<Cuota> dameCuotas() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameCuotas();
    }
    
    //CLASE PROYECTO
    public void crearProyecto(int idEncargado, String fechaInicio, String fechaFin, int horasAnalisis, int horasDisenio, int horasProgramacion, int idSucursal)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearProyecto(idEncargado, fechaInicio, fechaFin, horasAnalisis, horasDisenio, horasProgramacion, idSucursal);
    }
    public void modificarProyecto(int idProyecto, int idEncargado, String fechaInicio, String fechaFin, int horasAnalisis, int horasDisenio, int horasProgramacion, int idSucursal) throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.modificarProyecto(idProyecto, idEncargado, fechaInicio, fechaFin, horasAnalisis, horasDisenio, horasProgramacion, idSucursal);
    }
    public void eliminarProyecto(int idProyecto, int idSucursal) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarProyecto(idProyecto, idSucursal);
    }
    public Proyecto dameMiProyecto(int idProyecto)throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameMiProyecto(idProyecto);
    }
    public List<Proyecto> dameProyectos() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameProyectos();
    }
    //////////////////////////////////
    public void crearFacturaVenta(String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, int numeroSucursal, String modoPago, Cliente unCliente, String tipoCompropante)throws Exception, PreexistingEntityException{
        this.miControladoraLogicaDeNegocio.crearFacturaVenta(fechaTique, horaTique, articulos, cantidadDetalles, total, numeroSucursal, modoPago, unCliente, tipoCompropante);
    }
    
    public List<FacturaVenta> dameFacturasVentas() throws PreexistingEntityException{
        return this.miControladoraLogicaDeNegocio.dameFacturasVentas();
    }
    
    public void eliminarFacturaVenta(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miControladoraLogicaDeNegocio.eliminarFacturaVenta(id);
    }
}
