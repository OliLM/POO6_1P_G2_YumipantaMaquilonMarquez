/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.Restaurante.crearMenu;
import static clases.Restaurante.crearRestaurante;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class ServicioDelivery extends Servicio {

    private Pedido pedido;
    private String hora;

    public ServicioDelivery(Ruta ruta, String fecha, String hora, String codigo, String nombre, Pedido pedido) {
        super(ruta, fecha);
        this.pedido = pedido;
        this.hora= hora;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
    public static int crearServicioDelivery(Cliente c) throws IOException {
        Scanner sc = new Scanner(System.in);
        String resp= null;
        int validarWhile=0;
        
        System.out.println("/********SERVICIO DELIVERY COMIDA********/");
        System.out.print("Ingrese la fecha (dia/mes/año) : "); // Mejorar el tipo de dato
        String fecha_de = sc.nextLine();
        System.out.print("Ingrese la hora (hora:minutos): ");// Mejorar el tipo de dato
        String hora_de = sc.nextLine();
        System.out.print("Ingrese punto de partida: ");
        String p_inicio_de = sc.nextLine();
        System.out.print("Ingrese punto de llegada: ");
        String p_llegada_de = sc.nextLine();
        Ruta ruta_de = new Ruta(p_inicio_de, p_llegada_de);
        System.out.print("Ingrese el pedido: "); //Falta crear el pedido como objeto, y la clase restaurante y menú
        Servicio Delivery = new ServicioDelivery(ruta_de, fecha_de,hora_de,"1234", "Williams restaurant",);
        System.out.print("Ingrese el método de pago (efectivo/tarjeta de crédito): ");
        String meth_p = sc.nextLine();
        
        ArrayList<Plato> carrito_momentaneo = new ArrayList<>();
        ArrayList<Restaurante> listaRestaurante;
        do {
            System.out.print("\n");
            System.out.println("/******Lista de Restaurantes*******/");
            listaRestaurante = crearRestaurante("archivo.txt");
            for (Restaurante r : listaRestaurante) {
                System.out.println((listaRestaurante.indexOf(r) + 1) + " - " + r.getnombre());
            }
            System.out.print("Ingrese el restaurante del cual desea ordenar: ");
            int i_res = sc.nextInt();
            sc.nextLine();
            ArrayList<Plato> l_menu = crearMenu("menus.txt", listaRestaurante.get(i_res - 1));
            for (Plato p : l_menu) {
                System.out.println((l_menu.indexOf(p) + 1) + " - " + p.getNombre() + " - " + p.getPrecio());

            }
            System.out.print("Ingrese el plato que desea agregar al carrito: ");
            int op_p = sc.nextInt();
            sc.nextLine();
            carrito_momentaneo.add(l_menu.get(op_p - 1));

            System.out.print("¿Quiere añadir otro plato al carriot? (Si/No) ");
            String resp_v = sc.nextLine();
            resp = resp_v;
        } while (resp.equals("Si"));

        Pedido pedido = new Pedido(c.getNombre());
        pedido.setCarrito(carrito_momentaneo);

        double subtotal = 0;
        for (Plato p : pedido.getCarrito()) {
            subtotal = 0;
            subtotal += p.getPrecio();
        }
        //Creacion del objeto Delivery y asignacion del valor a pagar

        System.out.println("Desea generar el servicio (si/no)");
        String confirmacion_de = sc.nextLine();
        if (confirmacion_de.equals("si")) {
            Servicio Delivery = new ServicioDelivery(ruta_de, fecha_de, hora_de, "1234", c.getNombre(), pedido);
            Delivery.setvalorPagar(Delivery.calcularTotalServicios(meth_p, subtotal));
            String conductor = Delivery.asignarconductor("MOTO");
            String linea = Delivery.getCodigo() + "," + c.getNombre() + "," + conductor + "," + Delivery.getRuta().getpuntoPartida() + "," + Delivery.getRuta().getpuntoLlegada() + "," + Delivery.getfecha() + "," + hora_de + "," + pedido.getcodigo() + "," + meth_p + "," + Delivery.getvalorPagar();
            Archivos.EscribirArchivo("delivery.txt", linea);
            System.out.println("Factura :\n" + Delivery.toString());

            System.out.println("¿Desea Solicitar otro Servicio? (si/no): ");
            String validar=sc.nextLine();
            
            if (validar.equals("si"))
                validarWhile = 1;
            else if(validar.equals("no"))
                validarWhile = 0;
            validarWhile = 0;
        } else {
            validarWhile = 1;
        }

        sc.close();
        return validarWhile;
    }
    
    
   
        

        
        
}
