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
    
    //Se encuentra en el case 1 y permite crear el servicio taxi si el cliente lo solicita
 public static int crearServicioTaxi(Cliente cliente_A) {
        int validarWhile = 0;
        Scanner sc = new Scanner(System.in);

        Ruta ruta = obtenerRutaDesdeUsuario(sc);
        int personas = obtenerNumeroPersonasDesdeUsuario(sc);
        String metodo = Servicio.metodo_pago();

        if (confirmarServicio(sc)) {
            ServicioTaxi taxi = new ServicioTaxi(ruta, obtenerFechaDesdeUsuario(sc), personas);
            asignarConductor(taxi, "A"); // Se asume que tipoVehiculo es "A"

            // Resto del código para la factura, escritura en archivos, etc.

            cliente_A.setListaServicio(taxi);
            validarWhile = preguntarSolicitarOtroServicio(sc);
        } else {
            validarWhile = 0;
        }

        return validarWhile;
    }

    // Métodos adicionales para dividir responsabilidades
    private static Ruta obtenerRutaDesdeUsuario(Scanner sc) {
        System.out.println("Ingrese su ubicación:");
        String ubicacion = sc.nextLine();
        System.out.println("Ingrese su destino:");
        String destino = sc.nextLine();
        return new Ruta(ubicacion, destino);
    }
    
    private static int obtenerNumeroPersonasDesdeUsuario(Scanner sc) {
        System.out.println("Ingrese el número de personas:");
        return SistemaPrincipal.pedirDatosEnteros();
    }
    
    private static String obtenerFechaDesdeUsuario(Scanner sc) {
        System.out.println("Ingrese la fecha con el formato (dd/mm/aaaa):");
        return sc.nextLine();
    }
    
    private static boolean confirmarServicio(Scanner sc) {
        System.out.println("¿Desea generar el servicio? (si/no)");
        String confirmacion = sc.nextLine();
        return confirmacion.equalsIgnoreCase("si");
    }
    
    private static void asignarConductor(ServicioTaxi taxi, String tipoVehiculo) {
        // Aquí va la lógica para asignar un conductor al servicio de taxi,
        // considerando el tipo de vehículo (tipoVehiculo).
        // Se asume que esta lógica ya está implementada en tu código original.
    }
    
    private static int preguntarSolicitarOtroServicio(Scanner sc) {
        System.out.println("¿Desea solicitar otro servicio? (si/no)");
        String respuesta = sc.nextLine();
        return respuesta.equalsIgnoreCase("si") ? 1 : 0;
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nCantidad de personas: " + cantidadPersonas;
    }
}