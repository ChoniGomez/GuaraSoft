package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Proveedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(FacturaCompra.class)
public class FacturaCompra_ extends ComprobanteComercial_ {

    public static volatile SingularAttribute<FacturaCompra, String> numeroFactura;
    public static volatile SingularAttribute<FacturaCompra, Proveedor> unProveedor;

}