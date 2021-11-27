/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class ServicioTaxi extends Servicio {

    private int cantidadPersonas;

    //constructor
    public ServicioTaxi(Ruta ruta, String fecha, int cantidadPersonas) {
        super(ruta, fecha);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getcantidadPersonas() {
        return cantidadPersonas;
    }

    public void setcantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public static int crearServicioTaxi(Cliente cliente_A) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Ingrese la fecha: ");
//        String fecha_t = sc.nextLine();
//        System.out.print("Ingrese punto de partida: ");
//        String p_inicio = sc.nextLine();
//        System.out.print("Ingrese punto de llegada: ");
//        String p_llegada = sc.nextLine();
//        Ruta ruta_t = new Ruta(p_inicio, p_llegada);
//        System.out.print("Ingrese la cantidad de personas que viajaran: ");
//        int cantidad_p = sc.nextInt();
//        sc.nextLine();
//        //comienzo
//        Ruta ruta = new Ruta(p_inicio, p_llegada);
//        Servicio Taxi = new ServicioTaxi(ruta, fecha_t, cantidad_p);
//        sc.close();
//        return Taxi;
        
        int validarWhile=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su ubicacion:");
        String ubicacion = sc.nextLine();
        System.out.println("Ingrese su destino:");
        String destino = sc.nextLine();
        Ruta ruta = new Ruta(ubicacion, destino);
        System.out.println("Ingrese fecha del viaje en el siguiente formato(5 nov - 10:30):");
        String fecha = sc.nextLine();
        System.out.println("Ingrese cantidad de personas:");
        int personas = sc.nextInt();
        sc.nextLine();
        ServicioTaxi taxi = new ServicioTaxi(ruta, fecha, personas);
        String metodo = taxi.metodo_pago();
        System.out.println("Desea prosegir Generar el servicio (si/no)");
        String confirmacion = sc.nextLine();
        if (confirmacion.equals("si")) {
            String tipoVehiculo="A";
            String conductor = taxi.asignarconductor(tipoVehiculo);
            String linea = taxi.getCodigo() + "," + cliente_A.getNombre() + "," + conductor + taxi.getRuta().getpuntoPartida() + "," + taxi.getRuta().getpuntoLlegada() + "," + taxi.getfecha() + "," + taxi.getcantidadPersonas() + "," + metodo + taxi.getvalorPagar();
            Archivos.EscribirArchivo("viajes.txt", linea);
            System.out.println("\\=============Factura=============//\n" + taxi.toString());
            System.out.println("¿Desea Solicitar otro Servicio? (si/no): ");
            String validar=sc.nextLine();
            if (validar.equals("si"))
                validarWhile = 0;
            else if(validar.equals("no"))
                validarWhile = 1;

            validarWhile = 0;
        } else {
            validarWhile = 1;
        }
        return validarWhile;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCantidad de personas: " + cantidadPersonas;
    }//fin

    public double valorpagar() {
        double valor = Math.random();
        return valor;
    }

    public double valorpagar(boolean v) {
        double valor = Math.random();
        double aumento = valor * 0.15;
        return (valor + aumento);

    }
}
