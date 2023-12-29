package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Cliente;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.Equipo;
import logicaDeNegocio.Estado;
import logicaDeNegocio.OrdenDeTrabajo;
import logicaDeNegocio.Sucursal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, String> descripcion;
    public static volatile SingularAttribute<Turno, Cliente> unCliente;
    public static volatile SingularAttribute<Turno, String> fechaTurno;
    public static volatile SingularAttribute<Turno, String> horaTurno;
    public static volatile SingularAttribute<Turno, Estado> unEstadoIngreso;
    public static volatile SingularAttribute<Turno, Boolean> finalizadoTurno;
    public static volatile SingularAttribute<Turno, Empleado> unEmpleado;
    public static volatile SingularAttribute<Turno, Estado> unEstadoEgreso;
    public static volatile SingularAttribute<Turno, String> tipoDeTurno;
    public static volatile SingularAttribute<Turno, Sucursal> unaSucursal;
    public static volatile SingularAttribute<Turno, Equipo> unEquipo;
    public static volatile ListAttribute<Turno, OrdenDeTrabajo> ordenesDeTrabajo;
    public static volatile SingularAttribute<Turno, Integer> idTurno;

}