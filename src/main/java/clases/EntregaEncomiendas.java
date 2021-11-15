/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author DELL
 */
public class EntregaEncomiendas extends Servicio {
    private int cantidadProductos;
    private String tipoEncomienda;
    
    public EntregaEncomiendas(String puntoPartida,String puntoLlegada,String fecha,int valorPagar,int cantidadProductos,String tipoEncomienda){
        super(puntoPartida,puntoLlegada,fecha,valorPagar);
        this.cantidadProductos=cantidadProductos;
        this.tipoEncomienda=tipoEncomienda;
    }
    public int getcantidadProductos(){
        return cantidadProductos;
    }
    public void setcantidadProductos(int cantidadProductos){
        this.cantidadProductos=cantidadProductos;
    }
    
    public String gettipoEncomienda(){
        return tipoEncomienda;
    }
    public void settipoEncomienda(String tipoEncomienda){
        this.tipoEncomienda=tipoEncomienda;
    }
    
}
