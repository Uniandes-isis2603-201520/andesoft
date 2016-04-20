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
    public ArrayList getHoteles(@PathParam("idCity") Long idCity)
    {
        return hotelLogic.getTodosHotelesIdCiudad(idCity);
    }

    @GET
    @Path("/ciudades/{idCity}/hoteles/{idHo}")
    public HotelDTO getHotel(@PathParam("idCity") Long idCity, @PathParam("idHo") Long idHo )
    {
        return hotelLogic.getHotel(idCity, idHo);
    }

    @POST
    @Path("/ciudades/{idCity}/createHotel")
    public HotelDTO createHotel(HotelDTO hotel,@PathParam("idCity") Long idCity )
    {
        return hotelLogic.createHotel(hotel, idCity);
    }

    @PUT
    @Path("/ciudades/{idCity}/cambiarHotel/{idHo}")
    public HotelDTO updateHotel(@PathParam("idCity") Long idCity,@PathParam("idHo") Long idHo, HotelDTO hotelNuevo)
    {
        return hotelLogic.updateHotel(idCity,idHo, hotelNuevo);
    }

    @DELETE
    @Path("/ciudades/{idCity}/eliminarHotel/{idHo}")
    public void deleteHotel(@PathParam("idCity") Long idCity, @PathParam("idHo") Long idHo)
    {
    	hotelLogic.deleteHotel(idCity, idHo);
    }
}
