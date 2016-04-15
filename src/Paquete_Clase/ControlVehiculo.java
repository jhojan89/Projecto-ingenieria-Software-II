/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete_Clase;

/**
 *
 * @author Jhojan89
 */
public class ControlVehiculo {
 private String micas;
 private String tracapalanca;
 private String radio;
 private String placa;   
 private String gato;
 private String cono;
 private String triangulo;
 private  String espejos;
 private  String faros ;
 private String cerradura;
 private String vateria;

    public ControlVehiculo(String micas, String tracapalanca, String radio, String placa, String gato, String cono, String triangulo, String espejos, String faros, String cerradura, String vateria) {
        this.micas = micas="no";
        this.tracapalanca = tracapalanca="no";
        this.radio = radio="no";
        this.placa = placa="no";
        this.gato = gato="no";
        this.cono = cono="no";
        this.triangulo = triangulo="no";
        this.espejos = espejos="no";
        this.faros = faros="no";
        this.cerradura = cerradura="no";
        this.vateria = vateria="no";
    }

    public ControlVehiculo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

    public String getMicas() {
        return micas;
    }

    public void setMicas(String micas) {
        this.micas = micas;
    }

    public String getTracapalanca() {
        return tracapalanca;
    }

    public void setTracapalanca(String tracapalanca) {
        this.tracapalanca = tracapalanca;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getGato() {
        return gato;
    }

    public void setGato(String gato) {
        this.gato = gato;
    }

    public String getCono() {
        return cono;
    }

    public void setCono(String cono) {
        this.cono = cono;
    }

    public String getTriangulo() {
        return triangulo;
    }

    public void setTriangulo(String triangulo) {
        this.triangulo = triangulo;
    }

    public String getEspejos() {
        return espejos;
    }

    public void setEspejos(String espejos) {
        this.espejos = espejos;
    }

    public String getFaros() {
        return faros;
    }

    public void setFaros(String faros) {
        this.faros = faros;
    }

    public String getCerradura() {
        return cerradura;
    }

    public void setCerradura(String cerradura) {
        this.cerradura = cerradura;
    }

    public String getVateria() {
        return vateria;
    }

    public void setVateria(String vateria) {
        this.vateria = vateria;
    }
 
    
}
