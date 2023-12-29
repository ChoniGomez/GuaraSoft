/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import interfaz.VentanaEmpresaPrincipal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import persistenciaJPA.ControladoraPersistencia;
import persistenciaJPA.exceptions.NonexistentEntityException;
import persistenciaJPA.exceptions.PreexistingEntityException;

/**
 *
 * @author Choni
 */
public class GuaraSoft {
    private ControladoraPersistencia miPersistencia = new ControladoraPersistencia();
    // lista de clases
    private CopyOnWriteArrayList<Proveedor> misProveedores = new CopyOnWriteArrayList<Proveedor>();
    private CopyOnWriteArrayList<Articulo> misArticulos = new CopyOnWriteArrayList<Articulo>();
    private CopyOnWriteArrayList<Stock> misStocks = new CopyOnWriteArrayList<Stock>();
    private CopyOnWriteArrayList<Cliente> misClientes =  new CopyOnWriteArrayList<Cliente>();
    private CopyOnWriteArrayList<Sucursal> misSucursales = new CopyOnWriteArrayList<Sucursal>();
    private CopyOnWriteArrayList<Tique> misTiques = new CopyOnWriteArrayList<Tique>();
    private CopyOnWriteArrayList<FacturaVenta> misFacturasVentas = new CopyOnWriteArrayList<FacturaVenta>();
    private CopyOnWriteArrayList<FacturaCompra> misFacturasCompras = new CopyOnWriteArrayList<FacturaCompra>();
    private CopyOnWriteArrayList<Empleado> misEmpleados = new CopyOnWriteArrayList<Empleado>();
    private CopyOnWriteArrayList<Turno> misTurnos = new CopyOnWriteArrayList<Turno>();
    private CopyOnWriteArrayList<Equipo> misEquipos = new CopyOnWriteArrayList<Equipo>();
    private CopyOnWriteArrayList<CuentaCorriente> misCuentasCorrientes = new CopyOnWriteArrayList<CuentaCorriente>();
    private CopyOnWriteArrayList<Tecnologia> misTecnologias = new CopyOnWriteArrayList<Tecnologia>();
    private CopyOnWriteArrayList<Proyecto> misProyectos = new CopyOnWriteArrayList<Proyecto>();
    private CopyOnWriteArrayList<Cuota> misCuotas = new CopyOnWriteArrayList<Cuota>();
    
    public GuaraSoft(){
        
    }
    public static void main(String [] args) {
        /// INICIO
        VentanaEmpresaPrincipal miInicio = new VentanaEmpresaPrincipal();
        miInicio.setLocationRelativeTo(null);
        miInicio.setVisible(true);  
        
    }
    //CLASE EMPRESA
    
