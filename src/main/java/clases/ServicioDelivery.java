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
public class ServicioDelivery extends Servicio {

    private Pedido pedido;

    public ServicioDelivery(Ruta ruta, String fecha, String codigo, String nombre) {
        super(ruta, fecha);
        this.pedido = new Pedido(nombre);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ServicioDelivery{" + "pedido=" + pedido + '}';
    }

    public static int crearServicioDelivery(Cliente c) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la fecha: ");
        String fecha_de = sc.nextLine();
        System.out.print("Ingrese punto de partida: ");
        String p_inicio_de = sc.nextLine();
        System.out.print("Ingrese punto de llegada: ");
        String p_llegada_de = sc.nextLine();
        Ruta ruta_de = new Ruta(p_inicio_de, p_llegada_de);
        System.out.print("Ingrese el pedido: "); //Falta crear el pedido como objeto, y la clase restaurante y menú

        Servicio Delivery = new ServicioDelivery(ruta_de, fecha_de, "1234", "Williams restaurant");
        sc.close();
        return 0;
    }
}
