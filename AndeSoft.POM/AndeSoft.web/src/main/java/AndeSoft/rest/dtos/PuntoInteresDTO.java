/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

/**
 *
 * @author Johan
 */
class PuntoInteresDTO {
  
    private Long id;
    private String nombre;
    private String fechaLLegada;
    private String fechaSalida;
    
    
    public PuntoInteresDTO(Long idN, String nombreN, String fechaInicioN, String fechaSalidaN){
      id=idN;
     nombre=nombreN;
     fechaLLegada=fechaInicioN;
     fechaSalida=fechaSalidaN;
     
    }
    
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

    public String getFechaInicio() {
        return fechaLLegada;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaLLegada = fechaInicio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
}
