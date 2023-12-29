package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Detalle;
import logicaDeNegocio.Sucursal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(ComprobanteComercial.class)
public abstract class ComprobanteComercial_ { 

    public static volatile SingularAttribute<ComprobanteComercial, Integer> idComprobante;
    public static volatile SingularAttribute<ComprobanteComercial, String> tipoDeComprobate;
    public static volatile ListAttribute<ComprobanteComercial, Detalle> detalles;
    public static volatile SingularAttribute<ComprobanteComercial, Sucursal> unaSucursal;
    public static volatile SingularAttribute<ComprobanteComercial, String> fechaComprobante;
    public static volatile SingularAttribute<ComprobanteComercial, String> horaComprobante;
    public static volatile SingularAttribute<ComprobanteComercial, Float> totalComprobante;

}