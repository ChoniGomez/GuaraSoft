/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



/**
 *
 * @author Choni
 */
@Entity
public class Cliente extends Persona{
    // Atributos
    @Basic
    private boolean condicionCliente;
    // Relaciones
    @OneToMany
    private List<Equipo> equipos;
    @OneToOne
    private CuentaCorriente unaCuentaCorriente;
    @Basic 
    private String usuario;
    @Basic 
    private String contrasenia;
    // Constructores
    public Cliente(){
        this.equipos = new LinkedList<Equipo>();
    }
    
    // Metodos set
    public void setCondicionCliente(boolean condicionCliente) {
        this.condicionCliente = condicionCliente;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setUnaCuentaCorriente(CuentaCorriente unaCuentaCorriente) {
        this.unaCuentaCorriente = unaCuentaCorriente;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    // Metodos get
    public boolean getCondicionCliente() {
        return this.condicionCliente;
    }

    public List<Equipo> getEquipos() {
        return this.equipos;
    }

    public CuentaCorriente getUnaCuentaCorriente() {
        return this.unaCuentaCorriente;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }
    
    // Metodos
    public void addEquipo(Equipo unEquipo){
        this.equipos.add(unEquipo);
    }
    
    public boolean tieneEquipos(){
        boolean retorno = false;
        if(this.equipos.isEmpty() == true){// si mi lista esta vacia
            retorno = true;
        }
        return retorno;
    }
    
    public boolean tieneCuentaCorriente(){
        boolean retorno = true;
        if(this.unaCuentaCorriente == null){// si mi objeto es null
            retorno = false;
        }
        return retorno;
    }
    
    public boolean isUsuario(String usuario){
        boolean retorno = false;
        if(this.usuario.equalsIgnoreCase(usuario)){
            retorno = true;
        }
        return retorno;
    }
    
}
