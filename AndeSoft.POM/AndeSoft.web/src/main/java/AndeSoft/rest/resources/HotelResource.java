/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.resources;

import AndeSoft.rest.dtos.HotelDTO;
import AndeSoft.rest.mocks.HotelLogicMock;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author AndresFelipe
 */
@Path("hoteles")
@Produces("application/json")
public class HotelResource
{
	@Inject
	HotelLogicMock hotelLogic;
        
    @GET
    @Path("/hoteles")
    public ArrayList getEventos(@PathParam("idIt") Long idIt) 
    {
        return hotelLogic.getTodosHotelesIdItinerario(idIt);
    }
    
    @GET
    @Path("/itinerarios/{idIt}/hoteles/{idHo}")
    public HotelDTO getEvento(@PathParam("idIt") Long idIt, @PathParam("idHo") Long idHo )
    {
        return hotelLogic.getHotel(idIt, idHo);
    }
    
    @POST
    @Path("/itinerarios/{idIt}/createHotel")
    public HotelDTO createHotel(HotelDTO hotel,@PathParam("idIt") Long idIt )  
    {
        return hotelLogic.createHotel(hotel, idIt);
    }
    
    @PUT
    @Path("/itinerarios/{idIt}/cambiarHotel/{idHo}")
    public HotelDTO updateHotel(@PathParam("idIt") Long idIt,@PathParam("idHo") Long idHo, HotelDTO hotelNuevo)
    {
        return hotelLogic.updateHotel(idIt,idHo, hotelNuevo);
    }
    
    @DELETE
    @Path("/itinerarios/{idIt}/eliminarHotel/{idHo}")
    public void deleteHotel(@PathParam("idIt") Long idIt, @PathParam("idHo") Long idHo) 
    {
    	hotelLogic.deleteHotel(idIt, idHo);
    }
}
