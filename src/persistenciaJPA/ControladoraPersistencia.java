/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistenciaJPA;

import java.util.List;
import logicaDeNegocio.Articulo;
import logicaDeNegocio.Cliente;
import logicaDeNegocio.CuentaCorriente;
import logicaDeNegocio.Cuota;
import logicaDeNegocio.Detalle;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.Empresa;
import logicaDeNegocio.Equipo;
import logicaDeNegocio.FacturaCompra;
import logicaDeNegocio.FacturaVenta;
import logicaDeNegocio.Persona;
import logicaDeNegocio.Proveedor;
import logicaDeNegocio.Proyecto;
import logicaDeNegocio.Stock;
import logicaDeNegocio.Sucursal;
import logicaDeNegocio.Tecnologia;
import logicaDeNegocio.Tique;
import logicaDeNegocio.Turno;
import persistenciaJPA.exceptions.NonexistentEntityException;
import persistenciaJPA.exceptions.PreexistingEntityException;

/**
 *
 * @author Choni
 */
public class ControladoraPersistencia {
    ArticuloJpaController miArticuloJpa = new ArticuloJpaController();
    ClienteJpaController miClienteJpa = new ClienteJpaController();
    EmpresaJpaController miEmpresaJpa = new EmpresaJpaController();  
    ProveedorJpaController miProveedorJpa = new ProveedorJpaController();
    StockJpaController miStockJpa = new StockJpaController();
    PersonaJpaController miPersonaJpa = new PersonaJpaController();
    DetalleJpaController miDetalleJpa = new DetalleJpaController();
    SucursalJpaController miSucursalJpa = new SucursalJpaController();
    FacturaCompraJpaController miFacturaCompraJpa = new FacturaCompraJpaController();
    FacturaVentaJpaController miFacturaVentaJpa = new FacturaVentaJpaController();
    TiqueJpaController miTiqueJpa = new TiqueJpaController();
    EmpleadoJpaController miEmpleadoJpa = new EmpleadoJpaController();
    TurnoJpaController miTurnoJpa = new TurnoJpaController();
    EquipoJpaController miEquipoJpa = new EquipoJpaController();
    CuentaCorrienteJpaController miCuentaCorrienteJpa = new CuentaCorrienteJpaController();
    TecnologiaJpaController miTecnologiaJpa = new TecnologiaJpaController();
    ProyectoJpaController miProyectoJpa = new ProyectoJpaController();
    CuotaJpaController miCuotaJpa = new CuotaJpaController();
    
    public ControladoraPersistencia() {
    }
    //CLASE EMPRESA
    //CREAR
    public void crearEmpresa(Empresa unaEmpresa) throws PreexistingEntityException, Exception{
        miEmpresaJpa.create(unaEmpresa);
    }
    //MODIFICAR
    public void modificarEmpresa(Empresa unaEmpresa) throws PreexistingEntityException, Exception{
        miEmpresaJpa.edit(unaEmpresa);
    }
    //DAME UNO
    public Empresa dameMiEmpresa(String razonSocial)throws PreexistingEntityException{
        return miEmpresaJpa.findEmpresa(razonSocial);
    }
    //CLASE PROVEEDOR
    //CREAR
    public void crearProveedor(Proveedor unProveedor) throws PreexistingEntityException, Exception{
        miProveedorJpa.create(unProveedor);
    }
    //MODIFICAR
    public void modificarProveedor(Proveedor unProveedor) throws PreexistingEntityException, Exception{
        miProveedorJpa.edit(unProveedor);
    }
    //ELIMINAR
    public void eliminarProveedor(int id) throws NonexistentEntityException{
        miProveedorJpa.destroy(id);
    }
    //   DAME UNO
    public Proveedor dameMiProveedor(int id)throws PreexistingEntityException{
        return miProveedorJpa.findProveedor(id);
    }
    //   DAME TODOS
    public List<Proveedor> dameMisProveedores()throws PreexistingEntityException{
        return miProveedorJpa.findProveedorEntities();
    }
    // CLASE ARTICULO
    // CREAR
    public void crearArticulo(Articulo unArticulo)throws PreexistingEntityException, Exception{
        miArticuloJpa.create(unArticulo);
    }
    //MODIFICAR
    public void modificarArticulo(Articulo unArticulo) throws PreexistingEntityException, Exception{
        miArticuloJpa.edit(unArticulo);
    }
    //ELIMINAR
    public void eliminarArticulo(int id) throws NonexistentEntityException{
        miArticuloJpa.destroy(id);
    }
    //   DAME UNO
    public Articulo dameMiArticulo(int id)throws PreexistingEntityException{
        return miArticuloJpa.findArticulo(id);
    }
    //   DAME TODOS
    public List<Articulo> dameMisArticulos()throws PreexistingEntityException{
        return miArticuloJpa.findArticuloEntities();
    }
    // CLASE STOCK
    // CREAR
    public void crearStock(Stock unStock)throws PreexistingEntityException, Exception{
        miStockJpa.create(unStock);
    }
    //MODIFICAR
    public void modificarStock(Stock unStock) throws PreexistingEntityException, Exception{
        miStockJpa.edit(unStock);
    }
    //ELIMINAR
    public void eliminarStock(int id) throws NonexistentEntityException{
        miStockJpa.destroy(id);
    }
    //   DAME UNO
    public Stock dameMiStock(int id)throws PreexistingEntityException{
        return miStockJpa.findStock(id);
    }
    //   DAME TODOS
    public List<Stock> dameMisStocks()throws PreexistingEntityException{
        return miStockJpa.findStockEntities();
    }
    