    //CLASE PROVEEDOR
    //   CREAR
    public void crearProveedor(String razonSocial, String correoElectronico, String direccion, String localidad, String telefono, String pais, String cuit, String situacionTribuaria)throws Exception, PreexistingEntityException{
        Proveedor unProveedor = new Proveedor();
        unProveedor.setRazonSocial(razonSocial);
        unProveedor.setCorreoElectronico(correoElectronico);
        unProveedor.setDireccion(direccion);
        unProveedor.setLocalidad(localidad);
        unProveedor.setTelefono(telefono);
        unProveedor.setPais(pais);
        unProveedor.setCuit(cuit);
        unProveedor.setSituacionTributaria(situacionTribuaria);
        miPersistencia.crearProveedor(unProveedor);// agrego a mi persistencia
        this.misProveedores.add(unProveedor);//agrego a mi lista
    }
    //   MODIFICAR
    public void modificarProveedor(int id, String razonSocial, String correoElectronico, String direccion, String localidad, String telefono, String pais, String cuit, String situacionTribuaria) throws Exception, PreexistingEntityException{
        Proveedor unProveedor = null;
        unProveedor = this.dameMiProveedor(id);//busco en mi persistencia
        if(unProveedor == null){// si no lo encontro en mi persistencia
            if(this.misProveedores.isEmpty() == false){
                for(Proveedor e: this.misProveedores){// lo busco en mi lista
                    if(e.isId(id)){// si es igual al id
                        unProveedor = e;// almaceo en un proveedor
                        this.misProveedores.remove(e);// lo elimino de la lista
                    }
                }
            }
        }
        unProveedor.setRazonSocial(razonSocial);
        unProveedor.setCorreoElectronico(correoElectronico);
        unProveedor.setDireccion(direccion);
        unProveedor.setLocalidad(localidad);
        unProveedor.setTelefono(telefono);
        unProveedor.setPais(pais);
        unProveedor.setCuit(cuit);
        unProveedor.setSituacionTributaria(situacionTribuaria);
        this.misProveedores.add(unProveedor);// agrego un nuevo proveedor con datos nuevos
        miPersistencia.modificarProveedor(unProveedor);// modifico en mi persistencia
    }
    //   ELIMINAR
    public void eliminarProveedor(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miPersistencia.eliminarProveedor(id);// elimino de la persistencia
        if(this.misProveedores.isEmpty() == false){
            for(Proveedor e: this.misProveedores){// elimino de mi lista
                if(e.isId(id)){// si es igual al id
                    this.misProveedores.remove(e);// lo elimino de la lista
                }
            }
        }
    }
    //   DAME UNO
    public Proveedor dameMiProveedor(int id)throws PreexistingEntityException{
        Proveedor retorno = null;
        for(Proveedor e : this.misProveedores){// buscoo en mi lista
            if(e.isId(id)){
                retorno = e;
            }
        }
        if(retorno == null){// si es igual a null busco en la persistencia
            retorno = this.miPersistencia.dameMiProveedor(id);
        }
        return retorno;
    }
    //   DAME TODOS
    public List<Proveedor> dameProveedores() throws PreexistingEntityException{
        List proveedoresPersistencia = this.miPersistencia.dameMisProveedores();// almaceno en memoria mis proveedores
        this.misProveedores.clear();// borro mi lista en memoria
        this.misProveedores.addAll(proveedoresPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misProveedores;// retorno los proveedores en memoria
    }
    // CLASE ARTICULO
    // CREAR
    public void crearArticulo(String nombre, String descripcion, String codigoBarra, float precioCosto, float precioVenta, float descuentoMayorista, int cantidadReal, int cantidadMin, int numeroSucursal) throws Exception, PreexistingEntityException{
        Sucursal miSucursal = null;
        // busco la sucursal en memoria
        for(Sucursal e : this.misSucursales){
            if(e.isSucursal(numeroSucursal)){
                miSucursal = e;
            }
        }
        Articulo unArticulo = new Articulo();
        unArticulo.setCodigoBarra(codigoBarra);
        unArticulo.setDescripcion(descripcion);
        unArticulo.setDescuentoMayorista(descuentoMayorista);
        unArticulo.setNombre(nombre);
        unArticulo.setPrecioCosto(precioCosto);
        unArticulo.setPrecioVenta(precioVenta);
        Stock unStock = new Stock();
        unStock.setCantidadReal(cantidadReal);
        unStock.setCantidadMinima(cantidadMin);
        // RELACIONO ARTICULO CON STOCK
        unArticulo.setStock(unStock);
        // RELACIONO ARTICULO CON SUCURSAL
        miSucursal.addArticulo(unArticulo);
        // PERSISTO EL OBJETO STOCK Y ARTICULO
        this.miPersistencia.crearStock(unStock);
        this.miPersistencia.crearArticulo(unArticulo);
        // AGREGO A MI LISTA LOS OBJETOS
        this.misStocks.add(unStock);
        this.misArticulos.add(unArticulo);
        // MODIFICO A MI SUCURSAL DE LA PERSISTENCIA
        this.miPersistencia.modificarSucursal(miSucursal);
        // MODIFICO A MI SUCURSAL EN MEMORIA
        this.misSucursales.remove(miSucursal);
        this.misSucursales.add(miSucursal);
    }
    // MODIFICAR
    public void modificarArticulo(int idArticulo, String nombre, String descripcion, String codigoBarra, float precioCosto, float precioVenta, float descuentoMayorista, int idStock, int cantidadReal, int cantidadMin) throws Exception, PreexistingEntityException{
        Articulo unArticulo = null;
        unArticulo = miPersistencia.dameMiArticulo(idArticulo);// lo saco de mi persistencia
        if(unArticulo == null){// si no lo encontro en mi persistencia
            if(this.misArticulos.isEmpty() == false){
                for(Articulo e: this.misArticulos){// lo busco en mi lista
                    if(e.isId(idArticulo)){// si es igual al id
                        unArticulo = e;// almaceo en mi variable
                        this.misArticulos.remove(e);// lo elimino de la lista
                    }
                }
            }
        }
        unArticulo.setNombre(nombre);
        unArticulo.setDescripcion(descripcion);
        unArticulo.setCodigoBarra(codigoBarra);
        unArticulo.setPrecioCosto(precioCosto);
        unArticulo.setPrecioVenta(precioVenta);
        unArticulo.setDescuentoMayorista(descuentoMayorista);
        Stock unStock = null;
        unStock = miPersistencia.dameMiStock(idStock);// saco el stock de mi persistencia
        if(unStock == null){// si no lo encontro en mi persistencia
            if(this.misStocks.isEmpty() == false){
                for(Stock e: this.misStocks){// lo busco en mi lista
                    if(e.isId(idStock)){// si es igual al id
                        unStock = e;// almaceo en mi variable
                        this.misStocks.remove(e);// lo elimino de la lista
                    }
                }
            }
        }
        unStock.setCantidadReal(cantidadReal);
        unStock.setCantidadMinima(cantidadMin);
        // guardo en mi persistencia
        this.miPersistencia.modificarStock(unStock);
        this.miPersistencia.modificarArticulo(unArticulo);
        // guardo en mi lista
        this.misStocks.add(unStock);
        this.misArticulos.add(unArticulo);
    }
    // ELIMINAR
    public void eliminarArticulo(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        // ELIMINAR RELACION ARTICULO - STOCK
        Articulo unArticulo = null;
        unArticulo = miPersistencia.dameMiArticulo(id);// saco de mi persistencia
        if(unArticulo == null){// si no lo encontro en mi persistencia
            if(this.misArticulos.isEmpty() == false){
                for(Articulo e: this.misArticulos){// lo busco en mi lista
                    if(e.isId(id)){// si es igual al id
                        unArticulo = e;// almaceo en mi variable
                    }
                }
            }
        }
        int idStock = unArticulo.getStock().getId();
        // elimino de mi persistencia
        miPersistencia.eliminarArticulo(id);
        miPersistencia.eliminarStock(idStock);
        // elimino de mi lista
        if(this.misArticulos.isEmpty() == false){
                for(Articulo e: this.misArticulos){// lo busco en mi lista
                    if(e.isId(id)){// si es igual al id
                        unArticulo = e;// almaceo en mi variable
                    }
                }
        }
        if(this.misStocks.isEmpty() == false){
            for(Stock e: this.misStocks){// lo busco en mi lista
                if(e.isId(idStock)){// si es igual al id
                    this.misStocks.remove(e);// lo elimino de la lista
                }
            }
        }
    }
    // DAME UNO
    public Articulo dameMiArticulo(int id) throws PreexistingEntityException{
        Articulo retorno = null;
        for(Articulo e : this.misArticulos){// buscoo en mi lista
            if(e.isId(id)){
                retorno = e;
            }
        }
        if(retorno == null){// si es igual a null busco en la persistencia
            retorno = this.miPersistencia.dameMiArticulo(id);
        }
        return retorno;
    }
    // DAME TODOS
    public List<Articulo> dameArticulos() throws PreexistingEntityException{
        List articulosPersistencia = this.miPersistencia.dameMisArticulos();// almaceno en memoria mis articulos
        this.misArticulos.clear();// borro mi lista en memoria
        this.misArticulos.addAll(articulosPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misArticulos;// retorno los articulos en memoria
    }
    // CLASE CLIENTE    
    // CREAR
    public void crearCliente(String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, boolean condicionCliente, String contrasenia)throws Exception, PreexistingEntityException{
        Cliente unCliente = new Cliente();
        String usuarioNombre = nombre.substring(0, 3);// los tres primeras letras del nombre del cliente
        String usuarioDNI = dni.substring(dni.length() - 3);// 3 ultimos digitos del dni
        unCliente.setNombre(nombre);
        unCliente.setApellido(apellido);
        unCliente.setTelefono(telefono);
        unCliente.setCorreoElectronico(correoElectronico);
        unCliente.setDomicilio(domicilio);
        unCliente.setDni(dni);
        unCliente.setCuil(cuil);
        unCliente.setCondicionCliente(condicionCliente);
        unCliente.setUnaCuentaCorriente(null);
        unCliente.setContrasenia(contrasenia);
        unCliente.setUsuario(usuarioNombre + usuarioDNI);// una combinacion es el usuario
        this.miPersistencia.crearCliente(unCliente);
    }
    // MODIFICAR
    public void modificarCliente(int id, String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, boolean condicionCliente, String usuario, String contrasenia) throws Exception, PreexistingEntityException{
        Cliente unCliente = this.miPersistencia.dameMiCliente(id);
        unCliente.setNombre(nombre);
        unCliente.setApellido(apellido);
        unCliente.setTelefono(telefono);
        unCliente.setCorreoElectronico(correoElectronico);
        unCliente.setDomicilio(domicilio);
        unCliente.setDni(dni);
        unCliente.setCuil(cuil);
        unCliente.setUsuario(usuario);
        unCliente.setContrasenia(contrasenia);
        unCliente.setCondicionCliente(condicionCliente);
        this.miPersistencia.modificarCliente(unCliente);
    }
    // ELIMINAR
    public void eliminarCliente(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        this.miPersistencia.eliminarCliente(id);
    }
    // DAME UNO
    public Cliente dameMiCliente(int id)throws PreexistingEntityException{
        return this.miPersistencia.dameMiCliente(id);
    }
    public Cliente dameMiClienteWeb(String usuario)throws PreexistingEntityException{
        List<Cliente> clientes = this.miPersistencia.dameClientes();
        Cliente retorno = null;
        for(Cliente e: clientes){
            if(e.isUsuario(usuario)){
                retorno = e;
            }
        }
        return retorno;
    }
    // DAME TODOS
    public List<Cliente> dameClientes() throws PreexistingEntityException{
        return this.miPersistencia.dameClientes();
    }
    
    // CLASE TIQUE
    // CREAR
    public void crearTique(String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, int numeroSucursal)throws Exception, PreexistingEntityException{
        Tique unTique = new Tique();
        Sucursal miSucursal = null;
        // busco la sucursal en memoria
        for(Sucursal e : this.misSucursales){
            if(e.isSucursal(numeroSucursal)){
                miSucursal = e;
            }
        }
        unTique.setUnaSucursal(miSucursal);
        unTique.setFechaComprobante(fechaTique);
        unTique.setHoraComprobante(horaTique);
        unTique.setTotalComprobante(total);
        int i = 0;// indice para las cantidades de los detalles
        for(Articulo e : articulos){
            Detalle unDetalle = new Detalle();
            unDetalle.setArticulo(e);// agrego un articulo al detalle
            int cantidadActualizada = e.getStock().getCantidadReal() - cantidadDetalles.get(i);//calculo la cantidad actualizada
            Stock unStock = e.getStock();// saco el stock para modificarlo
            unStock.setCantidadReal(cantidadActualizada);// actualizo la cantidad real del articulo
            unDetalle.setCantidad(cantidadDetalles.get(i));// agrego la cantidad de articulos al detalle
            unDetalle.setPrecioUnitario(e.getPrecioVenta());// agrego el precio unitario del articulo
            unDetalle.setPrecioTotal(e.getPrecioVenta() * cantidadDetalles.get(i));// agrego el precio total por cada renglon
            this.miPersistencia.crearDetalle(unDetalle);//persisto el detalle
            this.miPersistencia.modificarStock(unStock);// actualizo el stock del articulo
            unTique.addDetalle(unDetalle);// agrego un detalle a mi lista
            i++;// sumo el valor de mi indice
        }
        this.miPersistencia.crearTique(unTique);// persisto un tique        
    }
    
    // MODIFICAR
    public void modificarTique(int id, String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, List<Detalle> detalleEliminar, int numeroSucursal) throws Exception, PreexistingEntityException{
        Tique unTique = this.miPersistencia.dameMiTique(id);
        Sucursal miSucursal = null;
        // busco la sucursal en memoria
        for(Sucursal e : this.misSucursales){
            if(e.isSucursal(numeroSucursal)){
                miSucursal = e;
            }
        }
        unTique.setUnaSucursal(miSucursal);
        unTique.clearDetalles();//borro todos los detalles de mi tique
        unTique.setFechaComprobante(fechaTique);
        unTique.setHoraComprobante(horaTique);
        unTique.setTotalComprobante(total);
        int i = 0;// indice para las cantidades de los detalles
        // repongo la cantidad de todos los detalles
        for(Detalle e : detalleEliminar){
            Stock unStock = e.getArticulo().getStock();// obtengo el stock de cada detalle
            unStock.reponerStock(e.getCantidad());// actualizo la cantidad de mi stock
            this.miPersistencia.modificarStock(unStock);// modifico el stock de mi persistencia
        }
        // creo nuevos detalles y los agrego uno a uno
        for(Articulo e : articulos){
            Detalle unDetalle = new Detalle();
            unDetalle.setArticulo(e);// agrego un articulo al detalle
            int cantidadActualizada = e.getStock().getCantidadReal() - cantidadDetalles.get(i);//calculo la cantidad actualizada
            Stock unStock = e.getStock();// saco el stock para modificarlo
            unStock.setCantidadReal(cantidadActualizada);// actualizo la cantidad real del articulo
            unDetalle.setCantidad(cantidadDetalles.get(i));// agrego la cantidad de articulos al detalle
            unDetalle.setPrecioUnitario(e.getPrecioVenta());// agrego el precio unitario del articulo
            unDetalle.setPrecioTotal(e.getPrecioVenta() * cantidadDetalles.get(i));// agrego el precio total por cada renglon
            unTique.addDetalle(unDetalle);// agrego un detalle al tique
            this.miPersistencia.crearDetalle(unDetalle);//persisto el detalle
            this.miPersistencia.modificarStock(unStock);// actualizo el stock del articulo
            i++;// sumo el valor de mi indice
        }
        this.miPersistencia.modificarTique(unTique);
        // recorro cada detalle y lo elimino de la persistencia
        for(Detalle e : detalleEliminar){
            this.miPersistencia.eliminarDetalle(e.getId());//elimino de la persistencia
        }        
    }
    // ELIMINAR
    public void eliminarTique(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        Tique unTique = this.miPersistencia.dameMiTique(id);
        this.miPersistencia.eliminarTique(id);
        List <Detalle> detalles = unTique.getDetalles();// saco todos los detalles de mi tique
        // recorro cada detalle y lo elimino
        for(Detalle e : detalles){
            this.miPersistencia.eliminarDetalle(e.getId());//elimino de la persistencia
            Stock unStock = this.miPersistencia.dameMiStock(e.getArticulo().getStock().getId());// obtengo el stock de cada detalle
            unStock.reponerStock(e.getCantidad());// repongo la cantidad que existia en mi detalle
            this.miPersistencia.modificarStock(unStock);// modifico el stock de mi persistencia
        }
    }
    // DAME UNO
    public Tique dameMiTique(int id)throws PreexistingEntityException{
        return this.miPersistencia.dameMiTique(id);
    }
    // DAME TODOS
    public List<Tique> dameTiques() throws PreexistingEntityException{
        List tiquesPersistencia = this.miPersistencia.dameTiques();// almaceno en memoria mis tiques
        this.misTiques.clear();// borro mi lista en memoria
        this.misTiques.addAll(tiquesPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misTiques;// retorno los tiques en memoria
    }
    
    // CLASE SUCURSAL
    // CREAR
    public void crearSucursal(int numeroSucursal, String direccion, String telefono, String descripcion)throws Exception, PreexistingEntityException{
        Sucursal miSucursal = new Sucursal();
        miSucursal.setNumeroSucursal(numeroSucursal);
        miSucursal.setDireccion(direccion);
        miSucursal.setTelefono(telefono);
        miSucursal.setComentarioSucursal(descripcion);
        this.miPersistencia.crearSucursal(miSucursal);// agrego a mi persistencia
        this.misSucursales.add(miSucursal);// agrego a mi lista en memoria
    }
    
    // MODIFICAR
    public void modificarSucursal(int id, int numeroSucursal, String direccion, String telefono, String descripcion) throws Exception, PreexistingEntityException{
        Sucursal miSucursal = null;
        miSucursal = this.miPersistencia.dameMiSucursal(id);// busco en mi persistencia
        if(miSucursal == null){// si no lo encuentro en mi persistencia
            if(this.misSucursales.isEmpty() == false){
                for(Sucursal e: this.misSucursales){// lo busco en la lista en memoria
                    if(e.isId(id)){// si es igual al id
                        miSucursal = e;// almaceno en la sucursal
                        this.misSucursales.remove(e);// lo elimino de la lista en memoria
                    }
                }
            }
        }
        miSucursal.setNumeroSucursal(numeroSucursal);
        miSucursal.setDireccion(direccion);
        miSucursal.setTelefono(telefono);
        miSucursal.setComentarioSucursal(descripcion);
        this.miPersistencia.modificarSucursal(miSucursal);// modifico mi sucursal en la persistencia
        this.misSucursales.add(miSucursal);// agrego a mi lista en memoria
    }
    
    // ELIMINAR
    public void eliminarSucursal(int id, int numeroSucursal) throws PreexistingEntityException, NonexistentEntityException, Exception{
        // elimino relaciones en memoria
        Sucursal unaSucursal = this.miPersistencia.dameMiSucursal(id);
        for(FacturaVenta e : this.misFacturasVentas){
            if(e.getUnaSucursal().isSucursal(numeroSucursal)){
                e.setUnaSucursal(null);// modifico la relacion en memoria
                this.miPersistencia.modificarFacturaVenta(e);// modifico el objeto en la persistencia
            }
        }
        for(Tique e : this.misTiques){
            if(e.getUnaSucursal().isSucursal(numeroSucursal)){
                e.setUnaSucursal(null);// modifico la relacion en memoria
                this.miPersistencia.modificarTique(e);// modifico el objeto en la persistencia
            }
        }
        for(Turno e : this.misTurnos){
            if(e.getUnaSucursal().isSucursal(numeroSucursal)){
                e.setUnaSucursal(null);// modifico la relacion en memoria
                this.miPersistencia.modificarTurno(e);// modifico el objeto en la persistencia
            }
        }
        this.miPersistencia.eliminarSucursal(id);// lo elimino de mi persistencia
        for(Sucursal e: this.misSucursales){// lo busco en la lista en memoria
            if(e.isId(id)){// si es igual al id
                this.misSucursales.remove(e);// lo elimino de la lista en memoria
            }
        }
    }
    // DAME UNO
    public Sucursal dameMiSucursal(int id)throws PreexistingEntityException{
        Sucursal retorno = null;
        for(Sucursal e : this.misSucursales){// buscoo en mi lista en memoria
            if(e.isId(id)){
                retorno = e;
            }
        }
        if(retorno == null){// si es igual a null busco en la persistencia
            retorno = this.miPersistencia.dameMiSucursal(id);
        }
        return retorno;
    }
    // DAME TODOS
    public List<Sucursal> dameSucursales() throws PreexistingEntityException{
        List sucursalesPersistencia = this.miPersistencia.dameSucursales();// almaceno en memoria mis sucursales
        this.misSucursales.clear();// borro mi lista en memoria
        this.misSucursales.addAll(sucursalesPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misSucursales;// retorno las sucursales en memoria
    }
    
    // CLASE FACTURA COMPRA
    // CREAR
    public void crearFacturaCompra(Proveedor unProveedor, String numeroFactura,String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total)throws Exception, PreexistingEntityException{
        FacturaCompra miFacturaCompra = new FacturaCompra();
        miFacturaCompra.setNumeroFactura(numeroFactura);
        miFacturaCompra.setFechaComprobante(fechaTique);
        miFacturaCompra.setHoraComprobante(horaTique);
        miFacturaCompra.setTotalComprobante(total);
        miFacturaCompra.setUnProveedor(unProveedor);
        int i = 0;// indice para las cantidades de los detalles
        for(Articulo e : articulos){
            Detalle unDetalle = new Detalle();
            unDetalle.setArticulo(e);// agrego un articulo al detalle
            int cantidadActualizada = e.getStock().getCantidadReal() - cantidadDetalles.get(i);//calculo la cantidad actualizada
            Stock unStock = e.getStock();// saco el stock para modificarlo
            unStock.setCantidadReal(cantidadActualizada);// actualizo la cantidad real del articulo
            unDetalle.setCantidad(cantidadDetalles.get(i));// agrego la cantidad de articulos al detalle
            unDetalle.setPrecioUnitario(e.getPrecioVenta());// agrego el precio unitario del articulo
            unDetalle.setPrecioTotal(e.getPrecioVenta() * cantidadDetalles.get(i));// agrego el precio total por cada renglon
            this.miPersistencia.crearDetalle(unDetalle);//persisto el detalle
            this.miPersistencia.modificarStock(unStock);// actualizo el stock del articulo
            miFacturaCompra.addDetalle(unDetalle);// agrego un detalle a mi lista
            i++;// sumo el valor de mi indice
        }
        this.miPersistencia.crearFacturaCompra(miFacturaCompra);// persisto un factura de compra
    }
    // MODIFICAR
    public void modificarFacturaCompra(int id, String numeroFactura, String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, List<Detalle> detalleEliminar) throws Exception, PreexistingEntityException{
        FacturaCompra unaFacturaCompra = this.miPersistencia.dameMiFacturaCompra(id);
        unaFacturaCompra.clearDetalles();//borro todos los detalles de mi factura de compra
        unaFacturaCompra.setNumeroFactura(numeroFactura);
        unaFacturaCompra.setFechaComprobante(fechaTique);
        unaFacturaCompra.setHoraComprobante(horaTique);
        unaFacturaCompra.setTotalComprobante(total);
        int i = 0;// indice para las cantidades de los detalles
        // repongo la cantidad de todos los detalles
        for(Detalle e : detalleEliminar){
            Stock unStock = e.getArticulo().getStock();// obtengo el stock de cada detalle
            unStock.reponerStock(e.getCantidad());// actualizo la cantidad de mi stock
            this.miPersistencia.modificarStock(unStock);// modifico el stock de mi persistencia
        }
        // creo nuevos detalles y los agrego uno a uno
        for(Articulo e : articulos){
            Detalle unDetalle = new Detalle();
            unDetalle.setArticulo(e);// agrego un articulo al detalle
            int cantidadActualizada = e.getStock().getCantidadReal() - cantidadDetalles.get(i);//calculo la cantidad actualizada
            Stock unStock = e.getStock();// saco el stock para modificarlo
            unStock.setCantidadReal(cantidadActualizada);// actualizo la cantidad real del articulo
            unDetalle.setCantidad(cantidadDetalles.get(i));// agrego la cantidad de articulos al detalle
            unDetalle.setPrecioUnitario(e.getPrecioVenta());// agrego el precio unitario del articulo
            unDetalle.setPrecioTotal(e.getPrecioVenta() * cantidadDetalles.get(i));// agrego el precio total por cada renglon
            unaFacturaCompra.addDetalle(unDetalle);// agrego un detalle a la factura de compra
            this.miPersistencia.crearDetalle(unDetalle);//persisto el detalle
            this.miPersistencia.modificarStock(unStock);// actualizo el stock del articulo
            i++;// sumo el valor de mi indice
        }
        this.miPersistencia.modificarFacturaCompra(unaFacturaCompra);
        // recorro cada detalle y lo elimino de la persistencia
        for(Detalle e : detalleEliminar){
            this.miPersistencia.eliminarDetalle(e.getId());//elimino de la persistencia
        }        
    }
    // ELIMINAR
    public void eliminarFacturaCompra(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        FacturaCompra unaFacturaCompra = this.miPersistencia.dameMiFacturaCompra(id);
        this.miPersistencia.eliminarFacturaCompra(id);
        List <Detalle> detalles = unaFacturaCompra.getDetalles();// saco todos los detalles de mi factura de compra
        // recorro cada detalle y lo elimino
        for(Detalle e : detalles){
            this.miPersistencia.eliminarDetalle(e.getId());//elimino de la persistencia
            Stock unStock = this.miPersistencia.dameMiStock(e.getArticulo().getStock().getId());// obtengo el stock de cada detalle
            unStock.reponerStock(e.getCantidad());// repongo la cantidad que existia en mi detalle
            this.miPersistencia.modificarStock(unStock);// modifico el stock de mi persistencia
        }
    }
    // DAME UNO
    public FacturaCompra dameMiFacturaCompra(int id)throws PreexistingEntityException{
        return this.miPersistencia.dameMiFacturaCompra(id);
    }
    // DAME TODOS
    public List<FacturaCompra> dameFacturasCompras() throws PreexistingEntityException{
        List facturaCompraPersistencia = this.miPersistencia.dameFacturasCompras();// almaceno en memoria mis facturas de compras
        this.misFacturasCompras.clear();// borro mi lista en memoria
        this.misFacturasCompras.addAll(facturaCompraPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misFacturasCompras;// retorno las facturas de compra en memoria
    }
    
    // CLASE EMPLEADO
    // CREAR
    public void crearEmpleado(String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, String tipoEmpleado, float salarioMensual)throws Exception, PreexistingEntityException{
        Empleado miEmpleado = new Empleado();
        miEmpleado.setNombre(nombre);
        miEmpleado.setApellido(apellido);
        miEmpleado.setTelefono(telefono);
        miEmpleado.setCorreoElectronico(correoElectronico);
        miEmpleado.setDomicilio(domicilio);
        miEmpleado.setDni(dni);
        miEmpleado.setCuil(cuil);
        miEmpleado.setTipoEmpleado(tipoEmpleado);
        miEmpleado.setSalario(salarioMensual);
        miEmpleado.resetearHorasDeTrabajo();//para que empiece en cero
        this.misEmpleados.add(miEmpleado);// guardo e memoria
        this.miPersistencia.crearEmpleado(miEmpleado);// guardo en la persistencia
    }
    // MODIFICAR
    public void modificarEmpleado(int id, String nombre, String apellido, String telefono, String correoElectronico, String domicilio, String dni, String cuil, String tipoEmpleado, float salarioMensual) throws Exception, PreexistingEntityException{
        Empleado miEmpleado = null;
        miEmpleado = this.miPersistencia.dameMiEmpleado(id);// busco en mi persistencia
        if(miEmpleado == null){// si no lo encuentro en mi persistencia
            if(this.misEmpleados.isEmpty() == false){
                for(Empleado e: this.misEmpleados){// lo busco en la lista en memoria
                    if(e.isId(id)){// si es igual al id
                        miEmpleado = e;// almaceno en la sucursal
                        this.misEmpleados.remove(e);// lo elimino de la lista en memoria
                    }
                }
            }
        }
        miEmpleado.setNombre(nombre);
        miEmpleado.setApellido(apellido);
        miEmpleado.setTelefono(telefono);
        miEmpleado.setCorreoElectronico(correoElectronico);
        miEmpleado.setDomicilio(domicilio);
        miEmpleado.setDni(dni);
        miEmpleado.setCuil(cuil);
        miEmpleado.setTipoEmpleado(tipoEmpleado);
        miEmpleado.setSalario(salarioMensual);
        this.misEmpleados.add(miEmpleado);// guardo e memoria
        this.miPersistencia.modificarEmpleado(miEmpleado);// modifico en la persistencia
    }
    
    // ELIMINAR
    public void eliminarEmpleado(int id)throws PreexistingEntityException, NonexistentEntityException, Exception{
        Empleado miEmpleado = null;
        miEmpleado = this.miPersistencia.dameMiEmpleado(id);// busco en mi persistencia
        if(miEmpleado == null){// si no lo encuentro en mi persistencia
            if(this.misEmpleados.isEmpty() == false){
                for(Empleado e: this.misEmpleados){// lo busco en la lista en memoria
                    if(e.isId(id)){// si es igual al id
                        miEmpleado = e;// almaceno en la sucursal
                        this.misEmpleados.remove(e);// lo elimino de la lista en memoria
                    }
                }
            }
        }
        // ELIMINO AL EMPLEADO DE MI PERSISTENCIA
        this.miPersistencia.eliminarEmpleado(id);
    }
    
    // DAME UNO
    public Empleado dameMiEmpleado(int id)throws PreexistingEntityException{
        return this.miPersistencia.dameMiEmpleado(id);
    }
    // DAME TODOS
    public List<Empleado> dameEmpleados() throws PreexistingEntityException{
        List empleadosPersistencia = this.miPersistencia.dameEmpleados();// almaceno en memoria mis empleados
        this.misEmpleados.clear();// borro mi lista en memoria
        this.misEmpleados.addAll(empleadosPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misEmpleados;// retorno los empleado en memoria
    }
    
    // CLASE EQUIPO
    // CREAR
    public void crearEquipo(int idCliente, String marcaEquipo, String anioEquipo) throws Exception, PreexistingEntityException{
        Cliente unCliente = null;
        unCliente = this.miPersistencia.dameMiCliente(idCliente);// busco al cliente en la persistencia
        if(unCliente == null){// si no esta en la persistencia
            for(Cliente e : this.misClientes){// busco en la lista en memoria
                if(e.isId(idCliente)){
                    unCliente = e;
                }
            }
        }       
        Equipo unEquipo = new Equipo();
        unEquipo.setMarca(marcaEquipo);
        unEquipo.setAnio(anioEquipo);
        unCliente.addEquipo(unEquipo);
        // agrego a mi persistencia
        this.miPersistencia.crearEquipo(unEquipo);
        this.miPersistencia.modificarCliente(unCliente);// modifico al cliente
        // agrego en memoria
        this.misEquipos.add(unEquipo);
        for(Cliente e : this.misClientes){// busco en la lista en memoria
            if(e.isId(idCliente)){
                e.addEquipo(unEquipo);
            }
        }
    }
    // MODIFICAR
    public void modificarEquipo(int idEquipo, int idCliente, String marcaEquipo, String anioEquipo)  throws Exception, PreexistingEntityException{
        Cliente unCliente = null;
        Equipo unEquipo = null;
        int indiceCliente = -1;
        int indiceEquipo = -1;
        int indiceEquipoCliente = -1;// indice de la lista de equipos de un cliente
        for(Cliente e : this.misClientes){// busco en la lista en memoria
            if(e.isId(idCliente)){
                unCliente = e;
                indiceCliente = this.misClientes.indexOf(e);// almaceno el indice
            }
        }
        if(unCliente == null){// si no esta en memoria
            unCliente = this.miPersistencia.dameMiCliente(idCliente);// busco al cliente en la persistencia
        }    
        for(Equipo e : unCliente.getEquipos()){// busco el equipo dentro del cliente
            if(e.isId(idEquipo)){
                unEquipo = e;
                indiceEquipoCliente = unCliente.getEquipos().indexOf(e);// almaceno el indice
            }
        }
        for(Equipo e : this.misEquipos){// busco en la lista en memoria
            if(e.isId(idEquipo)){
                indiceEquipo = this.misEquipos.indexOf(e);// almaceno el indice
            }
        }
        // modifico al equipo
        unEquipo.setMarca(marcaEquipo);
        unEquipo.setAnio(anioEquipo);
        // modifico la lista en memoria
        if(indiceEquipo > -1){
            this.misEquipos.set(indiceEquipo, unEquipo);// lista de equipos en memoria
        }
        if(indiceEquipoCliente > -1){
            unCliente.getEquipos().set(indiceEquipoCliente, unEquipo);// lista de equipos en el cliente
        }
        if(indiceCliente > -1){
            this.misClientes.set(indiceCliente, unCliente);// modifico al cliente
        }
        // modifico en la persistencia
        this.miPersistencia.modificarEquipo(unEquipo);
        this.miPersistencia.modificarCliente(unCliente);
    }
    // ELIMINAR
    public void eliminarEquipo(int idEquipo, int idCliente) throws PreexistingEntityException, NonexistentEntityException, Exception{
        // eliminar relaciones
        int indiceTurno = -1;
        int indiceEquipo = -1;
        Cliente unCliente = null;
        List<Cliente> clientesPersistencia = null;
        List<Turno> turnosPersistencia = null;
        turnosPersistencia = this.miPersistencia.dameTurnos();// busco en la persistencia
        if(turnosPersistencia == null){
            for(Turno e : this.misTurnos){// busco en los turnos en memoria
                if(e.getUnEquipo().isId(idEquipo)){
                    indiceTurno = this.misTurnos.indexOf(e);
                    this.misTurnos.set(indiceTurno, null);// elimino la relacion
                    this.miPersistencia.modificarTurno(e);// modifico en la persistencia
                }
            }
        }
        clientesPersistencia = this.miPersistencia.dameClientes();// busco en la persistencia
        if(clientesPersistencia == null){
            for(Cliente e : this.misClientes){// busco en memoria
                if(e.isId(idCliente)){
                    unCliente = e;// almaceno un cliente
                }
            }
        }
        for(Equipo e : unCliente.getEquipos()){// busco el equipo dentro de un cliente
            if(e.isId(idEquipo)){
                indiceEquipo = unCliente.getEquipos().indexOf(e);
                unCliente.getEquipos().set(indiceEquipo, null);// elimino la relacion
                this.miPersistencia.modificarCliente(unCliente);// modifico en la persistencia
            }
        }
        // elimino en memoria
        for(Equipo e : this.misEquipos){
            if(e.isId(idEquipo)){
                this.misEquipos.remove(e);
            }
        }
        // elimino en la persistencia
        this.miPersistencia.eliminarEquipo(idEquipo);
    }
    // DAME UNO
    public Equipo dameMiEquipo(int idEquipo) throws PreexistingEntityException{
        Equipo unEquipo = null;
        // busco en memoria
        for(Equipo e : this.misEquipos){
            if(e.isId(idEquipo)){
                unEquipo = e;
            }
        }
        if(unEquipo == null){
            // busco en la persistencia
            unEquipo = this.miPersistencia.dameMiEquipo(idEquipo);
        }
        return unEquipo;
    }
    // DAME TODOS
    public List<Equipo> dameEquipos() throws PreexistingEntityException{
        List equiposPersistencia = this.miPersistencia.dameEquipos();// almaceno en memoria mis equipos
        this.misEquipos.clear();// borro mi lista en memoria
        this.misEquipos.addAll(equiposPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misEquipos;// retorno los equipos en memoria
    }
    
    // CLASE CUENTA CORRIENTE
    // CREAR
    public void crearCuentaCorriente(int idCliente, double saldo) throws Exception, PreexistingEntityException{
        Cliente unCliente = null;
        unCliente = this.miPersistencia.dameMiCliente(idCliente);// busco al cliente en la persistencia
        if(unCliente == null){// si no esta en la persistencia
            for(Cliente e : this.misClientes){// busco en la lista en memoria
                if(e.isId(idCliente)){
                    unCliente = e;
                }
            }
        }       
        CuentaCorriente unaCuentaCorriente = new CuentaCorriente();
        unaCuentaCorriente.setSaldo(saldo);
        unCliente.setUnaCuentaCorriente(unaCuentaCorriente);
        // agrego a mi persistencia
        this.miPersistencia.crearCuentaCorriente(unaCuentaCorriente);
        this.miPersistencia.modificarCliente(unCliente);// modifico al cliente
        // agrego en memoria
        this.misCuentasCorrientes.add(unaCuentaCorriente);
        for(Cliente e : this.misClientes){// busco en la lista en memoria
            if(e.isId(idCliente)){
                e.setUnaCuentaCorriente(unaCuentaCorriente);
            }
        }
    }
    // MODIFICAR
    public void modificarCuentaCorriente(int idCuentaCorriente, int idCliente, double saldo)  throws Exception, PreexistingEntityException{
        Cliente unCliente = null;
        CuentaCorriente unaCuentaCorriente = null;
        int indiceCliente = -1;
        int indiceCuentaCorriente = -1;
        for(Cliente e : this.misClientes){// busco en la lista en memoria
            if(e.isId(idCliente)){
                unCliente = e;
                indiceCliente = this.misClientes.indexOf(e);// almaceno el indice
            }
        }
        if(unCliente == null){// si no esta en memoria
            unCliente = this.miPersistencia.dameMiCliente(idCliente);// busco al cliente en la persistencia
        }    
        unaCuentaCorriente = unCliente.getUnaCuentaCorriente();// busco la cuenta corriente dentro del cliente
        for(CuentaCorriente e : this.misCuentasCorrientes){// busco en la lista en memoria
            if(e.isId(idCuentaCorriente)){
                indiceCuentaCorriente = this.misCuentasCorrientes.indexOf(e);// almaceno el indice
            }
        }
        // modifico al equipo
        unaCuentaCorriente.setSaldo(saldo);
        // modifico la lista en memoria
        if(indiceCuentaCorriente > -1){
            this.misCuentasCorrientes.set(indiceCuentaCorriente, unaCuentaCorriente);// lista de equipos en memoria
        }
        if(indiceCliente > -1){
            this.misClientes.set(indiceCliente, unCliente);// modifico al cliente
        }
        // modifico en la persistencia
        this.miPersistencia.modificarCuentaCorriente(unaCuentaCorriente);
        this.miPersistencia.modificarCliente(unCliente);
    }
    // ELIMINAR
    public void eliminarCuentaCorriente(int idCuentaCorriente, int idCliente) throws PreexistingEntityException, NonexistentEntityException, Exception{
        // eliminar relaciones
        Cliente unCliente = null;
        List<Cliente> clientesPersistencia = null;
        unCliente = this.miPersistencia.dameMiCliente(idCliente);// busco en la persistencia
        if(unCliente == null){
            for(Cliente e : this.misClientes){// busco en memoria
                if(e.isId(idCliente)){
                    unCliente = e;// almaceno un cliente
                }
            }
        }
        unCliente.setUnaCuentaCorriente(null);//elimino la relacion de la cuenta corriente
        this.miPersistencia.modificarCliente(unCliente);// modifico en la persistencia
        // elimino en memoria
        for(CuentaCorriente e : this.misCuentasCorrientes){
            if(e.isId(idCuentaCorriente)){
                this.misCuentasCorrientes.remove(e);
            }
        }
        // elimino en la persistencia
        this.miPersistencia.eliminarCuentaCorriente(idCuentaCorriente);
    }
    // DAME UNO
    public CuentaCorriente dameMiCuentaCorriente(int idCuentaCorriente) throws PreexistingEntityException{
        CuentaCorriente unaCuentaCorriente = null;
        // busco en memoria
        for(CuentaCorriente e : this.misCuentasCorrientes){
            if(e.isId(idCuentaCorriente)){
                unaCuentaCorriente = e;
            }
        }
        if(unaCuentaCorriente == null){
            // busco en la persistencia
            unaCuentaCorriente = this.miPersistencia.dameMiCuentaCorriente(idCuentaCorriente);
        }
        return unaCuentaCorriente;
    }
    // DAME TODOS
    public List<CuentaCorriente> dameCuentasCorrientes() throws PreexistingEntityException{
        List<CuentaCorriente> cuentasCorrientesPersistencia = this.miPersistencia.dameCuentasCorrientes();// almaceno en memoria mis cuentas corrientes
        this.misCuentasCorrientes.clear();// borro mi lista en memoria
        this.misCuentasCorrientes.addAll(cuentasCorrientesPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misCuentasCorrientes;// retorno los equipos en memoria
    }
    // CLASE TECNOLOGIA
    // CREAR
    public void crearTecnologia(String nombre, String descripcion)throws Exception, PreexistingEntityException{
        Tecnologia miTecnologia = new Tecnologia();
        miTecnologia.setNombreTecnologia(nombre);
        miTecnologia.setDescripcionTecnologia(descripcion);
        this.miPersistencia.crearTecnologia(miTecnologia);// agrego a mi persistencia
        this.misTecnologias.add(miTecnologia);// agrego a mi lista en memoria
    }
    
    // MODIFICAR
    public void modificarTecnologia(int id, String nombre, String descripcion) throws Exception, PreexistingEntityException{
        Tecnologia miTecnologia = null;
        miTecnologia = this.miPersistencia.dameMiTecnologia(id);// busco en mi persistencia
        if(miTecnologia == null){// si no lo encuentro en mi persistencia
            if(this.misTecnologias.isEmpty() == false){
                for(Tecnologia e: this.misTecnologias){// lo busco en la lista en memoria
                    if(e.isId(id)){// si es igual al id
                        miTecnologia = e;// almaceno en la sucursal
                        this.misTecnologias.remove(e);// lo elimino de la lista en memoria
                    }
                }
            }
        }
        miTecnologia.setNombreTecnologia(nombre);
        miTecnologia.setDescripcionTecnologia(descripcion);
        this.miPersistencia.modificarTecnologia(miTecnologia);// modifico mi sucursal en la persistencia
        this.misTecnologias.add(miTecnologia);// agrego a mi lista en memoria
    }
    
    // ELIMINAR
    public void eliminarTecnologia(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        // elimino relaciones en memoria
        Proyecto unProyecto = null;
        int indiceProyecto = -1;
        List<Proyecto> proyectosPersistencia = null;
        proyectosPersistencia = this.miPersistencia.dameProyectos();// busco en la persistencia
        if(proyectosPersistencia == null){
            for(Proyecto e : this.misProyectos){// busco en los turnos en memoria
                unProyecto = e;
                for(Tecnologia tec : unProyecto.getTecnologias()){
                    if(tec.isId(id)){
                        indiceProyecto = unProyecto.getTecnologias().indexOf(tec);
                        unProyecto.getTecnologias().set(indiceProyecto, null);// elimino la relacion
                        this.miPersistencia.modificarProyecto(e);// modifico en la persistencia
                    }
                }
            }
        }
        this.miPersistencia.eliminarTecnologia(id);// lo elimino de mi persistencia
        for(Tecnologia e: this.misTecnologias){// lo busco en la lista en memoria
            if(e.isId(id)){// si es igual al id
                this.misTecnologias.remove(e);// lo elimino de la lista en memoria
            }
        }
    }
    // DAME UNO
    public Tecnologia dameMiTecnologia(int id)throws PreexistingEntityException{
        Tecnologia retorno = null;
        for(Tecnologia e : this.misTecnologias){// buscoo en mi lista en memoria
            if(e.isId(id)){
                retorno = e;
            }
        }
        if(retorno == null){// si es igual a null busco en la persistencia
            retorno = this.miPersistencia.dameMiTecnologia(id);
        }
        return retorno;
    }
    // DAME TODOS
    public List<Tecnologia> dameTecnologias() throws PreexistingEntityException{
        List<Tecnologia> tecnologiasPersistencia = this.miPersistencia.dameTecnologias();// almaceno en memoria mis sucursales
        this.misTecnologias.clear();// borro mi lista en memoria
        this.misTecnologias.addAll(tecnologiasPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misTecnologias;// retorno las sucursales en memoria
    }
    // CLASE CUOTA
    // CREAR
    public void crearCuota(int idProyecto, double montoCuota, String tipoCuota)throws Exception, PreexistingEntityException{
        Cuota unaCuota = new Cuota();
        Proyecto miProyecto = null;
        int indiceProyecto = 0;//indice de proyecto
        // busco el proyecto en memoria
        for(Proyecto e : this.misProyectos){
            if(e.isId(idProyecto)){
                miProyecto = e;
                indiceProyecto = this.misProyectos.indexOf(e);
            }
        }
        if(miProyecto == null){// busco en la persistencia
            miProyecto = this.miPersistencia.dameMiProyecto(idProyecto);
        }
        unaCuota.setMonto(montoCuota);
        unaCuota.setTipoDeCuota(tipoCuota);
        miProyecto.addCuota(unaCuota);// agrego la cuota al proyecto
        this.misCuotas.add(unaCuota);//agrego la cuota en memoria
        if(indiceProyecto > -1){
            this.misProyectos.set(indiceProyecto, miProyecto);// modifico al proyecto en memoria
        }
        this.miPersistencia.crearCuota(unaCuota);// agrego la cuota en la persistencia
        this.miPersistencia.modificarProyecto(miProyecto);// modifico el proyecto en la persistencia        
    }
    
    // MODIFICAR
    public void modificarCuota(int idCuota, int idProyecto, double montoCuota, String tipoCuota) throws Exception, PreexistingEntityException{
        Cuota unaCuota = null;
        Proyecto miProyecto = null;
        int indiceProyecto = 0;
        int indiceCuota = 0;
        unaCuota = this.miPersistencia.dameMiCuota(idCuota);// busco en la persistencia
        if(unaCuota == null){
            for(Cuota e : this.misCuotas){// busco en memoria
               if(e.isCuota(idCuota)){
                   unaCuota = e;
                   indiceCuota = this.misCuotas.indexOf(e);
               }
            }
        }
        unaCuota.setMonto(montoCuota);
        unaCuota.setTipoDeCuota(tipoCuota);
        // busco el proyecto en memoria
        for(Proyecto e : this.misProyectos){
            if(e.isId(idProyecto)){
                miProyecto = e;
                indiceProyecto = this.misProyectos.indexOf(e);
            }
        }
        if(miProyecto == null){// busco en la persistencia
            miProyecto = this.miPersistencia.dameMiProyecto(idProyecto);
        }
        for(Cuota e : miProyecto.getCuotas()){
            if(e.isCuota(idCuota)){
                indiceCuota = miProyecto.getCuotas().indexOf(e);
            }
        }
        this.misCuotas.set(indiceCuota, unaCuota);// agrego en memoria
        miProyecto.getCuotas().set(indiceCuota, unaCuota);
        this.misProyectos.set(indiceProyecto, miProyecto);// modifico en memoria
        // modifico en la persistencia
        this.miPersistencia.modificarCuota(unaCuota);
        this.miPersistencia.modificarProyecto(miProyecto);
    }
    // ELIMINAR
    public void eliminarCuota(int idCuota, int idProyecto) throws PreexistingEntityException, NonexistentEntityException, Exception{
        // eliminar relaciones
        int indiceCuota = -1;
        int indiceProyecto = -1;
        Proyecto unProyecto = null;
        List<Proyecto> proyectosPersistencia = null;
        proyectosPersistencia = this.miPersistencia.dameProyectos();// busco en la persistencia
        if(proyectosPersistencia != null){
            for(Proyecto e : this.misProyectos){// busco en memoria
                if(e.isId(idProyecto)){
                    for(Cuota i : e.getCuotas()){
                        if(i.isCuota(idCuota)){
                            indiceCuota = e.getCuotas().indexOf(i);
                            e.getCuotas().set(indiceCuota, null);
                            this.miPersistencia.modificarProyecto(e);
                        }
                    }
                }
            }
        }
        // elimino en memoria
        for(Cuota e : this.misCuotas){
            if(e.isCuota(idCuota)){
                this.misCuotas.remove(e);
            }
        }
        // elimino en la persistencia
        this.miPersistencia.eliminarCuota(idCuota);
    }
    // DAME UNO
    public Cuota dameMiCuota(int id)throws PreexistingEntityException{
        Cuota retorno = null;
        for(Cuota e : this.misCuotas){// buscoo en mi lista en memoria
            if(e.isCuota(id)){
                retorno = e;
            }
        }
        if(retorno == null){// si es igual a null busco en la persistencia
            retorno = this.miPersistencia.dameMiCuota(id);
        }
        return retorno;
    }
    // DAME TODOS
    public List<Cuota> dameCuotas() throws PreexistingEntityException{
        List cuotasPersistencia = this.miPersistencia.dameCuotas();// almaceno en memoria mis cuotas
        this.misCuotas.clear();// borro mi lista en memoria
        this.misCuotas.addAll(cuotasPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misCuotas;// retorno los tiques en memoria
    }
    
    // CLASE PROYECTO   
    // CREAR
    public void crearProyecto(int idEncargado, String fechaInicio, String fechaFin, int horasAnalisis, int horasDisenio, int horasProgramacion, int idSucursal)throws Exception, PreexistingEntityException{
        Proyecto unProyecto = new Proyecto();
        Empleado unEmpleado = null;
        Sucursal unaSucursal = null;
        int indiceSucursal = 0;
        for(Sucursal e : this.misSucursales){// buscar en memoria
            if(e.isId(idSucursal)){
                unaSucursal = e;
                indiceSucursal = this.misSucursales.indexOf(e);
            }
        }
        if(unaSucursal == null){// busco en persistencia
            unaSucursal = this.miPersistencia.dameMiSucursal(idSucursal);
        }
        for(Empleado e : this.misEmpleados){// buscar en memoria
            if(e.isId(idEncargado)){
                unEmpleado = e;
            }
        }
        if(unEmpleado == null){// busco en persistencia
            unEmpleado = this.miPersistencia.dameMiEmpleado(idEncargado);
        }
        unProyecto.setTerminado(false);// no se termino
        unProyecto.setUnEncargado(unEmpleado);
        unProyecto.setFechaInicio(fechaInicio);
        unProyecto.setFechaFin(fechaFin);
        unProyecto.setHorasAnalisis(horasAnalisis);
        unProyecto.setHorasDisenio(horasDisenio);
        unProyecto.setHorasProgramacion(horasProgramacion);
        unaSucursal.addProyecto(unProyecto);
        this.misProyectos.add(unProyecto);// agrego en memoria
        this.misSucursales.set(indiceSucursal, unaSucursal);//modifico en memoria la sucursal
        this.miPersistencia.crearProyecto(unProyecto);// agrego en persistencia
        this.miPersistencia.modificarSucursal(unaSucursal);//modifico una sucursal en persistencia
    }
    // MODIFICAR
    public void modificarProyecto(int idProyecto, int idEncargado, String fechaInicio, String fechaFin, int horasAnalisis, int horasDisenio, int horasProgramacion, int idSucursal) throws Exception, PreexistingEntityException{
        Empleado unEmpleado = null;
        Sucursal unaSucursal = null;
        int indiceSucursal = 0;
        for(Sucursal e : this.misSucursales){// buscar en memoria
            if(e.isId(idSucursal)){
                unaSucursal = e;
                indiceSucursal = this.misSucursales.indexOf(e);
            }
        }
        if(unaSucursal == null){// busco en persistencia
            unaSucursal = this.miPersistencia.dameMiSucursal(idSucursal);
        }
        for(Empleado e : this.misEmpleados){// buscar en memoria
            if(e.isId(idEncargado)){
                unEmpleado = e;
            }
        }
        if(unEmpleado == null){// busco en persistencia
            unEmpleado = this.miPersistencia.dameMiEmpleado(idEncargado);
        }
        Proyecto unProyecto = null;
        int indiceProyecto = 0;//indice de proyecto
        // busco el proyecto en memoria
        for(Proyecto e : this.misProyectos){
            if(e.isId(idProyecto)){
                unProyecto = e;
                indiceProyecto = this.misProyectos.indexOf(e);
            }
        }
        if(unProyecto == null){// busco en la persistencia
            unProyecto = this.miPersistencia.dameMiProyecto(idProyecto);
        }
        unProyecto.setUnEncargado(unEmpleado);
        unProyecto.setFechaInicio(fechaInicio);
        unProyecto.setFechaFin(fechaFin);
        unProyecto.setHorasAnalisis(horasAnalisis);
        unProyecto.setHorasDisenio(horasDisenio);
        unProyecto.setHorasProgramacion(horasProgramacion);
        unaSucursal.addProyecto(unProyecto);
        this.misProyectos.add(unProyecto);// agrego en memoria
        this.misSucursales.set(indiceSucursal, unaSucursal);//modifico en memoria la sucursal
        this.miPersistencia.crearProyecto(unProyecto);// agrego en persistencia
        this.miPersistencia.modificarSucursal(unaSucursal);//modifico una sucursal en persistencia
    }
    // ELIMINAR
    public void eliminarProyecto(int idProyecto, int idSucursal) throws PreexistingEntityException, NonexistentEntityException, Exception{
        Sucursal unaSucursal = null;
        int indiceSucursal = 0;
        for(Sucursal e : this.misSucursales){// buscar en memoria
            if(e.isId(idSucursal)){
                unaSucursal = e;
                indiceSucursal = this.misSucursales.indexOf(e);
            }
        }
        if(unaSucursal == null){// busco en persistencia
            unaSucursal = this.miPersistencia.dameMiSucursal(idSucursal);
        }
        for(Proyecto e : unaSucursal.getProyectos()){// elimino la relacion
            if(e.isId(idProyecto)){
                unaSucursal.getProyectos().remove(e);
            }
        }
        for(Proyecto e : this.misProyectos){//elimino en memoria
            if(e.isId(idProyecto)){
                this.misProyectos.remove(e);
            }
        }
        this.miPersistencia.modificarSucursal(unaSucursal);
        this.miPersistencia.eliminarProyecto(idProyecto);
    }
    // DAME UNO
    public Proyecto dameMiProyecto(int idProyecto)throws PreexistingEntityException{
        Proyecto unProyecto = null;
        // busco el proyecto en memoria
        for(Proyecto e : this.misProyectos){
            if(e.isId(idProyecto)){
                unProyecto = e;
            }
        }
        if(unProyecto == null){// busco en la persistencia
            unProyecto = this.miPersistencia.dameMiProyecto(idProyecto);
        }
        return unProyecto;
    }
    // DAME TODOS
    public List<Proyecto> dameProyectos() throws PreexistingEntityException{
        List proyectosPersistencia = this.miPersistencia.dameProyectos();// almaceno en memoria mis proyectos
        this.misProyectos.clear();// borro mi lista en memoria
        this.misProyectos.addAll(proyectosPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misProyectos;// retorno los tiques en memoria
    }
    
    // CLASE FACTURA VENTA
    // CREAR
    public void crearFacturaVenta(String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, int numeroSucursal, String modoPago, Cliente unCliente, String tipoComprobante)throws Exception, PreexistingEntityException{
        FacturaVenta unaFacturaVenta = new FacturaVenta();
        Sucursal miSucursal = null;
        if(modoPago.equalsIgnoreCase("Cta. Corriente")){
            if(unCliente.tieneCuentaCorriente()){//si tiene cuenta corriente
                int idCuenta = unCliente.getUnaCuentaCorriente().getIdCuentaCorriente();
                double saldo = unCliente.getUnaCuentaCorriente().getSaldo();
                saldo = saldo + (double) total;
                this.modificarCuentaCorriente(idCuenta, unCliente.getId(), saldo);
            }else{// creo una cuenta corriente
                this.crearCuentaCorriente(unCliente.getId(), total);
            }
        }
        // busco la sucursal en memoria
        for(Sucursal e : this.misSucursales){
            if(e.isSucursal(numeroSucursal)){
                miSucursal = e;
            }
        }
        unaFacturaVenta.setUnaSucursal(miSucursal);
        unaFacturaVenta.setFechaComprobante(fechaTique);
        unaFacturaVenta.setHoraComprobante(horaTique);
        unaFacturaVenta.setTotalComprobante(total);
        unaFacturaVenta.setUnCliente(unCliente);
        unaFacturaVenta.setTipoComprobante(tipoComprobante);
        int i = 0;// indice para las cantidades de los detalles
        for(Articulo e : articulos){
            Detalle unDetalle = new Detalle();
            unDetalle.setArticulo(e);// agrego un articulo al detalle
            int cantidadActualizada = e.getStock().getCantidadReal() - cantidadDetalles.get(i);//calculo la cantidad actualizada
            Stock unStock = e.getStock();// saco el stock para modificarlo
            unStock.setCantidadReal(cantidadActualizada);// actualizo la cantidad real del articulo
            unDetalle.setCantidad(cantidadDetalles.get(i));// agrego la cantidad de articulos al detalle
            unDetalle.setPrecioUnitario(e.getPrecioVenta());// agrego el precio unitario del articulo
            unDetalle.setPrecioTotal(e.getPrecioVenta() * cantidadDetalles.get(i));// agrego el precio total por cada renglon
            this.miPersistencia.crearDetalle(unDetalle);//persisto el detalle
            this.miPersistencia.modificarStock(unStock);// actualizo el stock del articulo
            unaFacturaVenta.addDetalle(unDetalle);// agrego un detalle a mi lista
            i++;// sumo el valor de mi indice
        }
        this.miPersistencia.crearFacturaVenta(unaFacturaVenta);// persisto un tique        
    }
    
    // MODIFICAR
    public void modificarFacturaVenta(int id, String fechaTique, String horaTique, List<Articulo> articulos, List<Integer> cantidadDetalles, float total, List<Detalle> detalleEliminar, int numeroSucursal) throws Exception, PreexistingEntityException{
        Tique unTique = this.miPersistencia.dameMiTique(id);
        Sucursal miSucursal = null;
        // busco la sucursal en memoria
        for(Sucursal e : this.misSucursales){
            if(e.isSucursal(numeroSucursal)){
                miSucursal = e;
            }
        }
        unTique.setUnaSucursal(miSucursal);
        unTique.clearDetalles();//borro todos los detalles de mi tique
        unTique.setFechaComprobante(fechaTique);
        unTique.setHoraComprobante(horaTique);
        unTique.setTotalComprobante(total);
        int i = 0;// indice para las cantidades de los detalles
        // repongo la cantidad de todos los detalles
        for(Detalle e : detalleEliminar){
            Stock unStock = e.getArticulo().getStock();// obtengo el stock de cada detalle
            unStock.reponerStock(e.getCantidad());// actualizo la cantidad de mi stock
            this.miPersistencia.modificarStock(unStock);// modifico el stock de mi persistencia
        }
        // creo nuevos detalles y los agrego uno a uno
        for(Articulo e : articulos){
            Detalle unDetalle = new Detalle();
            unDetalle.setArticulo(e);// agrego un articulo al detalle
            int cantidadActualizada = e.getStock().getCantidadReal() - cantidadDetalles.get(i);//calculo la cantidad actualizada
            Stock unStock = e.getStock();// saco el stock para modificarlo
            unStock.setCantidadReal(cantidadActualizada);// actualizo la cantidad real del articulo
            unDetalle.setCantidad(cantidadDetalles.get(i));// agrego la cantidad de articulos al detalle
            unDetalle.setPrecioUnitario(e.getPrecioVenta());// agrego el precio unitario del articulo
            unDetalle.setPrecioTotal(e.getPrecioVenta() * cantidadDetalles.get(i));// agrego el precio total por cada renglon
            unTique.addDetalle(unDetalle);// agrego un detalle al tique
            this.miPersistencia.crearDetalle(unDetalle);//persisto el detalle
            this.miPersistencia.modificarStock(unStock);// actualizo el stock del articulo
            i++;// sumo el valor de mi indice
        }
        this.miPersistencia.modificarTique(unTique);
        // recorro cada detalle y lo elimino de la persistencia
        for(Detalle e : detalleEliminar){
            this.miPersistencia.eliminarDetalle(e.getId());//elimino de la persistencia
        }        
    }
    // ELIMINAR
    public void eliminarFacturaVenta(int id) throws PreexistingEntityException, NonexistentEntityException, Exception{
        FacturaVenta unaFacturaVenta = this.miPersistencia.dameMiFacturaVenta(id);
        this.miPersistencia.eliminarFacturaVenta(id);
        List <Detalle> detalles = unaFacturaVenta.getDetalles();// saco todos los detalles de mi tique
        // recorro cada detalle y lo elimino
        for(Detalle e : detalles){
            this.miPersistencia.eliminarDetalle(e.getId());//elimino de la persistencia
            Stock unStock = this.miPersistencia.dameMiStock(e.getArticulo().getStock().getId());// obtengo el stock de cada detalle
            unStock.reponerStock(e.getCantidad());// repongo la cantidad que existia en mi detalle
            this.miPersistencia.modificarStock(unStock);// modifico el stock de mi persistencia
        }
    }
    // DAME UNO
    public FacturaVenta dameMiFacturaVenta(int id)throws PreexistingEntityException{
        return this.miPersistencia.dameMiFacturaVenta(id);
    }
    // DAME TODOS
    public List<FacturaVenta> dameFacturasVentas() throws PreexistingEntityException{
        List facturasVentasPersistencia = this.miPersistencia.dameFacturasVentas();// almaceno en memoria mis tiques
        this.misFacturasVentas.clear();// borro mi lista en memoria
        this.misFacturasVentas.addAll(facturasVentasPersistencia);// agrego en memoria la lista de objetos de la persistencia
        return this.misFacturasVentas;// retorno los tiques en memoria
    }
    
    // METODO DE STOCK
    public void restarStock(int cantidad, Articulo unArticuloModificar) throws PreexistingEntityException{
        Articulo unArticulo = null;
        unArticulo = miPersistencia.dameMiArticulo(unArticuloModificar.getId());// lo saco de mi persistencia
        if(unArticulo == null){// si no lo encontro en mi persistencia
            if(this.misArticulos.isEmpty() == false){
                for(Articulo e: this.misArticulos){// lo busco en mi lista
                    if(e.isId(unArticuloModificar.getId())){// si es igual al id
                        unArticulo = e;// almaceo en mi variable
                        this.misArticulos.remove(e);// lo elimino de la lista
                    }
                }
            }
        }
        int cantidadActual = unArticulo.getStock().getCantidadReal();
        cantidadActual = cantidadActual - cantidad;
        
    }
}
