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
        return super.toString()+ "\nCantidad de productos: " + cantidadProductos + "\nTipo de encomienda: " + tipoEncomienda ;
    }

    public static int crearServicioEncomienda(Cliente cliente_A) {
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Ingrese la fecha: ");
//        String fecha_e = sc.nextLine();
//        System.out.print("Ingrese punto de partida: ");
//        String p_inicio_e = sc.nextLine();
//        System.out.print("Ingrese punto de llegada: ");
//        String p_llegada_e = sc.nextLine();
//        Ruta ruta_e = new Ruta(p_inicio_e, p_llegada_e);
//        System.out.print("Ingrese el tipo de encomienda: ");
//        String t_encomienda = sc.nextLine();
//        TipoEncomienda T_e = TipoEncomienda.valueOf(t_encomienda.toUpperCase());
//        System.out.print("Ingrese la cantidad de items que enviará: ");
//        int cantidad_items = sc.nextInt();
//        sc.nextLine();
//        Servicio Encomienda = new EntregaEncomiendas(ruta_e, fecha_e, cantidad_items, T_e);
//        sc.close();
//        return Encomienda;
        int validarWhile=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su ubicacion:");
        String ubicacion = sc.nextLine();
        System.out.println("Ingrese su destino:");
        String destino = sc.nextLine();
        Ruta ruta = new Ruta(ubicacion, destino);
        System.out.println("Ingrese fecha del viaje en el siguiente formato(5 nov - 10:30):");
        String fecha = sc.nextLine();
        System.out.println("Ingrese tipo de encomienda: ");
        String t_encomienda = sc.nextLine();
        TipoEncomienda T_e=TipoEncomienda.valueOf(t_encomienda.toUpperCase());
        System.out.println("Ingrese la cantidad del producto enviado:");
        int cantidad=sc.nextInt();
        sc.nextLine();
        Servicio encomienda= new EntregaEncomiendas(ruta,fecha,cantidad,T_e);
        String metodo = encomienda.metodo_pago();
        System.out.println("¿Desea generar el servicio? (si/no)");
        String confirmacion = sc.nextLine();
        if (confirmacion.equals("si")) {
            String tipoVehiculo="M";
            String conductor = encomienda.asignarconductor(tipoVehiculo);
            //String linea = encomienda.getCodigo() + "," + cliente_A.getNombre() + "," + conductor + encomienda.getRuta().getpuntoPartida() + "," + encomienda.getRuta().getpuntoLlegada() + "," + encomienda.getfecha() + "," + "," + metodo + encomienda.getvalorPagar();
            //Archivos.EscribirArchivo("viajes.txt", linea);
            System.out.println("**=============Factura=============**\n" + encomienda.toString()+"\n\n");
            //=======================inicio============
            Servicio enco =(Servicio)encomienda;
            cliente_A.setListaServicio(enco);
            //========================fin===================
            
            System.out.println("¿Desea Solicitar otro Servicio? (si/no): ");
            String validar=sc.nextLine();
            if (validar.equals("si"))
                validarWhile = 1;
            else if(validar.equals("no"))
                validarWhile = 0;
            
        } else {
            validarWhile = 1;
        }
        
        
        
        return validarWhile;
    }
}
