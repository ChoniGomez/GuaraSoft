package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Articulo;
import logicaDeNegocio.Cliente;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.FacturaCompra;
import logicaDeNegocio.FacturaVenta;
import logicaDeNegocio.Proveedor;
import logicaDeNegocio.Sucursal;
import logicaDeNegocio.Tique;
import logicaDeNegocio.Turno;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, Articulo> articulos;
    public static volatile ListAttribute<Empresa, FacturaVenta> facturasVentas;
    public static volatile SingularAttribute<Empresa, String> direccion;
    public static volatile ListAttribute<Empresa, Tique> tiques;
    public static volatile ListAttribute<Empresa, Empleado> empleados;
    public static volatile ListAttribute<Empresa, Proveedor> proveedores;
    public static volatile SingularAttribute<Empresa, String> razonSocial;
    public static volatile ListAttribute<Empresa, Sucursal> sucursales;
    public static volatile SingularAttribute<Empresa, String> cuit;
    public static volatile ListAttribute<Empresa, FacturaCompra> facturasCompras;
    public static volatile ListAttribute<Empresa, Turno> turnos;
    public static volatile SingularAttribute<Empresa, String> telefono;
    public static volatile ListAttribute<Empresa, Cliente> clientes;
    public static volatile SingularAttribute<Empresa, String> correoElectronico;

}