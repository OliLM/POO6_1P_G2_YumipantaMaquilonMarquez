/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Pedido {
    protected String codigo;
    protected String nombre;
    ArrayList<Plato> carrito;
    
    public Pedido(String nombre){
        this.codigo=String.valueOf((int)(Math.random()*1000000));;
        this.nombre=nombre;
        this.carrito= new ArrayList<>();
    }
    
    public String getcodigo(){
        return codigo;
    }
    public void setcodigo(String codigo){
        this.codigo=codigo;
    }

    public ArrayList<Plato> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Plato> carrito) {
        this.carrito = carrito;
    }
    
    
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", nombre=" + nombre + ", listaPedido=" + carrito + '}';
    }
    
    
            
}
