/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ETL;

/**
 *
 * @author alejandroruiz
 */
public class Metadata {
    private String etiqueta;
    private String valor;

    public Metadata(String etiqueta, String valor) {

        this.etiqueta = etiqueta;
        this.valor = valor;
    }

 

  

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" + "etiqueta:" + etiqueta + ", valor:" + valor + '}';
    }
    
    

    
}
