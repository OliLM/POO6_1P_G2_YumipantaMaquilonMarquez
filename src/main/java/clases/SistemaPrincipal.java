/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enums.EstadoConductor;
import Enums.TipoVehiculo;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import static clases.EntregaEncomiendas.crearServicioEncomienda;
import static clases.ServicioDelivery.crearServicioDelivery;
//import static clases.ServicioTaxi.crearServicioTaxi;

/**
 *
 * @author ismael123
 */
public class SistemaPrincipal {

    public static void main(String[] args) {
        boolean validar = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inicio del sistema");

        while (validar == false) { //se pone un ciclo para que cuando ponga mal los datos ingrese denuevo
            System.out.println("Ingrese el usuario y contraseña");
            System.out.println("usuario: ");
            String Usuario = sc.nextLine();
            System.out.println("Contraseña: ");
            String Contraseña = sc.nextLine();
            if (IngresoSistema(Usuario.toLowerCase(), Contraseña.toLowerCase(), "usuarios.txt") == false || validardatos(Usuario) == false) {
                System.out.println("credenciales no validas");
            } else {
                System.out.println("Bienvenido al sistema");
                validar = true;
                usuario User = Crear_usuario("usuarios.txt", Usuario);
                if (User.getTipo() == 'C') {
                    if (validarcliente("Cliente.txt", User) == false) {
                        System.out.println("Cliente no registrado");
                    }
                    Cliente cliente_A = (Cliente) User;//Down casting
                    mostrarMenuCliente();
                    System.out.println("Ingrese su opcion: ");
                    int op = sc.nextInt();
                    sc.nextLine();
                    int validarWhile = 1;
                    //while (validarWhile != 0) {
                        switch (op) {
                            case 1:
                                System.out.println("/********SERVICIO TAXI********/");//ww inicio

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
                                taxi.metodo_pago();
                                
                                //ww fin

                                break;
                            case 2:
                                System.out.println("/********SERVICIO ENCOMIENDAS********/");
                                crearServicioEncomienda();

                                break;
                            case 3:
                                System.out.println("/********SERVICIO DELIVERY COMIDA********/");
                                crearServicioDelivery();

                                break;
                            case 4:
                                System.out.println("/********CONSULTAR SERVICIO********/");
                                cliente_A.ConsultarServicioAsignado();
                                break;
                            default:
                                System.out.print("Se cerró el menú");
                                
                        }
                    //}

                } else {
                    Conductor conductor_A = (Conductor) User;//Down casting
                    mostrarMenuConductor();
                    System.out.print("Ingrese su opcion: ");
                    int op = sc.nextInt();
                    sc.nextLine();
                    switch (op) {
                        case 1:
                            System.out.println("/********CONSULTAR SERVICIO********/");
                            conductor_A.ConsultarServicioAsignado();
                            break;
                        default:
                            System.out.print("Se cerró el menú");
                    }

                }
            }
        }
    }

    public static boolean validardatos(String datos) {
        return datos.matches("[a-zA-z]*");
    }

    private static boolean IngresoSistema(String user, String contraseña, String nombrearchivo) {
        boolean encontrado = false;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String Encabezado;
        try {
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            Encabezado = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos;
                datos = linea.split(",");
                String usuario = datos[3];
                String contra = datos[4];
                if (usuario.equals(user) && contraseña.equals(contra)) {
                    encontrado = true;
                }

            }
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
        if (encontrado == true) {
            return true;
        } else {
            return false;
        }

    }

    private static usuario Crear_usuario(String nombrearchivo, String User) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String Encabezado;
        usuario user_final = new usuario();
        try {

            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            Encabezado = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos;
                datos = linea.split(",");
                if (User.equals(datos[3])) {
                    if (datos[6].charAt(0) == 'R') {
                        Conductor conductor = new Conductor(datos[1], datos[2], datos[0], datos[5], datos[3], datos[4], "95754521", EstadoConductor.DISPONIBLE, TipoVehiculo.AUTO, datos[6].charAt(0));
                        //Polimorfismo de asignacion
                        user_final = conductor;
                    } else {
                        Cliente cliente = new Cliente(datos[1], datos[2], datos[0], datos[5], datos[3], datos[4], 25, 56561561, datos[6].charAt(0));
                        //Polimorfismo de asignacion
                        user_final = cliente;
                    }
                }

            }
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
        return user_final;

    }

    public static void mostrarMenuCliente() {
        System.out.println("/********MENÚ********/");
        System.out.println("/*                  */");
        System.out.println("/********************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar servicio de comida");
        System.out.println("3. Solicitar entrega encomienda");
        System.out.println("4. Consultar servicios");
    }

    public static void mostrarMenuConductor() {
        System.out.println("/********MENÚ********/");
        System.out.println("/*                  */");
        System.out.println("/********************/");
        System.out.println("1. Consultar servicio asignado");
    }

    private static boolean validarcliente(String Nombrearchivo, usuario usuario) {
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String Encabezado;
        File archivo;
        boolean valor = true;
        try {
            Encabezado = br.readLine();
            if (Encabezado == " ") {
                valor = false;
            }

        } catch (Exception e2) {

        }
        if (valor == false) {
            try {
                archivo = new File(Nombrearchivo);
                fr = new FileReader(archivo, StandardCharsets.UTF_8);
                br = new BufferedReader(fr);

                while ((linea = br.readLine()) != null) {
                    String[] datos;
                    datos = linea.split(",");
                    if (usuario.getNro_cedula().equals(datos[0])) {
                        valor = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return valor;
    }

    public ArrayList<Plato> crearMenu(String nombreArchivo, Restaurante restaurante) {
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
