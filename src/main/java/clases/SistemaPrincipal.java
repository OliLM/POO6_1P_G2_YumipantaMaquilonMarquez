/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Enums.EstadoConductor;
import Enums.TipoEncomienda;
import Enums.TipoVehiculo;
import static clases.Archivos.EscribirArchivo;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import static clases.EntregaEncomienda.crearServicioEncomienda;
import static clases.ServicioDelivery.crearServicioDelivery;
//import static clases.ServicioTaxi.crearServicioTaxi;

/**
 *
 * @author ismael123
 */
public class SistemaPrincipal {

    public static void main(String[] args) {
        //=============  Inicio============
        Archivos.EscribirArchivo("conductoresApp.txt", "nombre,codigoUsuario,licencia,estado,codigoVehiculo\nAlex,2739,238983,D,23\nJuan,3847,293487,D,12\nPedro,3474,828737,D,15");
        Archivos.EscribirArchivo("vehiculo.txt", "codigoVehiculo,placa,modelo,marca,tipo\n23,GSX3847,CX3,Mazda,A\n12,GSD8475,Aveo,Cherolet,A\n15,GAF9833,I10,Hyundai,M");
        Archivos.EscribirArchivo("viajes.txt", "numeroServicio,nombreCliente,nombreConductor,desde,hasta,fecha,hora,numeroPasajeros,tipoPago,valorPagar");
        Archivos.EscribirArchivo("encomiendas.txt", "numeroServicio,nombreCliente,nombreConductor,desde,hasta,fecha,hora,tipoEncomienda,cantidadProductos,tipoPago,valorPagar");
        //=============== Fin ===============
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
                Usuario User = Crear_usuario("usuarios.txt", Usuario);
                if (User.getTipo() == 'C') {
                    if (validarcliente("Clientes.txt", User) == false) {
                        System.out.println("Cliente no registrado");
                        System.out.println("Ingrese su edad");
                        int edad = sc.nextInt();
                        System.out.println("Ingres el numero de tarjeta de credito");
                        String tarjeta = sc.next();
                        registrar_cliente(edad, tarjeta, User.getNro_cedula(), "Clientes.txt");
                    }
                    System.out.println("Cliente registrado");
                    Cliente cliente_A = (Cliente) User;//Down casting

                    int validarWhile = 1;
                    while (validarWhile != 0) {
                        mostrarMenuCliente();
                        System.out.println("Ingrese su opcion: ");
                        int op = sc.nextInt();
                        sc.nextLine();

                        switch (op) {
                            case 1:
                                System.out.println("/********SERVICIO TAXI********/");
                                validarWhile = ServicioTaxi.crearServicioTaxi(cliente_A);
//                                
                                break;
                            case 2:
                                System.out.println("/********SERVICIO ENCOMIENDAS********/");
                                validarWhile = EntregaEncomienda.crearServicioEncomienda(cliente_A);

                                break;
                            case 3:
                                System.out.println("/********SERVICIO DELIVERY COMIDA********/");
                                ServicioDelivery.crearServicioDelivery(cliente_A);
                                validarWhile = 0;
                                break;
                            case 4:
                                System.out.println("/********CONSULTAR SERVICIO********/");
                                validarWhile = cliente_A.ConsultarServicioAsignado();

                                break;
                            default:
                                System.out.print("Opcion no valida. Vuelva a seleccionar.");
                                validarWhile = 1;
                                break;

                        }
                    }

                } else {
                    Conductor conductor_A = (Conductor) User;//Down casting
                    int validarWhile = 1;
                    while (validarWhile != 0) {

                        mostrarMenuConductor();
                        System.out.println("Ingrese su opcion: ");
                        int op = sc.nextInt();
                        sc.nextLine();
                        switch (op) {
                            case 1:
                                System.out.println("/********CONSULTAR SERVICIO********/");
                                validarWhile = conductor_A.ConsultarServicioAsignado();
                                break;
                            default:
                                System.out.println("Opcion no valida. Vuelva a seleccionar.");
                                validarWhile = 1;
                                break;
                        }
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

    private static Usuario Crear_usuario(String nombrearchivo, String User) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String Encabezado;
        Usuario user_final = new Usuario();
        try {

            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            Encabezado = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos;
                datos = linea.split(",");
                EstadoConductor estado;
                if (User.equals(datos[3])) {
                    if (datos[6].charAt(0) == 'R') {

                        //=============  Inicio============
                        String info = Archivos.licenciaEstado("conductoresApp.txt", datos[1]);
                        String[] licenciaEstado = info.split(",");
                        if (licenciaEstado[1].equals("D")) {
                            estado = EstadoConductor.DISPONIBLE;
                        } else {
                            estado = EstadoConductor.EN_SERVICIO;
                        }
                        String informacion = Archivos.tipo("vehiculo.txt", licenciaEstado[2]);
                        TipoVehiculo tipo = TipoVehiculo.AUTO;
                        if (informacion.equals("A")) {
                            tipo = TipoVehiculo.AUTO;
                        } else {
                            tipo = TipoVehiculo.MOTO;
                        }
                        Conductor conductor = new Conductor(datos[1], datos[2], datos[0], datos[5], datos[3], datos[4], licenciaEstado[0], estado, tipo, datos[6].charAt(0));
                        //Polimorfismo de asignacion
                        user_final = conductor;

                        //=============== Fin ===============
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
        System.out.println("2. Solicitar servicio de encomienda");
        System.out.println("3. Solicitar servicio de comida");
        System.out.println("4. Consultar servicios");
    }

    public static void mostrarMenuConductor() {
        System.out.println("/********MENÚ********/");
        System.out.println("/*                  */");
        System.out.println("/********************/");
        System.out.println("1. Consultar servicio asignado");
    }

    private static boolean validarcliente(String Nombrearchivo, Usuario usuario) {
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        String Encabezado;
        File archivo;
        boolean valor = false;
        try {
            archivo = new File(Nombrearchivo);
            fr = new FileReader(archivo, StandardCharsets.UTF_8);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                String[] datos;
                datos = linea.split(",");
                String cedula = datos[0];
                if (cedula.equals(usuario.getNro_cedula())) {
                    valor = true;
                }
            }
        } catch (Exception e) {
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

    public static void registrar_cliente(int edad, String Nro_tarjetacredito, String cedula, String nombreArchivo) {
        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo, true);
            bw = new BufferedWriter(fichero);
            String Edad = String.valueOf(edad);
            bw.write(cedula + ",");
            bw.write(Edad + ",");
            bw.write(Nro_tarjetacredito + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
