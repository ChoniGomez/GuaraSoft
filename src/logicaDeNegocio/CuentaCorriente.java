/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Choni
 */
@Entity
public class CuentaCorriente implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCuentaCorriente;
    @Basic
    private double saldo;
    // Relaciones
    // Constructores
    public CuentaCorriente(){
        
    }
    
    // Metodos set
    public void setIdCuentaCorriente(int idCuentaCorriente) {
        this.idCuentaCorriente = idCuentaCorriente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Mettodos get
    public int getIdCuentaCorriente() {
        return this.idCuentaCorriente;
    }

    public double getSaldo() {
        return this.saldo;
    }
    
    public boolean isId(int id){
        boolean retorno = false;
        if(this.idCuentaCorriente == id){
            retorno = true;
        }
        return retorno;
    }
}
