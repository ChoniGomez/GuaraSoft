/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicaDeNegocio;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 *
 * @author Choni
 */
@Entity
public class Empleado extends Persona {
    // Atributos
    @Basic
    private String tipoEmpleado;
    @Basic
    private float salario;
    @Basic
    private String horasTrabajadas;
    // constructor
    public Empleado(){
        
    }
    // metodos get
    public String getTipoEmpleado() {
        return this.tipoEmpleado;
    }

    public float getSalario() {
        return this.salario;
    }

    public String getHorasTrabajadas() {
        return this.horasTrabajadas;
    }
    
    // metodos set
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setHorasTrabajadas(String horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
    public void sumarHorasTrabajadas(int horas){
        int miHora = Integer.valueOf(this.horasTrabajadas);// convierto a entero las horas de trabajo
        miHora = miHora + horas;
        this.horasTrabajadas = String.valueOf(miHora);
    }
    
    public void resetearHorasDeTrabajo(){
        this.horasTrabajadas = "0";
    }
}
