/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Johan
 */
public class CiudadDTOf {
    
    private Long id;
    private String nombre;
    private Date fechaLLegada;
    private Date fechaSalida;
    private List<EventoDTO> eventos;
    private List<HotelDTO> hoteles;
    private List<PuntoInteresDTO> puntosInteres;
    
    public CiudadDTOf(){
        
    }
    
     public CiudadDTOf(Long idN, String nombreN, Date fechaInicioN, Date fechaSalidaN){
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

    public Date getFechaInicio() {
        return fechaLLegada;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaLLegada = fechaInicio;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    

    public ArrayList<EventoDTO> getEventos() {
        return (ArrayList<EventoDTO>) eventos;
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
}
