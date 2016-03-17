/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.Date;

/**
 *HotelDTO
 * Objeto de transferencia de datos de Hotel
 * @author AndresFelipe
 */
public class HotelDTO {
    
    private Long id;
    private String nombre;
    private String fechaLlegada;
    private String fechaSalida;
    
    /**
     * Constructor por defecto
     */
    public HotelDTO(){
        
    }
    
    /**
     * Constructor con parametros
     */
    public HotelDTO(Long id, String nombre, String fechaLlegada, String fechaSalida){
        this.id = id;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
    }
    
    /**
     * Retorna el id del hotel
     */
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * Retorna el nombre del hotel
     */
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Retorna la fecha de llegada al hotel
     */
    public String getFechaLlegada(){
        return fechaLlegada;
    }
    
    /**
     * Retorna la fech de salida del hotel
     */
    public String getFechaSalida(){
        return fechaSalida;
    }
    
    /**
     * Modifica la fecha de llegada al hotel
     */
    public void setFechaLlegada(String fechaLlegada){
        this.fechaLlegada = fechaLlegada;
    }
    
    /**
     * Modifica la fecha de salida del hotel
     */
    public void setFechaSalida(String fechaSalida){
        this.fechaSalida = fechaSalida;
    }
}
