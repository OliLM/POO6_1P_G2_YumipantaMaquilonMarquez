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
public class Servicio {
    protected Ruta ruta;
    protected Conductor conductor;
    protected String fecha;
    protected double valorPagar;//cambio
    protected String codigo;
    
    public Servicio(Ruta ruta,String fecha){
        this.ruta=ruta;
        this.fecha=fecha;
        this.valorPagar=50;//cambio
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
    
    public double getvalorPagar(){
        return valorPagar;
    }
    public void setvalorPagar(double valorPagar){
        this.valorPagar=valorPagar;
    }
    @Override//comienzo
    public String toString() {
        return "ruta: " + ruta.toString() + ",\nconductor: " + conductor + ",\nfecha: " + fecha + ",\nvalorPagar: " + valorPagar + ",\ncodigo: " + codigo;
    }
//    public double metodo_pago(int op) {
//        double precio = 25.60;
//        double precioFinal = 0;
//        int ingreso = 0;
//
//        while (ingreso == 0) {
//
//            //pago con tarjeta
//            if (op == 1) {
//                precioFinal = precio * 1.10;
//                ingreso = 1;
//            } else if (op == 2) {
//                precioFinal = precio;
//                ingreso = 2;
//            } else {
//                System.out.println("Dato incorrecto, vuelva a elegir");
//                ingreso = 0;
//                System.out.println("Ingrese una opcion:\n1.Pago por tarjeta\n2.Pago en efectivo");
//                Scanner sc = new Scanner(System.in);
//                int nuevaOp = sc.nextInt();
//                op = nuevaOp;
//
//            }
//
//        }
//        return precioFinal;
//    }fin
        
}
