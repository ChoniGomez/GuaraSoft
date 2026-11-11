package logicaDeNegocio;

/**
 * Gestor de sesión activa del usuario autenticado en el sistema.
 */
public class SesionUsuario {

    private static SesionUsuario instancia;
    private Usuario usuarioActual;

    private SesionUsuario() {
    }

    public static synchronized SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    public void iniciarSesion(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public void cerrarSesion() {
        this.usuarioActual = null;
    }

    public Usuario getUsuarioActual() {
        return this.usuarioActual;
    }

    public boolean haySesionActiva() {
        return this.usuarioActual != null;
    }

    public boolean esSuperusuario() {
        return this.usuarioActual != null && this.usuarioActual.esSuperusuario();
    }

    public Sucursal getSucursalAsignada() {
        return this.usuarioActual != null ? this.usuarioActual.getSucursalAsignada() : null;
    }

    public boolean tieneAccesoASucursal(int numeroSucursal) {
        if (esSuperusuario() || getSucursalAsignada() == null) {
            return true;
        }
        return getSucursalAsignada().getNumeroSucursal() == numeroSucursal;
    }
}
