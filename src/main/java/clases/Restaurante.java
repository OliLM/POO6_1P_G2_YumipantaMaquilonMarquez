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
public class Restaurante {
    private String nombre;
    private int codigo;
    private ArrayList<Plato> listamenu=new ArrayList();
   
    public Restaurante(String nombre, int codigo){
        this.codigo=codigo;
        this.nombre=nombre;
    }
    
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Plato> getListamenu() {
        return listamenu;
    }

    public void setListamenu(ArrayList<Plato> listamenu) {
        this.listamenu = listamenu;
    }
    

    @Override
    public String toString() {
        return "Restaurante{" + "nombre=" + nombre + ", codigo=" + codigo + ", listamenu=" + listamenu + '}';
    }
}
