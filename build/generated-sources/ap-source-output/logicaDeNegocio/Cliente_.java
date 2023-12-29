package logicaDeNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logicaDeNegocio.CuentaCorriente;
import logicaDeNegocio.Equipo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-27T02:39:00")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Persona_ {

    public static volatile SingularAttribute<Cliente, CuentaCorriente> unaCuentaCorriente;
    public static volatile SingularAttribute<Cliente, Boolean> condicionCliente;
    public static volatile ListAttribute<Cliente, Equipo> equipos;

}