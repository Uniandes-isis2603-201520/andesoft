/*
 * ItinerarioResource.java
 * Clase que representa el recurso "/itinerario"
 * Implementa varios métodos para manipular los itinerarios
 * @autor: mm.gomez10
 */
package AndeSoft.rest.resources;



import AndeSoft.rest.dtos.EventoDTO;
import AndeSoft.rest.dtos.PuntoInteresDTO;
import AndeSoft.rest.mocks.PuntoInteresLogicMock;
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
 * Clase que implementa el recurso REST correspondiente a "EVENTOS".
 * 
 * SE SUPONE QUE ESTE EVENTO LO TIENE UN ITINERARIO
 * 
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "eventos". 
 * Al ejecutar la aplicación, el recurso será accesibe a través de la 
 * ruta "/api/eventos" 
 * 
 */
@Path("puntosInteres")
@Produces("application/json")
public class PuntoInteresResource 
{

	@Inject
	PuntoInteresLogicMock puntoInteresLogic;

	/**
	 * Obtiene el listado de eventos dado el id de un itinerario. 
         * @param idIt identificador del itinerario
	 * @return lista de eventos 
	 * @throws EventoLogicException excepción retornada por la lógica  
	 */
    @GET
    @Path("/itinerarios/{idIt}/puntosInteres")
    public ArrayList getPuntosInteres(@PathParam("idIt") Long idIt) 
    {
        return puntoInteresLogic.getTodosPuntosInteresIdItinerario(idIt);
    }

    /**
     * Obtiene un evento
     * @param idIt identificador del itinerario
     * @param idEv identificador del evento
     * @return punto de ineteres encontrado
     * @throws EventoLogicException cuando el evento no existe
     */
    @GET
    @Path("/itinerarios/{idIt}/puntosInteres/{idEv}")
    public PuntoInteresDTO getPuntoInteres(@PathParam("idIt") Long idIt, @PathParam("idEv") Long idEv )
    {
        return puntoInteresLogic.getPuntoInteres(idIt, idEv);
    }

    /**
     * Agrega un punto de interes
     * @param puntoDineteres punto de interes por agregar
     * @param idIt identificador del itinerario
     * @return datos del evento a agregado
     * @throws EventoLogicException cuando ya existe un evento con el id suministrado
     */
    @POST
    @Path("/itinerarios/{idIt}/createPuntoInteres")
    public PuntoInteresDTO createPuntoInteres(PuntoInteresDTO puntoDineteres,@PathParam("idIt") Long idIt )  
    {
        return puntoInteresLogic.createPuntoInteres(puntoDineteres, idIt);
    }

    /**
     * Actualiza los datos de un evento
     * @param idEv identificador del evento
     * @param eventoNuevo evento a modificar
     * @param idIt identificador del itinerario
     * @return datos del evento modificado 
     * @throws EventoLogicException cuando no existe una evento con el id suministrado
     */
    @PUT
    @Path("/itinerarios/{idIt}/cambiarPuntoInteres/{idEv}")
    public PuntoInteresDTO updatePuntoInteres(@PathParam("idIt") Long idIt,@PathParam("idEv") Long idEv, PuntoInteresDTO eventoNuevo)
    {
        return puntoInteresLogic.updatePuntoInteres(idIt,idEv, eventoNuevo);
    }

    /**
     * Elimina los datos de un evento
     * @param idIt identificador del itinerario dueño del evento a eliminar
     * @param idEv identificador del punto de interes a eliminar
     * @throws EventoLogicException cuando no existe una evento con el id suministrado
     */
    @DELETE
    @Path("/itinerarios/{idIt}/eliminarPuntoInteres/{idEv}")
    public void deletePuntoInteres(@PathParam("idIt") Long idIt, @PathParam("idEv") Long idEv) 
    {
    	puntoInteresLogic.deletePuntoInteres(idIt, idEv);
    }
}