    // CLASE CLIENTE    
    // CREAR
    public void crearCliente(Cliente unCliente)throws Exception, PreexistingEntityException{
        this.miClienteJpa.create(unCliente);
    }
    // MODIFICAR
    public void modificarCliente(Cliente unCliente) throws Exception, PreexistingEntityException{
        this.miClienteJpa.edit(unCliente);
    }
    // ELIMINAR
    public void eliminarCliente(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miClienteJpa.destroy(id);
    }
    // DAME UNO
    public Cliente dameMiCliente(int id)throws PreexistingEntityException{
        return this.miClienteJpa.findCliente(id);
    }
    // DAME TODOS
    public List<Cliente> dameClientes() throws PreexistingEntityException{
        return this.miClienteJpa.findClienteEntities();
    }
    
    // CLASE PERSONA    
    // CREAR
    public void crearPersona(Persona unaPersona)throws Exception, PreexistingEntityException{
        this.miPersonaJpa.create(unaPersona);
    }
    // MODIFICAR
    public void modificarPersona(Persona unaPersona) throws Exception, PreexistingEntityException{
        this.miPersonaJpa.edit(unaPersona);
    }
    // ELIMINAR
    public void eliminarPersona(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miPersonaJpa.destroy(id);
    }
    // DAME UNO
    public Persona dameMiPersona(int id)throws PreexistingEntityException{
        return this.miPersonaJpa.findPersona(id);
    }
    // DAME TODOS
    public List<Persona> damePersonas() throws PreexistingEntityException{
        return this.miPersonaJpa.findPersonaEntities();
    }
    
    // CLASE FACTURA COMPRA
    // CREAR
    public void crearFacturaCompra(FacturaCompra unaFacturaCompra)throws Exception, PreexistingEntityException{
        this.miFacturaCompraJpa.create(unaFacturaCompra);
    }
    // MODIFICAR
    public void modificarFacturaCompra(FacturaCompra unaFacturaCompra) throws Exception, PreexistingEntityException{
        this.miFacturaCompraJpa.edit(unaFacturaCompra);
    }
    // ELIMINAR
    public void eliminarFacturaCompra(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miFacturaCompraJpa.destroy(id);
    }
    // DAME UNO
    public FacturaCompra dameMiFacturaCompra(int id)throws PreexistingEntityException{
        return this.miFacturaCompraJpa.findFacturaCompra(id);
    }
    // DAME TODOS
    public List<FacturaCompra> dameFacturasCompras() throws PreexistingEntityException{
        return this.miFacturaCompraJpa.findFacturaCompraEntities();
    }
    
    // CLASE FACTURA VENTA
    // CREAR
    public void crearFacturaVenta(FacturaVenta unaFacturaVenta)throws Exception, PreexistingEntityException{
        this.miFacturaVentaJpa.create(unaFacturaVenta);
    }
    // MODIFICAR
    public void modificarFacturaVenta(FacturaVenta unaFacturaVenta) throws Exception, PreexistingEntityException{
        this.miFacturaVentaJpa.edit(unaFacturaVenta);
    }
    // ELIMINAR
    public void eliminarFacturaVenta(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miFacturaVentaJpa.destroy(id);
    }
    // DAME UNO
    public FacturaVenta dameMiFacturaVenta(int id)throws PreexistingEntityException{
        return this.miFacturaVentaJpa.findFacturaVenta(id);
    }
    // DAME TODOS
    public List<FacturaVenta> dameFacturasVentas() throws PreexistingEntityException{
        return this.miFacturaVentaJpa.findFacturaVentaEntities();
    }
    
