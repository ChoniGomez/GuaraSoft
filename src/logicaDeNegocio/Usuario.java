package logicaDeNegocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entidad JPA para Usuarios, Roles, Permisos por Módulo y Sucursal asignada.
 * @author Choni
 */
@Entity
public class Usuario implements Serializable {

    public static final String ROL_SUPERUSUARIO = "SUPERUSUARIO";
    public static final String ROL_GERENTE = "GERENTE_SUCURSAL";
    public static final String ROL_OPERADOR = "OPERADOR";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;

    @Basic
    @Column(unique = true, nullable = false)
    private String nombreUsuario;

    @Basic
    private String contrasenia;

    @Basic
    private String nombreCompleto;

    @Basic
    private String rol;

    @Basic
    private boolean activo;

    @Basic
    private boolean esMasterInborrable;

    @ManyToOne
    private Sucursal sucursalAsignada;

    // Permisos granulares por módulo
    @Basic
    private boolean permisoABM;
    @Basic
    private boolean permisoEmpresa;
    @Basic
    private boolean permisoFacturacion;
    @Basic
    private boolean permisoClientes;
    @Basic
    private boolean permisoTurnos;
    @Basic
    private boolean permisoProyectos;
    @Basic
    private boolean permisoUsuarios;

    public Usuario() {
        this.activo = true;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isEsMasterInborrable() {
        return esMasterInborrable;
    }

    public void setEsMasterInborrable(boolean esMasterInborrable) {
        this.esMasterInborrable = esMasterInborrable;
    }

    public Sucursal getSucursalAsignada() {
        return sucursalAsignada;
    }

    public void setSucursalAsignada(Sucursal sucursalAsignada) {
        this.sucursalAsignada = sucursalAsignada;
    }

    public boolean isPermisoABM() {
        return esSuperusuario() || permisoABM;
    }

    public void setPermisoABM(boolean permisoABM) {
        this.permisoABM = permisoABM;
    }

    public boolean isPermisoEmpresa() {
        return esSuperusuario() || permisoEmpresa;
    }

    public void setPermisoEmpresa(boolean permisoEmpresa) {
        this.permisoEmpresa = permisoEmpresa;
    }

    public boolean isPermisoFacturacion() {
        return esSuperusuario() || permisoFacturacion;
    }

    public void setPermisoFacturacion(boolean permisoFacturacion) {
        this.permisoFacturacion = permisoFacturacion;
    }

    public boolean isPermisoClientes() {
        return esSuperusuario() || permisoClientes;
    }

    public void setPermisoClientes(boolean permisoClientes) {
        this.permisoClientes = permisoClientes;
    }

    public boolean isPermisoTurnos() {
        return esSuperusuario() || permisoTurnos;
    }

    public void setPermisoTurnos(boolean permisoTurnos) {
        this.permisoTurnos = permisoTurnos;
    }

    public boolean isPermisoProyectos() {
        return esSuperusuario() || permisoProyectos;
    }

    public void setPermisoProyectos(boolean permisoProyectos) {
        this.permisoProyectos = permisoProyectos;
    }

    public boolean isPermisoUsuarios() {
        return esSuperusuario() || permisoUsuarios;
    }

    public void setPermisoUsuarios(boolean permisoUsuarios) {
        this.permisoUsuarios = permisoUsuarios;
    }

    public boolean esSuperusuario() {
        return ROL_SUPERUSUARIO.equalsIgnoreCase(this.rol) || this.esMasterInborrable;
    }

    public boolean isId(int id) {
        return this.idUsuario == id;
    }
}
