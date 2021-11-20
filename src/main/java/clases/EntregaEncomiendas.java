/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import Enums.TipoEncomienda;
/**
 *
 * @author DELL
 */
public class EntregaEncomiendas extends Servicio {
    private int cantidadProductos;
    private TipoEncomienda tipoEncomienda;
    
    public EntregaEncomiendas(Ruta ruta,String fecha,int cantidadProductos,TipoEncomienda tipoEncomienda){
        super(ruta,fecha);
        this.cantidadProductos=cantidadProductos;
        this.tipoEncomienda=tipoEncomienda;
    }
    public int getcantidadProductos(){
        return cantidadProductos;
    }
    public void setcantidadProductos(int cantidadProductos){
        this.cantidadProductos=cantidadProductos;
    }
    
    public TipoEncomienda gettipoEncomienda(){
        return tipoEncomienda;
    }
    public void settipoEncomienda(TipoEncomienda tipoEncomienda){
        this.tipoEncomienda=tipoEncomienda;
    }
    
}
