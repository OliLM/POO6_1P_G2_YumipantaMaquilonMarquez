/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import Enums.*;
/**
 *
 * @author ismael123
 */
public class SistemaPrincipal {
    
    public static void main (String [] args){
        boolean validar= false;
        Scanner sc= new Scanner(System.in);
        System.out.println("Inicio del sistema");
        while(validar==false){ //se pone un ciclo para que cuando ponga mal los datos ingrese denuevo
        System.out.println("Ingrese el usuario y contraseña");
        System.out.println("usuario: ");
        String Usuario= sc.nextLine();
        System.out.println("Contraseña: ");
        String Contraseña= sc.nextLine();
        if( IngresoSistema(Usuario.toLowerCase(),Contraseña.toLowerCase(),"usuarios.txt")==false || validardatos(Usuario)==false){
            System.out.println("credenciales no validas");      
        }else{
            System.out.println("Bienvenido al sistema");
            validar=true; 
            usuario User=Crear_usuario("usuarios.txt",Usuario);
        if(User.getTipo()=='C'){
            if(validarcliente("Cliente.txt",User)==false){
               System.out.println("Cliente no registrado");
            }
            Cliente cliente_A= (Cliente)User;
            mostrarMenuCliente();
            System.out.print("Ingrese su opcion: ");
            int op= sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    System.out.println("/********SERVICIO TAXI********/");
                    
                    System.out.print("Ingrese la fecha: ");
                    String fecha_t= sc.nextLine();
                    System.out.print("Ingrese punto de partida: ");
                    String p_inicio= sc.nextLine();
                    System.out.print("Ingrese punto de llegada: ");
                    String p_llegada= sc.nextLine();
                    Ruta ruta_t= new Ruta(p_inicio,p_llegada);
                    System.out.print("Ingrese la cantidad de personas que viajaran: ");
                    int cantidad_p= sc.nextInt();
                    sc.nextLine();
                    Servicio Taxi= new ServicioTaxi(ruta_t,fecha_t,cantidad_p);
                    break;
                case 2:
                    System.out.println("/********SERVICIO ENCOMIENDAS********/");
     
                    System.out.print("Ingrese la fecha: ");
                    String fecha_e= sc.nextLine();
                    System.out.print("Ingrese punto de partida: ");
                    String p_inicio_e= sc.nextLine();
                    System.out.print("Ingrese punto de llegada: ");
                    String p_llegada_e= sc.nextLine();
                    Ruta ruta_e= new Ruta(p_inicio_e,p_llegada_e);
                    System.out.print("Ingrese el tipo de encomienda: ");
                    String t_encomienda= sc.nextLine();
                    TipoEncomienda T_e= TipoEncomienda.valueOf(t_encomienda.toUpperCase());
                    System.out.print("Ingrese la cantidad de items que enviará: ");
                    int cantidad_items= sc.nextInt();
                    sc.nextLine();              
                    Servicio Encomienda= new EntregaEncomiendas(ruta_e,fecha_e,cantidad_items,T_e);
                    break;
                case 3:
                    System.out.println("/********SERVICIO DELIVERY COMIDA********/");
                    
                    System.out.print("Ingrese la fecha: ");
                    String fecha_de= sc.nextLine();
                    System.out.print("Ingrese punto de partida: ");
                    String p_inicio_de= sc.nextLine();
                    System.out.print("Ingrese punto de llegada: ");
                    String p_llegada_de= sc.nextLine();
                    Ruta ruta_de= new Ruta(p_inicio_de,p_llegada_de);
                    System.out.print("Ingrese el pedido: "); //Falta crear el pedido como objeto, y la clase restaurante y menú
                    
                    Servicio Delivery= new ServicioDelivery(ruta_de, fecha_de,"1234","Williams restaurant");
                    break;
                case 4:
                    System.out.println("/********CONSULTAR SERVICIO********/");
                    cliente_A.ConsultarServicioAsignado();
                    break;
                default:
                    System.out.print("Se cerró el menú");
            }
        
        }
        else{
            Conductor conductor_A= (Conductor)User;
            mostrarMenuConductor();
            System.out.print("Ingrese su opcion: ");
            int op= sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                  System.out.println("/********CONSULTAR SERVICIO********/");
                  conductor_A.ConsultarServicioAsignado();
                  break;
                default:
                    System.out.print("Se cerró el menú");  
            }

        }
        
        /*
        System.out.println("nueva linea codigo prueba");
        mostrarMenuCliente();
        mostrarMenuVendedor();
        */
        }        
    }
    }
    public static boolean validardatos(String datos){
       return datos.matches("[a-zA-z]*");  
    }
    private static boolean IngresoSistema(String user, String contraseña, String nombrearchivo){
     boolean encontrado= false;  
     File archivo = null;
     FileReader fr = null;
    BufferedReader br = null;
     String linea;
     String Encabezado;
     try {
         archivo=new File(nombrearchivo);
         fr= new FileReader(archivo,StandardCharsets.UTF_8);
         br=new BufferedReader(fr);
         Encabezado=br.readLine();
        while ((linea = br.readLine()) != null )  {
           String []datos;
           datos=linea.split(",");
           String usuario=datos[3];
           String contra=datos[4]; 
           if(usuario.equals(user) && contraseña.equals(contra)){
            encontrado=true; 
           }
          
         }    
     }catch(Exception e){
         e.printStackTrace();
     }
     finally {
            
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
     if(encontrado==true){
         return true;
     }
     else{
         return false;
     }
         
    }
    private static usuario Crear_usuario(String nombrearchivo,String User){
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
     String linea;
     String Encabezado;
       usuario user_final=new usuario();
     try {
       
         archivo=new File(nombrearchivo);
         fr= new FileReader(archivo,StandardCharsets.UTF_8);
         br=new BufferedReader(fr);
         Encabezado=br.readLine();
        while ((linea = br.readLine()) != null )  {
           String []datos;
           datos=linea.split(",");
         if(User.equals(datos[3])){         
            usuario user_t= new usuario(datos[1], datos[2], datos[0], datos[5], datos[3],datos[4],datos[6].charAt(0));
            user_final=user_t;
         }
      
         }    
     }catch(Exception e){
         e.printStackTrace();
     }
     finally {
            
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
    public static void mostrarMenuCliente(){
        System.out.println("/********MENÚ********/");
        System.out.println("/*                  */");
        System.out.println("/********************/");
        System.out.println("1. Solicitar servicio de taxi");
        System.out.println("2. Solicitar servicio de comida");
        System.out.println("3. Solicitar entrega encomienda");
        System.out.println("4. Consultar servicios");
    } 
    public static void mostrarMenuConductor(){
        System.out.println("/********MENÚ********/");
        System.out.println("/*                  */");
        System.out.println("/********************/");
        System.out.println("1. Consultar servicio asignado");
    }  
    private static boolean validarcliente(String Nombrearchivo,usuario usuario){ 
    FileReader fr = null;
    BufferedReader br = null;
     String linea;
     String Encabezado;
     File archivo;
     boolean valor=true;
     try{
      Encabezado=br.readLine();
     if(Encabezado==" "){
         valor=false;
     }
         
     }catch(Exception e2){
             
             }
      if(valor==false){       
     try {
         archivo=new File(Nombrearchivo);
         fr= new FileReader(archivo,StandardCharsets.UTF_8);
         br=new BufferedReader(fr);
         
        while ((linea = br.readLine()) != null )  {
           String []datos;
           datos=linea.split(",");
           if(usuario.getNro_cedula().equals(datos[0])){
              valor =true;   
           }  
         }    
     }catch(Exception e){
         e.printStackTrace();
     }
     
     }
    return valor;
            }
    
    
}