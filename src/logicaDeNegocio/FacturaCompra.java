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
public class FacturaCompra extends ComprobanteComercial{
    // Atributos
    @Basic
    private String numeroFactura;
    // Relaciones
    @OneToOne
    private Proveedor unProveedor;
    
    // Constructores
    public FacturaCompra(){
        
    }
    
    // Metodos set
    public void setUnProveedor(Proveedor unProveedor) {
        this.unProveedor = unProveedor;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }
    
    // Metodos get
    public Proveedor getUnProveedor() {
        return this.unProveedor;
    }

    public String getNumeroFactura() {
        return this.numeroFactura;
    }
    
}
