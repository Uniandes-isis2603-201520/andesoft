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
 * @author Johan
 */
class CiudadDTOf {
    
    private Long id;
    private String nombre;
    private String fechaLLegada;
    private String fechaSalida;
    private ArrayList<EventoDTO> eventos;
    private ArrayList<HotelDTO> hoteles;
    private ArrayList<PuntoInteresDTO> puntosInteres;
    
    public CiudadDTOf(){
        
    }
    
     public CiudadDTOf(Long idN, String nombreN, String fechaInicioN, String fechaSalidaN){
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

    

    public ArrayList<EventoDTO> getEventos() {
        return (ArrayList<EventoDTO>) eventos;
    }

    public void agregarEvento(EventoDTO evento) {
        if(eventos==null)eventos=new ArrayList<>();
        this.eventos.add(evento);
    }

    public ArrayList<HotelDTO> getHoteles() {
        return hoteles;
    }

    public void agregarHotel(HotelDTO hotel) {
        if(hoteles==null)hoteles=new ArrayList<>();
        this.hoteles.add(hotel);
        
    }

    public ArrayList<PuntoInteresDTO> getPuntosInteres() {
        return puntosInteres;
    }

    public void agregarPuntoInteres(PuntoInteresDTO punto) {
        if(puntosInteres==null)puntosInteres=new ArrayList<>();
        this.puntosInteres.add(punto);
    }
}
