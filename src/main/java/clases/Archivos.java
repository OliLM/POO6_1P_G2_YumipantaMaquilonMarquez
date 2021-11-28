/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Enums.TipoVehiculo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Archivos {

    double valorPagar;

    public static void main(String[] args) {
        
        
//        String[] servicios={"viajes.txt","encomiendas.txt"};
//        for (String nombreArchivo: servicios){
//            System.out.println(nombreArchivo);
//        
//        }
        System.out.println("hola\nwilliam\ncomo estas");
        

//        EscribirArchivo("conductoresApp.txt", "nombre,codigoUsuario,licencia,estado,codigoVehiculo\nLuis,2739,238983,D,23\nJuan,3847,293487,O,12\nMarco,3474,828737,D,15");
//        
//        String info=licenciaEstado("conductoresApp.txt","Marco");
//        System.out.println(info);
//        Archivos a=new Archivos();
//        a.metodo_pago();
//        System.out.println(a.getValorPagar());
        String letra = "nombre,codigoUsuario,licencia,estado,codigoVehiculo";

        System.out.println(letra.equals("nombre,codigoUsuario,licencia,estado,codigoVehiculo"));

    }

    //================Inicio===============
    public static void CrearArchivo(String nombreArchivo) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    //EL metodo validarContenidoArchivo valida que lo que se desea escribir, no este en el archivo.
    public static boolean validarContenidoArchivo(String nombrearchivo, String linea) {
        boolean informacion = false;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String lineaArchivo;
            while ((lineaArchivo = br.readLine()) != null) {
                
                if (lineaArchivo.equals(linea)) {
                    informacion = false;
                } else{
                    String[] datos=linea.split(",");
                    String primerdato=datos[0];
                    String[] encabezado=lineaArchivo.split(",");
                    String validarEncabezado=encabezado[0];
                    System.out.println("datos: "+datos.length+"   "+"encabezado: "+encabezado.length);
                    if(datos.length != encabezado.length){
//                        System.out.println(datos.length+"="+encabezado.length);
                        informacion = false;
                    } else{
                        informacion = true;
                    }
                    
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return informacion;

    }
    //El metodo segundaValidacion valida que el archivo este vacio
    public static boolean segundaValidacion(String nombrearchivo) {
        boolean informacion = false;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String lineaArchivo;
            lineaArchivo = br.readLine();
            if (lineaArchivo != null) {
                informacion = true;
            } else if (lineaArchivo == null) {
                informacion = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return informacion;

    }

    //================Fin==================
    //Escribe en el archivo
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            Boolean validar = validarContenidoArchivo(nombreArchivo, linea);
            if (validar == true) {
                bw.write(linea+"\n");
            } else {
                Boolean segundaValidacion = segundaValidacion(nombreArchivo);
                if (validar == false && segundaValidacion == false) {
                    bw.write(linea+"\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    //Retorna el estado(O/D) y la licencia del conductor
    public static String licenciaEstado(String nombrearchivo, String nombre) {
        String informacion = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(nombre)) {
                    informacion = datos[2] + "," + datos[3] + "," + datos[4];
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return informacion;

    }
    //retorna el tipo de vehiculo
    public static String tipo(String nombrearchivo, String code) {
        String informacion = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(code)) {
                    informacion = datos[4];

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return informacion;
    }
    
    //calcula el precio sin incremento del 10%
    public double calcularPrecio(double precio) {
        double precioFinal = precio;
        return precioFinal;
    }
    //calcula el precio con incremento del 10%
    public double calcularPrecio(double precio, double incremento) {
        double precioFinal = precio * incremento;
        return precioFinal;
    }
    //Da la opcion al cliente se desea pagar en efectivo o tarjeta
    public void metodo_pago() {
        double valor = 0;
        int validar = 1;
        Scanner sc = new Scanner(System.in);
        while (validar != 0) {
            System.out.println("Elija una opción de pago:\n1.Pago en efectivo\n2.Pago con tarjeta\nIngrese una opcion:");
            int op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    valor = calcularPrecio(valorPagar);
                    validar = 0;
                    break;
                case 2:
                    double incremento = 1.10;
                    valor = calcularPrecio(valorPagar, incremento);
                    validar = 0;
                    break;
                default:
                    System.out.println("Opcion no valida. Vuelva a elegir\n");
                    validar = 1;

            }

        }

        valorPagar = valor;
    }

    public double getValorPagar() {
        return valorPagar;
    }

}
