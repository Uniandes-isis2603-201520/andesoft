/*
 * ItinerarioResource.java
 * Clase que representa el recurso "/itinerario"
 * Implementa varios métodos para manipular los itinerarios
 * @autor: jg.tamura10
 */
package AndeSoft.rest.resources;



import AndeSoft.rest.dtos.ItinerarioDTO;
import AndeSoft.rest.mocks.ItinerarioLogicMock;
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
 * Clase que implementa el recurso REST correspondiente a "itinerarios".
 * 
 * SE SUPONE QUE ESTE ITINERARIO LO TIENE UN PERFIL
 * 
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "itinerarios". 
 * Al ejecutar la aplicación, el recurse será accesibe a través de la 
 * ruta "/api/itinerarios" 
 * 
 */
@Path("Itinerarios")
@Produces("application/json")
public class ItinerarioResource 
{

	@Inject
	ItinerarioLogicMock itinerarioLogic;

	/**
	 * Obtiene el listado de itinerarios. 
	 * @return lista de itinerarios 
	 * @throws ItinearioLogicException excepción retornada por la lógica  
	 */
    @GET
    @Path("/perfil/{idP}/itinerarios")
    public ArrayList getItinerarios(@PathParam("idP") Long id) 
    {
        return itinerarioLogic.getTodosItinerariosIDPerfil(id);
    }

    /**
     * Obtiene un itinerario
     * @param id identificador del itinerario
     * @return itinerario encontrado
     * @throws ItinerarioLogicException cuando la ciudad no existe
     */
    @GET
    @Path("/perfil/{idP}/itinerarios/{idI}")
    public ItinerarioDTO getCity(@PathParam("idP") Long idP, @PathParam("idI") Long idI )
    {
        return itinerarioLogic.getItinerario(idP, idI);
    }

    /**
     * Agrega un itinerario
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregado
     * @throws ItinerarioLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    @Path("/perfil/{idP}/createIt")
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerario,@PathParam("idP") Long idP )  
    {
        return itinerarioLogic.createItinerario(itinerario, idP);
    }

    /**
     * Actualiza los datos de un itinerario
     * @param id identificador del itinerario
     * @param itinerario  itinerario a modificar
     * @return datos del itineario modificado 
     * @throws ItinerarioLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("/perfil/{idP}/cambiarItinerario/{idI}")
    public ItinerarioDTO updateItinerario(@PathParam("idP") Long idP,@PathParam("idI") Long idI, ItinerarioDTO itNuevo)
    {
        return itinerarioLogic.updateItinerario(idP,idI, itNuevo);
    }

    /**
     * Elimina los datos de un itinerario
     * @param idP identificador del usuario dueño del itinerario a eliminar
     * @param idI identificador del itinerario a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("/perfil/{idP}/eliminarItinerario/{idI}")
    public void deleteItinerario(@PathParam("idP") Long idP, @PathParam("idI") Long idI) 
    {
    	itinerarioLogic.deleteItinerario(idP, idI);
    }

}


