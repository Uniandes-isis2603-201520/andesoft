/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author js.arciniegas10
 */
class ItinerarioDTO
{
    
    private Long id;
    private String nombre;
    private String fechaInicio;
    private String fechaSalida;
    private List<CiudadDTO> ciudades;
    private List<EventoDTO> eventos;
    private List<HotelDTO> hoteles;
    private List<PuntoInteresDTO> puntosInteres;
    
    public ItinerarioDTO(){
        
    }
    
     public ItinerarioDTO(Long idN, String nombreN, String fechaInicioN, String fechaSalidaN){
      id=idN;
     nombre=nombreN;
     fechaInicio=fechaInicioN;
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
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public List<CiudadDTO> getCiudades() {
        return ciudades;
    }

    public void agregarCiudad(CiudadDTO ciudad) {
        if(ciudades==null)ciudades=new ArrayList<>();
        this.ciudades.add(ciudad);
        
    }

    public List<EventoDTO> getEventos() {
        return eventos;
    }

    public void agregarEvento(EventoDTO evento) {
        if(eventos==null)eventos=new ArrayList<>();
        this.eventos.add(evento);
    }

    public List<HotelDTO> getHoteles() {
        return hoteles;
    }

    public void agregarHotel(HotelDTO hotel) {
        if(hoteles==null)hoteles=new ArrayList<>();
        this.hoteles.add(hotel);
        
    }

    public List<PuntoInteresDTO> getPuntosInteres() {
        return puntosInteres;
    }

    public void agregarPuntoInteres(PuntoInteresDTO punto) {
        if(puntosInteres==null)puntosInteres=new ArrayList<>();
        this.puntosInteres.add(punto);
    }
    
    public CiudadDTO darCiudadPorId(Long id ){
        for(int i=0;i<ciudades.size();i++){
            if(ciudades.get(i).getId()==id)
                return ciudades.get(i);
        }
        return null;
    }
    

}
