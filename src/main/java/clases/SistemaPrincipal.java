/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
        }
        
        /*
        System.out.println("nueva linea codigo prueba");
        mostrarMenuCliente();
        mostrarMenuVendedor();
        */
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
    usuario user_t= new usuario(datos[1], datos[2], datos[0], datos[5], datos[3],datos[4],datos[5].charAt(0));
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
    public static void mostrarMenuVendedor(){
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
    if ((linea = br.readLine()) == null ){
        valor=false; 
      }
     }catch(Exception e){
      e.printStackTrace(); 
     }
      if(valor==false){       
     try {
         archivo=new File(Nombrearchivo);
         fr= new FileReader(archivo,StandardCharsets.UTF_8);
         br=new BufferedReader(fr);
         Encabezado=br.readLine();
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