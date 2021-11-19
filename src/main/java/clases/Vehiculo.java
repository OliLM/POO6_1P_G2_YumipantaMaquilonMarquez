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
public class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    
    public Vehiculo(String placa,String modelo,String marca){
        this.marca=marca;
        this.modelo=modelo;
        this.placa=placa;
        
    }
    
    public String getplaca(){
        return placa;
    }
    public void setplaca(String placa){
        this.placa=placa;
    }
    public String geymodelo(){
        return modelo;
    }
    public void setmodelo(String modelo){
        this.modelo=modelo;
    }
    public String getmarca(){
        return marca;
    }
    public void setmarca(String marca){
        this.marca=marca;
    }
}
