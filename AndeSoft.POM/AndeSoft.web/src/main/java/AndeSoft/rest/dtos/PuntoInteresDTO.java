/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.Date;

/**
 *
 * @author Johan
 */
public class PuntoInteresDTO {
  
    private Long id;
    private String nombre;
    private Date fechaLLegada;
    private Date fechaSalida;
    
    
    /*public PuntoInteresDTO(Long idN, String nombreN, String fechaInicioN, String fechaSalidaN){
      id=idN;
     nombre=nombreN;
     fechaLLegada=fechaInicioN;
     fechaSalida=fechaSalidaN;
     
    }*/
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLlegada() {
        return fechaLLegada;
    }

    public void setFechaLlegada(Date fechaInicio) {
        this.fechaLLegada = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public long getIdItinerario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
