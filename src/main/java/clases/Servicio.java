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
    public double calcularPrecio(double precio) {
        double precioFinal = precio;
        return precioFinal;
    }
    public double calcularPrecio(double precio,  double incremento){
        double precioFinal = precio*incremento;
        return precioFinal;
    }
    public void metodo_pago(){
        double valor=0;
        int validar=0;
        Scanner sc =new Scanner(System.in);
        while (validar!=0){
            System.out.println("Elija una opción de pago:\n1.Pago en efectivo\n2.Pago con tarjeta\nIngrese una opcion:");
            int op =sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    valor=calcularPrecio(valorPagar);
                    validar=0;
                    break;
                case 2:
                    double incremento =1.10;
                    valor=calcularPrecio(valorPagar,incremento);
                    validar=0;
                    break;
                default:
                    System.out.println("Opcion no valida. Vuelva a elegir\n");
                    validar=1;
                    
            }
            
        }
        
        valorPagar=valor;
    }

        
}
