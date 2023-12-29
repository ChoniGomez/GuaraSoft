package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.Cuota;
import logicaDeNegocio.Empleado;
import logicaDeNegocio.OrdenDeTrabajo;
import logicaDeNegocio.Tecnologia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, Boolean> terminado;
    public static volatile SingularAttribute<Proyecto, Integer> horasAnalisis;
    public static volatile ListAttribute<Proyecto, Empleado> programadores;
    public static volatile SingularAttribute<Proyecto, String> fechaFin;
    public static volatile ListAttribute<Proyecto, Empleado> analistas;
    public static volatile ListAttribute<Proyecto, Tecnologia> tecnologias;
    public static volatile SingularAttribute<Proyecto, String> fechaInicio;
    public static volatile SingularAttribute<Proyecto, Integer> horasDisenio;
    public static volatile SingularAttribute<Proyecto, Empleado> unEncargado;
    public static volatile SingularAttribute<Proyecto, Integer> id;
    public static volatile ListAttribute<Proyecto, Empleado> diseniadores;
    public static volatile ListAttribute<Proyecto, Cuota> cuotas;
    public static volatile ListAttribute<Proyecto, OrdenDeTrabajo> ordenesDeTrabajo;
    public static volatile SingularAttribute<Proyecto, Integer> horasProgramacion;

}