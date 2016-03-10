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
    private Date fechaLlegada;
    private Date fechaSalida;
    
    /**
     * Constructor por defecto
     */
    public HotelDTO(){
        
    }
    
    /**
     * Constructor con parametros
     */
    public HotelDTO(Long id, String nombre, Date fechaLlegada, Date fechaSalida){
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
    
    /**
     * Retorna el nombre del hotel
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Retorna la fecha de llegada al hotel
     */
    public Date getFechaLlegada(){
        return fechaLlegada;
    }
    
    /**
     * Retorna la fech de salida del hotel
     */
    public Date getFechaSalida(){
        return fechaSalida;
    }
    
    /**
     * Modifica la fecha de llegada al hotel
     */
    public void setFechaLlegada(Date fechaLlegada){
        this.fechaLlegada = fechaLlegada;
    }
    
    /**
     * Modifica la fecha de salida del hotel
     */
    public void setFechaSalida(Date fechaSalida){
        this.fechaSalida = fechaSalida;
    }
}
