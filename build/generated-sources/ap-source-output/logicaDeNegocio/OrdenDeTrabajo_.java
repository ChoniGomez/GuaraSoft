package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Articulo;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.EnvioTercero;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(OrdenDeTrabajo.class)
public class OrdenDeTrabajo_ { 

    public static volatile SingularAttribute<OrdenDeTrabajo, String> fechaSolicitud;
    public static volatile SingularAttribute<OrdenDeTrabajo, Empleado> unEmpleado;
    public static volatile SingularAttribute<OrdenDeTrabajo, Integer> tiempoEstimado;
    public static volatile SingularAttribute<OrdenDeTrabajo, Articulo> unArticulo;
    public static volatile SingularAttribute<OrdenDeTrabajo, Double> costoTotal;
    public static volatile SingularAttribute<OrdenDeTrabajo, Integer> idOrdenDeTrabajo;
    public static volatile SingularAttribute<OrdenDeTrabajo, String> tipoDeTiempo;
    public static volatile SingularAttribute<OrdenDeTrabajo, EnvioTercero> unEnvioTercero;
    public static volatile SingularAttribute<OrdenDeTrabajo, String> horaSolicitud;

}