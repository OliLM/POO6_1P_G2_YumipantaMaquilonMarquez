/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.Scanner;

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
    
//    public static Servicio crearServicioTaxi(){
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Ingrese la fecha: ");
//        String fecha_t= sc.nextLine();
//        System.out.print("Ingrese punto de partida: ");
//        String p_inicio= sc.nextLine();
//        System.out.print("Ingrese punto de llegada: ");
//        String p_llegada= sc.nextLine();
//        Ruta ruta_t= new Ruta(p_inicio,p_llegada);
//        System.out.print("Ingrese la cantidad de personas que viajaran: ");
//        int cantidad_p= sc.nextInt();
//        sc.nextLine();
//        //comienzo
//        Ruta ruta=new Ruta(p_inicio,p_llegada);
//        Servicio Taxi= new ServicioTaxi(ruta,fecha_t,cantidad_p);
//        sc.close();
//        return Taxi;
//    }

    @Override
    public String toString() {
        return super.toString()+"\nCantidad de personas: " + cantidadPersonas;
    }//fin
    
}
