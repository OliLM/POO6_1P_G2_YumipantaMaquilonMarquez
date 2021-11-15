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
    protected int numeroServicio;
    
    public Servicio(String puntoPartida,String puntoLlegada,String fecha,int valorPagar){
        this.ruta=new Ruta(puntoPartida,puntoLlegada);
        this.fecha=fecha;
        this.valorPagar=valorPagar;
                
    }
    public String getfecha(){
        return fecha;
    }
    public void setfecha(String fecha){
     this.fecha=fecha;
    }
    
    public int getvalorPagar(){
        return valorPagar;
    }
    public void setvalorPagar(int valorPagar){
        this.valorPagar=valorPagar;
    }
    
        
}
