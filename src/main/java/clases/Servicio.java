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
public class Servicio {
    protected Ruta ruta;
    protected Conductor conductor;
    protected String fecha;
    protected int valorPagar;
    protected String codigo;
    
    public Servicio(String partida,String llegada,String fecha){
        this.ruta=new Ruta(partida,llegada);
        this.fecha=fecha;
        this.valorPagar=valorPagar;
        this.codigo=String.valueOf((int)(Math.random()*1000000));
                
    }
    public String getfecha(){
        return fecha;
    }
    public void setfecha(String fecha){
     this.fecha=fecha;
    }
    public Conductor getConductor(){
        return conductor;
    }
    public void setConductor(Conductor c){
        this.conductor= c;
    }
    public Ruta getRuta(){
        return ruta;
    }
    public void setRuta(String partida,String llegada){
        this.ruta=new Ruta(partida,llegada);
    }
    
    public int getvalorPagar(){
        return valorPagar;
    }
    public void setvalorPagar(int valorPagar){
        this.valorPagar=valorPagar;
    }
    
        
}
