/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Enums.TipoEncomienda;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class EntregaEncomiendas extends Servicio {

    private int cantidadProductos;
    private TipoEncomienda tipoEncomienda;

    public EntregaEncomiendas(Ruta ruta, String fecha, int cantidadProductos, TipoEncomienda tipoEncomienda) {
        super(ruta, fecha);
        this.cantidadProductos = cantidadProductos;
        this.tipoEncomienda = tipoEncomienda;
    }

    public int getcantidadProductos() {
        return cantidadProductos;
    }

    public void setcantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public TipoEncomienda gettipoEncomienda() {
        return tipoEncomienda;
    }

    public void settipoEncomienda(TipoEncomienda tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    @Override
    public String toString() {
        return "EntregaEncomiendas{" + "cantidadProductos=" + cantidadProductos + ", tipoEncomienda=" + tipoEncomienda + '}';
    }

    public static Servicio crearServicioEncomienda() {
        Scanner sc= new Scanner(System.in);
        System.out.print("Ingrese la fecha: ");
        String fecha_e = sc.nextLine();
        System.out.print("Ingrese punto de partida: ");
        String p_inicio_e = sc.nextLine();
        System.out.print("Ingrese punto de llegada: ");
        String p_llegada_e = sc.nextLine();
        Ruta ruta_e = new Ruta(p_inicio_e, p_llegada_e);
        System.out.print("Ingrese el tipo de encomienda: ");
        String t_encomienda = sc.nextLine();
        TipoEncomienda T_e = TipoEncomienda.valueOf(t_encomienda.toUpperCase());
        System.out.print("Ingrese la cantidad de items que enviará: ");
        int cantidad_items = sc.nextInt();
        sc.nextLine();
        Servicio Encomienda = new EntregaEncomiendas(ruta_e, fecha_e, cantidad_items, T_e);
        sc.close();
        return Encomienda;
    }
}
