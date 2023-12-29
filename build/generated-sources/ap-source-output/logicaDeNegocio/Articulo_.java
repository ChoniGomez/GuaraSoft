package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Stock;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(Articulo.class)
public class Articulo_ { 

    public static volatile SingularAttribute<Articulo, String> descripcion;
    public static volatile SingularAttribute<Articulo, String> codigoBarra;
    public static volatile SingularAttribute<Articulo, Integer> id;
    public static volatile SingularAttribute<Articulo, Stock> unStock;
    public static volatile SingularAttribute<Articulo, Float> precioVenta;
    public static volatile SingularAttribute<Articulo, String> nombre;
    public static volatile SingularAttribute<Articulo, Float> descuentoMayorista;
    public static volatile SingularAttribute<Articulo, Float> precioCosto;

}