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
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


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
         * 
         * solo para veficar
         * 
         * funciona
         * http://localhost:8080/AndeSoft.web/api/Itinerarios/itinerarios
         */
        @GET
        @Path("/itinerarios")
        @Produces(MediaType.APPLICATION_JSON)
        public String getPrueba() 
        {
            System.out.println("Llega tener itinerarios");
            return "llego";
        }

	/**
         * 
         * 
         * http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/itinerarios
         * 
         * 
	 * Obtiene el listado de itinerarios. 
	 * @return lista de itinerarios 
	 * @throws ItinearioLogicException excepción retornada por la lógica  
         * 
	 */
    @GET
    @Path("/perfil/{idP}/itinerarios")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList getItinerarios(@PathParam("idP") int id) 
    {
        System.out.println("Llega tener itinerarios");
        
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
    @Produces(MediaType.APPLICATION_JSON)
    public ItinerarioDTO getItinerario(@PathParam("idP") int idP, @PathParam("idI") int idI )
    {
        System.out.println("Llega tener 1 itinerario");
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
    @Produces(MediaType.APPLICATION_JSON)
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerario,@PathParam("idP") int idP )  
    {
        System.out.println("Llega crear itinerario");
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ItinerarioDTO updateItinerario(@PathParam("idP") int idP,@PathParam("idI") int idI, ItinerarioDTO itNuevo)
    {
        System.out.println("Llega cambiar itinerario");
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
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteItinerario(@PathParam("idP") int idP, @PathParam("idI") int idI) 
    {
        System.out.println("Llega borrar itinerario");
    	itinerarioLogic.deleteItinerario(idP, idI);
    }

}


