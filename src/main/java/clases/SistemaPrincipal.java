/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Scanner;

/**
 *
 * @author ismael123
 */
public class SistemaPrincipal {
    
    public static void main (String [] args){
        boolean validar= false;
        Scanner sc= new Scanner(System.in);
        System.out.println("Inicio del sistema");
        while(validar==false){
        System.out.println("Ingrese el usuario y contraseña");
        System.out.println("usuario: ");
        String Usuario= sc.nextLine();
        System.out.println("Contraseña: ");
        String Contraseña= sc.nextLine();
        if(validardatos(Usuario)==false || validardatos(Contraseña)==false){
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
  
    
}
