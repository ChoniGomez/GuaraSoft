/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Choni
 */
@Entity
public class FacturaVenta extends ComprobanteComercial{
    // Atributos
    @Basic
    private String tipoComprobante;
    // Relaciones
    @OneToOne
    private Cliente unCliente;
    // Constructores
    public FacturaVenta(){
        
    }

    // Metodos get
    public Cliente getUnCliente() {
        return this.unCliente;
    }
    
    // Metodos set
    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }
    
}
