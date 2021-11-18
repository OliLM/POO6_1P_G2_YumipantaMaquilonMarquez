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
public class Pedido {
    protected String codigo;
    protected String nombre;
    
    public Pedido(String nombre){
        this.codigo=String.valueOf((int)(Math.random()*1000000));;
        this.nombre=nombre;
    }
    
    public String getcodigo(){
        return codigo;
    }
    public void setcodigo(String codigo){
        this.codigo=codigo;
    }
    
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
            
}
