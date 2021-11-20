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
public class ServicioTaxi extends Servicio{
    private int cantidadPersonas;
    
    //constructor
    public ServicioTaxi(Ruta ruta,String fecha,int cantidadPersonas){
        super(ruta,fecha);
        this.cantidadPersonas=cantidadPersonas;
    }
    
    public int getcantidadPersonas(){
        return cantidadPersonas;
    }
    public void setcantidadPersonas(int cantidadPersonas){
        this.cantidadPersonas=cantidadPersonas;
    }
}
