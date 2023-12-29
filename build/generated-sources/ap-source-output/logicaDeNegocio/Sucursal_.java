package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Articulo;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.Proveedor;
import logicaDeNegocio.Proyecto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, Integer> idSucursal;
    public static volatile SingularAttribute<Sucursal, Integer> numeroSucursal;
    public static volatile ListAttribute<Sucursal, Proveedor> proveedores;
    public static volatile ListAttribute<Sucursal, Articulo> articulos;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile ListAttribute<Sucursal, Empleado> empleados;
    public static volatile SingularAttribute<Sucursal, String> comentarioSucursal;
    public static volatile SingularAttribute<Sucursal, String> telefono;
    public static volatile ListAttribute<Sucursal, Proyecto> proyectos;

}