public interface crearservicio {
    Servicio crearServicio(Cliente c);
}

public class crearservicio implements crearservicio {
    public Servicio crearServicio(Cliente c) {
        Scanner sc = new Scanner(System.in);
        String resp = null;
        int validarWhile = 0;

        System.out.println("Ingrese la fecha (dia/mes/año) : ");
        String fecha_de = sc.nextLine();
        System.out.println("Ingrese la hora (hora:minutos): ");
        String hora_de = sc.nextLine();
        System.out.println("Ingrese punto de partida: ");
        String p_inicio_de = sc.nextLine();
        System.out.println("Ingrese punto de llegada: ");
        String p_llegada_de = sc.nextLine();
        String metodo = Servicio.metodo_pago();

        ArrayList<Plato> carrito_momentaneo = new ArrayList<>();
        ArrayList<Restaurante> listaRestaurante;
        listaRestaurante = Restaurante.crearRestaurante("restaurantes.txt");
        do {
            System.out.print("\n");
            System.out.println("/******Lista de Restaurantes*******/");

            for (Restaurante r : listaRestaurante) {
                System.out.println((listaRestaurante.indexOf(r) + 1) + " - " + r.getnombre());
            }
            System.out.println("\nIngrese el restaurante del cual desea ordenar: ");
            int i_res = sc.nextInt();
            sc.nextLine();
            ArrayList<Plato> l_menu = Restaurante.crearMenu("menus.txt", listaRestaurante.get(i_res - 1));
            for (Plato p : l_menu) {
                System.out.println((l_menu.indexOf(p) + 1) + " - " + p.getNombre() + " - " + p.getPrecio());
            }
            System.out.println("\nIngrese el plato que desea agregar al carrito: ");
            int op_p = SistemaPrincipal.pedirDatosEnteros();
            sc.nextLine();
            carrito_momentaneo.add(l_menu.get(op_p - 1));

            System.out.println("¿Quiere añadir otro plato al carriot? (Si/No) ");
            String resp_v = sc.nextLine();
            resp = resp_v.toLowerCase();
        } while (resp.equals("si"));

        System.out.println("¿Desea generar el servicio? (si/no)");
        String confirmacion_de = sc.nextLine();
        String confir = confirmacion_de.toLowerCase();
        if (confirmacion_de.equals("si")) {
            Pedido pedido = new Pedido(c.getNombre());
            pedido.setCarrito(carrito_momentaneo);

            double subtotal = 0;
            for (Plato p : pedido.getCarrito()) {
                subtotal += p.getPrecio();
            }
            Ruta ruta_de = new Ruta(p_inicio_de, p_llegada_de);
            Servicio Delivery = new ServicioDelivery(ruta_de, fecha_de, hora_de, pedido);
            Delivery.setvalorPagar(Delivery.calcularTotalServicios(metodo, subtotal));
            String conductor = Delivery.asignarconductor("M");
            String linea = Delivery.getCodigo() + "," + c.getNombre() + "," + conductor + ","
                    + Delivery.getRuta().getpuntoPartida() + "," + Delivery.getRuta().getpuntoLlegada() + ","
                    + Delivery.getfecha() + "," + hora_de + "," + pedido.getcodigo() + "," + metodo + ","
                    + Delivery.getvalorPagar();
            Archivos.EscribirArchivo("delivery.txt", linea);
            String lineaPedido = pedido.getcodigo() + "," + "5657" + "," + conductor + "," + "sdssddss";
            Archivos.EscribirArchivo("pedido.txt", lineaPedido);
            System.out.println("**=============Factura=============**\n" + Delivery.toString());

            System.out.println("¿Desea Solicitar otro Servicio? (si/no): ");
            String validar = sc.nextLine();
            String vali = validar.toLowerCase();

            if (validar.equals("si")) {
                validarWhile = 1;
            } else if (validar.equals("no")) {
                validarWhile = 0;
            }
            validarWhile = 0;
        } else {
            validarWhile = 1;
        }

        sc.close();
        return validarWhile;
    }
}

public class ServicioTaxiCreator implements ServicioCreator {
    public Servicio crearServicio(Cliente c) {
        int validarWhile = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su ubicacion:");
        String ubicacion = sc.nextLine();
        System.out.println("Ingrese su destino:");
        String destino = sc.nextLine();
        Ruta ruta = new Ruta(ubicacion, destino);
        System.out.println("Ingrese fecha con el formato(dd/mm/aaaa):");
        String fecha = sc.nextLine();
        System.out.println("Ingrese hora con el formato(hh:mm):");
        String hora = sc.nextLine();
        System.out.println("Numero de personas");
        int personas = SistemaPrincipal.pedirDatosEnteros();
        String metodo = Servicio.metodo_pago();
        System.out.println("Desea generar el servicio (si/no)");
        String confirmacion = sc.nextLine();
        String confi = confirmacion.toLowerCase();

        if (confirmacion.equals("si")) {
            ServicioTaxi taxi = new ServicioTaxi(ruta, fecha, personas);
            String tipoVehiculo = "A";
            String conductor = taxi.asignarconductor(tipoVehiculo);

            String linea = taxi.getCodigo() + "," + c.getNombre() + "," + conductor + ","
                    + taxi.getRuta().getpuntoPartida() + "," + taxi.getRuta().getpuntoLlegada() + ","
                    + taxi.getfecha() + "," + hora + "," + taxi.getcantidadPersonas() + "," + metodo + ","
                    + taxi.getvalorPagar();
            Archivos.EscribirArchivo("viajes.txt", linea);
            System.out.println("**=============Factura=============**\n" + taxi.toString());

            Servicio taxi2 = (Servicio) taxi;
            c.setListaServicio(taxi2);
            System.out.println("¿Desea Solicitar otro Servicio? (si/no): ");
            String validar = sc.nextLine();
            String vali = validar.toLowerCase();

            if (validar.equals("si"))
                validarWhile = 1;
            else if (validar.equals("no"))
                validarWhile = 0;
        } else {
            validarWhile = 0;
        }
        return validarWhile;
    }
}
