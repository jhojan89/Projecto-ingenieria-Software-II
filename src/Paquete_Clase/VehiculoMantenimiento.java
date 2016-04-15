/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete_Clase;

/**
 *
 * @author Jhojan
 */
public class VehiculoMantenimiento extends Vehiculo{
    private String Codigomantenimiento;
    private String Fecha;
    private String Estatusmantenimiento;
    private String Descripcion;

    public String getEstatusmantenimiento() {
        return Estatusmantenimiento;
    }

    public void setEstatusmantenimiento(String Estatusmantenimiento) {
        this.Estatusmantenimiento = Estatusmantenimiento;
    }
    

    public String getCodigomantenimiento() {
        return Codigomantenimiento;
    }

    public void setCodigomantenimiento(String Codigomantenimiento) {
        this.Codigomantenimiento = Codigomantenimiento;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
