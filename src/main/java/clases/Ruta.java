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
public class Ruta {
    private String puntoPartida;
    private String puntoLlegada;
    
    public Ruta(String puntoPartida,String puntoLlegada){
        this.puntoPartida=puntoPartida;
        this.puntoLlegada=puntoLlegada;
    }
    
    public String getpuntoPartida(){
        return puntoPartida;
    }
    public void setpuntoPartida(String puntoPartida){
        this.puntoPartida=puntoPartida;
    }
    
    public String getpuntoLlegada(){
        return puntoLlegada;
    }
    public void setpuntoLlegada(String puntoLlegada){
        this.puntoLlegada=puntoLlegada;
    }
    
}