    // CLASE TIQUE
    // CREAR
    public void crearTique(Tique unTique)throws Exception, PreexistingEntityException{
        this.miTiqueJpa.create(unTique);
    }
    // MODIFICAR
    public void modificarTique(Tique unTique) throws Exception, PreexistingEntityException{
        this.miTiqueJpa.edit(unTique);
    }
    // ELIMINAR
    public void eliminarTique(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miTiqueJpa.destroy(id);
    }
    // DAME UNO
    public Tique dameMiTique(int id)throws PreexistingEntityException{
        return this.miTiqueJpa.findTique(id);
    }
    // DAME TODOS
    public List<Tique> dameTiques() throws PreexistingEntityException{
        return this.miTiqueJpa.findTiqueEntities();
    }
    
    // CLASE DETALLE    
    // CREAR
    public void crearDetalle(Detalle unDetalle)throws Exception, PreexistingEntityException{
        this.miDetalleJpa.create(unDetalle);
    }
    // MODIFICAR
    public void modificarDetalle(Detalle unDetalle) throws Exception, PreexistingEntityException{
        this.miDetalleJpa.edit(unDetalle);
    }
    // ELIMINAR
    public void eliminarDetalle(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miDetalleJpa.destroy(id);
    }
    // DAME UNO
    public Detalle dameMiDetalle(int id)throws PreexistingEntityException{
        return this.miDetalleJpa.findDetalle(id);
    }
    // DAME TODOS
    public List<Detalle> dameDetalles() throws PreexistingEntityException{
        return this.miDetalleJpa.findDetalleEntities();
    }
    // CLASE SUCURSAL
    // CREAR
    public void crearSucursal(Sucursal unaSucursal)throws Exception, PreexistingEntityException{
        this.miSucursalJpa.create(unaSucursal);
    }
    // MODIFICAR
    public void modificarSucursal(Sucursal unaSucursal) throws Exception, PreexistingEntityException{
        this.miSucursalJpa.edit(unaSucursal);
    }
    // ELIMINAR
    public void eliminarSucursal(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miSucursalJpa.destroy(id);
    }
    // DAME UNO 
    public Sucursal dameMiSucursal(int id)throws PreexistingEntityException{
        return this.miSucursalJpa.findSucursal(id);
    }
    // DAME TODOS
    public List<Sucursal> dameSucursales() throws PreexistingEntityException{
        return this.miSucursalJpa.findSucursalEntities();
    }
    // CLASE EMPLEADO
    // CREAR
    public void crearEmpleado(Empleado unEmpleado)throws Exception, PreexistingEntityException{
        this.miEmpleadoJpa.create(unEmpleado);
    }
    // MODIFICAR
    public void modificarEmpleado(Empleado unEmpleado) throws Exception, PreexistingEntityException{
        this.miEmpleadoJpa.edit(unEmpleado);
    }
    // ELIMINAR
    public void eliminarEmpleado(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miEmpleadoJpa.destroy(id);
    }
    // DAME UNO 
    public Empleado dameMiEmpleado(int id)throws PreexistingEntityException{
        return this.miEmpleadoJpa.findEmpleado(id);
    }
    // DAME TODOS
    public List<Empleado> dameEmpleados() throws PreexistingEntityException{
        return this.miEmpleadoJpa.findEmpleadoEntities();
    }
    // CLASE TURNO
    // CREAR
    public void crearTurno(Turno unTurno)throws Exception, PreexistingEntityException{
        this.miTurnoJpa.create(unTurno);
    }
    // MODIFICAR
    public void modificarTurno(Turno unTurno) throws Exception, PreexistingEntityException{
        this.miTurnoJpa.edit(unTurno);
    }
    // ELIMINAR
    public void eliminarTurno(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miTurnoJpa.destroy(id);
    }
    // DAME UNO 
    public Turno dameMiTurno(int id)throws PreexistingEntityException{
        return this.miTurnoJpa.findTurno(id);
    }
    // DAME TODOS
    public List<Turno> dameTurnos() throws PreexistingEntityException{
        return this.miTurnoJpa.findTurnoEntities();
    }
    // CLASE EQUIPO
    // CREAR
    public void crearEquipo(Equipo unEquipo)throws Exception, PreexistingEntityException{
        this.miEquipoJpa.create(unEquipo);
    }
    // MODIFICAR
    public void modificarEquipo(Equipo unEquipo) throws Exception, PreexistingEntityException{
        this.miEquipoJpa.edit(unEquipo);
    }
    // ELIMINAR
    public void eliminarEquipo(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miEquipoJpa.destroy(id);
    }
    // DAME UNO 
    public Equipo dameMiEquipo(int id)throws PreexistingEntityException{
        return this.miEquipoJpa.findEquipo(id);
    }
    // DAME TODOS
    public List<Equipo> dameEquipos() throws PreexistingEntityException{
        return this.miEquipoJpa.findEquipoEntities();
    }
    // CLASE CUENTA CORRIENTE
    // CREAR
    public void crearCuentaCorriente(CuentaCorriente unaCuentaCorriente)throws Exception, PreexistingEntityException{
        this.miCuentaCorrienteJpa.create(unaCuentaCorriente);
    }
    // MODIFICAR
    public void modificarCuentaCorriente(CuentaCorriente unaCuentaCorriente) throws Exception, PreexistingEntityException{
        this.miCuentaCorrienteJpa.edit(unaCuentaCorriente);
    }
    // ELIMINAR
    public void eliminarCuentaCorriente(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miCuentaCorrienteJpa.destroy(id);
    }
    // DAME UNO 
    public CuentaCorriente dameMiCuentaCorriente(int id)throws PreexistingEntityException{
        return this.miCuentaCorrienteJpa.findCuentaCorriente(id);
    }
    // DAME TODOS
    public List<CuentaCorriente> dameCuentasCorrientes() throws PreexistingEntityException{
        return this.miCuentaCorrienteJpa.findCuentaCorrienteEntities();
    }
    // CLASE TECNOLOGIA
    // CREAR
    public void crearTecnologia(Tecnologia unaTecnologia)throws Exception, PreexistingEntityException{
        this.miTecnologiaJpa.create(unaTecnologia);
    }
    // MODIFICAR
    public void modificarTecnologia(Tecnologia unaTecnologia) throws Exception, PreexistingEntityException{
        this.miTecnologiaJpa.edit(unaTecnologia);
    }
    // ELIMINAR
    public void eliminarTecnologia(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miTecnologiaJpa.destroy(id);
    }
    // DAME UNO 
    public Tecnologia dameMiTecnologia(int id)throws PreexistingEntityException{
        return this.miTecnologiaJpa.findTecnologia(id);
    }
    // DAME TODOS
    public List<Tecnologia> dameTecnologias() throws PreexistingEntityException{
        return this.miTecnologiaJpa.findTecnologiaEntities();
    }
    // CLASE PROYECTO
    // CREAR
    public void crearProyecto(Proyecto unProyecto)throws Exception, PreexistingEntityException{
        this.miProyectoJpa.create(unProyecto);
    }
    // MODIFICAR
    public void modificarProyecto(Proyecto unProyecto) throws Exception, PreexistingEntityException{
        this.miProyectoJpa.edit(unProyecto);
    }
    // ELIMINAR
    public void eliminarProyecto(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miProyectoJpa.destroy(id);
    }
    // DAME UNO 
    public Proyecto dameMiProyecto(int id)throws PreexistingEntityException{
        return this.miProyectoJpa.findProyecto(id);
    }
    // DAME TODOS
    public List<Proyecto> dameProyectos() throws PreexistingEntityException{
        return this.miProyectoJpa.findProyectoEntities();
    }
    // CLASE CUOTA
    // CREAR
    public void crearCuota(Cuota unaCuota)throws Exception, PreexistingEntityException{
        this.miCuotaJpa.create(unaCuota);
    }
    // MODIFICAR
    public void modificarCuota(Cuota unaCuota) throws Exception, PreexistingEntityException{
        this.miCuotaJpa.edit(unaCuota);
    }
    // ELIMINAR
    public void eliminarCuota(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miCuotaJpa.destroy(id);
    }
    // DAME UNO 
    public Cuota dameMiCuota(int id)throws PreexistingEntityException{
        return this.miCuotaJpa.findCuota(id);
    }
    // DAME TODOS
    public List<Cuota> dameCuotas() throws PreexistingEntityException{
        return this.miCuotaJpa.findCuotaEntities();
    }
}
