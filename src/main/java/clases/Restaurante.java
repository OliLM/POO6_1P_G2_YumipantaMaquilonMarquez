/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
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
     public static ArrayList<Plato> crearMenu(String nombreArchivo, Restaurante restaurante) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String Encabezado;

        ArrayList<Plato> listaPlato = new ArrayList();
        try {

            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            Encabezado = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos;
                datos = linea.split(",");

                if (restaurante.getCodigo() == Integer.valueOf(datos[0])) {
                    Plato plato = new Plato(datos[1], Double.parseDouble(datos[3]), Integer.valueOf(datos[0]));
                    listaPlato.add(plato);

                }
            }
            restaurante.setListamenu(listaPlato);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return restaurante.getListamenu();
    }
}
