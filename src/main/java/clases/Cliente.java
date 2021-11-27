/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.ArrayList;
/**
 *
 * @author ismael123
 */
public class Cliente extends usuario{
    private int edad;
    private int nro_tarjeta;
    private ArrayList<Servicio> listaServicio = new ArrayList();
    
    public Cliente(String nombre, String apellido, String nro_cedula, String celular, String usuario, String contraseña, int edad, int nro_tarjeta,char tipo){
         super(nombre,apellido,nro_cedula,celular,usuario,contraseña,tipo);
         this.edad= edad;
         this.nro_tarjeta= nro_tarjeta;
    }

    public int getEdad() {
        return edad;
    }

    public int getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNro_tarjeta(int nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }
    //========================inicio===================
    public void setListaServicio(Servicio servicio) {
        this.listaServicio.add(servicio);
    }
    //========================fin===================
    
    @Override
    public void ConsultarServicioAsignado(){
        //===============inicio============
        for(Servicio servi:listaServicio){
            if(servi instanceof ServicioTaxi){
                ServicioTaxi taxi=(ServicioTaxi)servi;
                System.out.println("Servicio de Taxi\n"+taxi.toString()+"\n");
            }
            if(servi instanceof EntregaEncomiendas){
                EntregaEncomiendas enco=(EntregaEncomiendas)servi;
                System.out.println("Servicio de Encomienda\n"+enco.toString()+"\n");
            }
            if(servi instanceof ServicioDelivery){
                ServicioDelivery Deli=(ServicioDelivery)servi;
                System.out.println("Servicio de delivery\n"+Deli.toString()+"\n");
            }
        }
       //===============Fin===================
   }
    
    @Override
    public String toString(){
        return super.toString()+"[ Edad: "+getEdad()+" Nro.Tarjeta: "+getNro_tarjeta()+"]";
    }
    
    
    
}
