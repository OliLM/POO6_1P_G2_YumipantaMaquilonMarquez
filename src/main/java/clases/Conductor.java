/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import Enums.*;
/**
 *
 * @author Olivier
 */
public class Conductor extends usuario {
    private String licencia;
    private EstadoConductor estado;
    private TipoVehiculo vehiculo;
    
    public Conductor(String nombre, String apellido, String nro_cedula, String celular, String usuario, String contraseña, String licencia, EstadoConductor estado, TipoVehiculo vehiculo, char tipo){
        super(nombre,apellido,nro_cedula,celular,usuario,contraseña,tipo);
        this.licencia= licencia;
        this.estado= estado;
        this.vehiculo= vehiculo;
        
    }

    public String getLicencia() {
        return licencia;
    }

    public EstadoConductor getEstado() {
        return estado;
    }

    public TipoVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public void setEstado(EstadoConductor estado) {
        this.estado = estado;
    }

    public void setVehiculo(TipoVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    @Override
    public void ConsultarServicioAsignado(){
       
   }
        
    @Override
    public String toString(){
        return super.toString()+"[ Licencia: "+getLicencia()+" Estado: "+getEstado()+" Vehiculo: "+getVehiculo()+"]";
    }
}
