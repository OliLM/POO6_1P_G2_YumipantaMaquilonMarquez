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
    private static usuario Crear_usuario(String nombrearchivo){
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
           String cedula=datos[0];
            String Nombre=datos[1];
             String Apellido=datos[2];
           String usuario=datos[3];
           String contra=datos[4];
           String telefono =datos[5];
            String tipo=datos[6];
            char t=tipo.charAt(0);
           
           
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
        return null;
        
        
    }
            
  
    
}
