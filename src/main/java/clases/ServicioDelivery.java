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
public class ServicioDelivery extends Servicio{
    private Pedido pedido;
    
    public ServicioDelivery(Ruta ruta,String fecha,String codigo,String nombre){
        super(ruta,fecha);
        this.pedido=new Pedido(nombre);
    }
    
}
