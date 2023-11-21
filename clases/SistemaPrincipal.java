package clases;

import java.util.Scanner;
import java.io.IOException;

public class SistemaPrincipal {

    static class SistemaManejador {

        private final AutenticacionServicio autenticacionServicio;
        private final UsuarioServicio usuarioServicio;

        public SistemaManejador() {
            this.autenticacionServicio = new AutenticacionServicio();
            this.usuarioServicio = new UsuarioServicio();
        }

        public void iniciarSistema() {
            try {
                ArchivosUtil.inicializarArchivos();

                boolean autenticado = autenticacionServicio.autenticarUsuario();
                if (autenticado) {
                    Usuario usuario = usuarioServicio.crearUsuario();
                    usuarioServicio.procesarUsuario(usuario);
                } else {
                    System.out.println("Credenciales no válidas. Cerrando el sistema.");
                }
            } catch (IOException e) {
                System.out.println("Error al inicializar archivos: " + e.getMessage());
            }
        }
    }

    static class AutenticacionServicio {

        public boolean autenticarUsuario() {
            // Lógica de autenticación
            return true;  // Se debe implementar la lógica real de autenticación
        }
    }

    static class UsuarioServicio {

        private final CreacionUsuarioServicio creacionUsuarioServicio;
        private final ProcesoUsuarioServicio procesoUsuarioServicio;

        public UsuarioServicio() {
            this.creacionUsuarioServicio = new CreacionUsuarioServicio();
            this.procesoUsuarioServicio = new ProcesoUsuarioServicio();
        }

        public Usuario crearUsuario() {
            return creacionUsuarioServicio.crearUsuario();
        }

        public void procesarUsuario(Usuario usuario) {
            procesoUsuarioServicio.procesarUsuario(usuario);
        }
    }

    static class ArchivosUtil {
        public static void inicializarArchivos() throws IOException {
            // Lógica para inicializar archivos
        }
    }

    public static void main(String[] args) {
        System.out.println("Inicio del sistema");
        boolean validar = false;
        Scanner sc = new Scanner(System.in);
        while (!validar) {
            // Add a comment here
            System.out.println("Ingrese el usuario y contraseña");
            System.out.println("usuario: ");
            String Usuario = sc.nextLine();
            System.out.println("Contraseña: ");
            String Contraseña = sc.nextLine();
        }
    }
}



        }

            if (IngresoSistema(Usuario.toLowerCase(), Contraseña.toLowerCase(), "usuarios.txt") == false || validardatos(Usuario) == false) {
                System.out.println("credenciales no validas");
            } else {
                System.out.println("Bienvenido al sistema");
                validar = true;
                Usuario User = Crear_usuario("usuarios.txt", Usuario);
                if (User.getTipo() == 'C') {
                    if (Cliente.validarcliente("Clientes.txt", User) == false) {
                        System.out.println("Cliente no registrado");
                        System.out.println("Ingrese su edad");
                        int edad = sc.nextInt();
                        System.out.println("Ingres el numero de tarjeta de credito");
                        String tarjeta = sc.next();
                        Cliente.registrar_cliente(edad, tarjeta, User.getNro_cedula(), "Clientes.txt");
                    }
                    System.out.println("Cliente registrado");
                    Cliente cliente_A = (Cliente) User;//Down casting
                    int validarWhile = 1;
                    
                    while (validarWhile != 0) {
                        mostrarMenuCliente();
                        System.out.println("Escoja una opcion:");
                        int op = pedirDatosEnteros();
                        switch (op) {
                            case 1:
                                System.out.println("/********SERVICIO TAXI********/");
                                validarWhile = ServicioTaxi.crearServicioTaxi(cliente_A);
                                
                                break;
                            case 2:
                                System.out.println("/********SERVICIO ENCOMIENDAS********/");
                                validarWhile = EntregaEncomienda.crearServicioEncomienda(cliente_A);

                                break;
                            case 3:
                                System.out.println("/********SERVICIO DELIVERY COMIDA********/");
                                validarWhile = ServicioDelivery.crearServicioDelivery(cliente_A);

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

                        conductor_A.mostrarMenu();
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

    public class SistemaPrincipal {
        public static boolean validardatos(String datos) {
            return datos.matches("[a-zA-z]*");
        }
        
        private static boolean validardatosEnteros(String datos) {
        int n = 0;
        boolean validar = datos.matches("[0-9]");
        return validar;
    }
    //Pide y valida si el valor ingresado es un entero
    public static int pedirDatosEnteros() {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while (n == 0) {
            String ops = sc.next();
            if (validardatosEnteros(ops) == false) {
                System.out.println("debe ingresar datos validos");
            } else {
                n = Integer.parseInt(ops);
            }

        }

        return n;
    }
    //Permite ingresar los datos user y contraseña
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
    //Crea un Usuario que puede ser un Cliente o Conductor, aqui hay polimorfismo
    public static Usuario Crear_usuario(String nombrearchivo, String User) {
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

                        String info = Conductor.licenciaEstado("conductoresApp.txt", datos[1]);
                        String[] licenciaEstado = info.split(",");
                        if (licenciaEstado[1].equals("D")) {
                            estado = EstadoConductor.DISPONIBLE;
                        } else {
                            estado = EstadoConductor.EN_SERVICIO;
                        }
                        String informacion = Conductor.tipo("vehiculo.txt", licenciaEstado[2]);
                        TipoVehiculo tipo = TipoVehiculo.AUTO;
                        if (informacion.equals("A")) {
                            tipo = TipoVehiculo.AUTO;
                        } else {
                            tipo = TipoVehiculo.MOTO;
                        }
                        Conductor conductor = new Conductor(datos[1], datos[2], datos[0], datos[5], datos[3], datos[4], licenciaEstado[0], estado, tipo, datos[6].charAt(0));
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

    }   
}

