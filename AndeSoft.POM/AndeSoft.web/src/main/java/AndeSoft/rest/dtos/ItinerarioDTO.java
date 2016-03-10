/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

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
    

    

}
