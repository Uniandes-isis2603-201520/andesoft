/*
 * ItinerarioResource.java
 * Clase que representa el recurso "/itinerario"
 * Implementa varios métodos para manipular los itinerarios
 * @autor: mm.gomez10
 */
package AndeSoft.rest.resources;



import AndeSoft.converters.EventoConverter;
import AndeSoft.rest.dtos.EventoDTO;
import AndeSoft.rest.mocks.EventoLogicMock;
import Andesoft.providers.StatusCreated;
import andesoft.api.IEventoLogic;
import andesoft.entities.EventoEntity;
import andesoft.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
import javax.ws.rs.core.Response;

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
@Path("Eventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoResource 
{

private static final Logger logger = Logger.getLogger(EventoResource.class.getName());

    @Inject
    private IEventoLogic eventoLogic;

   
    @GET
    public List<EventoDTO> getEventos() {
        logger.info("Se ejecuta método getEventos");
        List<EventoEntity> eventos = eventoLogic.getEventos();
        return EventoConverter.listEntity2DTO(eventos);
    }

 
    @GET
    @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("id") Long id) {
        logger.log(Level.INFO, "Se ejecuta método getEvento con id={0}", id);
        EventoEntity evento = eventoLogic.getEvento(id);
        return EventoConverter.fullEntity2DTO(evento);
    }


    @POST
    @StatusCreated
    public EventoDTO createEvento(EventoDTO dto) {
        logger.info("Se ejecuta método createEvento");
        EventoEntity entity = EventoConverter.fullDTO2Entity(dto);
        EventoEntity newEntity;
        newEntity = eventoLogic.createEvento(entity);
        return EventoConverter.fullEntity2DTO(newEntity);
    }

    @PUT
    @Path("{id: \\d+}")
    public EventoDTO updateBook(@PathParam("id") Long id, EventoDTO dto) {
        logger.log(Level.INFO, "Se ejecuta método updateEvento con id={0}", id);
        EventoEntity entity = EventoConverter.fullDTO2Entity(dto);
        entity.setId(id);
        EventoEntity oldEntity = eventoLogic.getEvento(id);
        entity.setCiudad(oldEntity.getCiudad());
        EventoEntity savedBook = eventoLogic.updateEvento(entity);
        return EventoConverter.fullEntity2DTO(savedBook);
    }

   
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBook(@PathParam("id") Long id) {
        logger.log(Level.INFO, "Se ejecuta método deleteBook con id={0}", id);
        eventoLogic.deleteEvento(id);
    }

}
