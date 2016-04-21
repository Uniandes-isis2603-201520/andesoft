/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.resources;

import AndeSoft.converters.CiudadConverter;
import AndeSoft.converters.PuntoInteresConverter;
import AndeSoft.rest.dtos.CiudadDTOf;
import AndeSoft.rest.dtos.PuntoInteresDTO;
import AndeSoft.rest.dtos.ciudadDTO;
import AndeSoft.rest.exceptions.ciudadLogicException;
import AndeSoft.rest.mocks.ciudadLogicMock;
import andesoft.api.ICiudad;
import andesoft.ejbs.CiudadLogic;
import andesoft.entities.CiudadEntity;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author e.galvis10
 */
@Path("ciudades")
//@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ciudadResource
{
    /* @Context
    private HttpServletResponse response;
    */
    private static final Logger logger = Logger.getLogger(PuntoInteresResource.class.getName());


     @Inject
     ciudadLogicMock cityLogic;
     
      @Inject
       private ICiudad ciudadLogic;


    /**
	 * Obtiene el listado de ciudades.
	 * @return lista de ciudades
	 * @throws CityLogicException excepción retornada por la lógica
	 *///throws CityLogicException
   /* @GET
    public List<C> getCities()  throws ciudadLogicException {
        return cityLogic.getCiudades();
    }*/
       @GET
    public List<CiudadDTOf> getCities()  throws ciudadLogicException {
       return CiudadConverter.listEntity2DTO(ciudadLogic.getCiudades());
    }
           


//    @GET
//    @Path("{name: \\d+}")
//    public ciudadDTO getCity(@PathParam("name") String name) throws ciudadLogicException {
//        return cityLogic.getCity(name);
//    }
    
    
    @GET
    @Path("{id: \\d+}")
    public CiudadDTOf getCiudad(@PathParam("id") Long id) {
        return CiudadConverter.fullEntity2DTO(ciudadLogic.getCiudad(id));
    }
    

     @POST
    
    public CiudadDTOf createCiudad(CiudadDTOf dto) {
        CiudadEntity entity = CiudadConverter.fullDTO2Entity(dto);
        return CiudadConverter.fullEntity2DTO(ciudadLogic.createCiudad(entity));
    }

    /**
     * Actualiza los datos de un evento
     * @param idEv identificador del evento
     * @param eventoNuevo evento a modificar
     * @param idIt identificador del itinerario
     * @return datos del evento modificado 
     * @throws EventoLogicException cuando no existe una evento con el id suministrado
     */
    
    /*@PUT
    @Path("/itinerarios/{idIt}/cambiarPuntoInteres/{idEv}")
    public PuntoInteresDTO updatePuntoInteres(@PathParam("idIt") Long idIt,@PathParam("idEv") Long idEv, PuntoInteresDTO eventoNuevo)
    {
        return puntoInteresLogic.updatePuntoInteres(idIt,idEv, eventoNuevo);
    }*/
    
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTOf updateCiudad(@PathParam("id") Long id, CiudadDTOf dto) {
        CiudadEntity entity = CiudadConverter.fullDTO2Entity(dto);
        entity.setId(id);
        //PuntoInteresEntity oldEntity = puntoInteresLogic.getPuntoInteres(id);
       // entity.setBooks(oldEntity.getBooks());
        return CiudadConverter.fullEntity2DTO(ciudadLogic.updateCiudad(entity));
    }

    /**
     * Elimina los datos de un evento
     * @param idIt identificador del itinerario dueño del evento a eliminar
     * @param idEv identificador del punto de interes a eliminar
     * @throws EventoLogicException cuando no existe una evento con el id suministrado
     */
    /*@DELETE
    @Path("/itinerarios/{idIt}/eliminarPuntoInteres/{idEv}")
    public void deletePuntoInteres(@PathParam("idIt") Long idIt, @PathParam("idEv") Long idEv) 
    {
    	puntoInteresLogic.deletePuntoInteres(idIt, idEv);
    }*/
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCiudad(@PathParam("id") Long id) {
        ciudadLogic.deleteCiudad(id);
    }
    /*
    @GET
    @Path("{id: \\d+}")
    public CityDTO getCity(@PathParam("id") Long id) throws CityLogicException {
        return cityLogic.getCity(id);
    }
*/

    
    /*
 @POST
    public ciudadDTO createCity(ciudadDTO city) throws ciudadLogicException {
        System.out.println("AndeSoft.rest.resources.ciudadResource.createCity()");
        return cityLogic.createCity(city);
    }

    @DELETE
    @Path("{name: \\d+}")
    public void deleteCity(@PathParam("name") String name) throws ciudadLogicException {
        System.out.println("se quiere eliminar " + name);
    	cityLogic.deleteCity(name);
    }*/
}
