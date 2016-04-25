/*
 * ItinerarioResource.java
 * Clase que representa el recurso "/itinerario"
 * Implementa varios métodos para manipular los itinerarios
 * @autor: jg.tamura10
 */
package AndeSoft.rest.resources;



import AndeSoft.converters.ItinerarioConverter;
import AndeSoft.rest.dtos.ItinerarioDTO;
import AndeSoft.rest.dtos.UsuarioDTO;
import AndeSoft.rest.mocks.ItinerarioLogicMock;
import andesoft.api.IItinerarioLogic;
import andesoft.entities.ItinerarioEntity;
import java.util.*;

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
//@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ItinerarioResource 
{

@Inject
IItinerarioLogic itinerarioLogic;
        
        /**
         * 
         * solo para veficar
         * 
         * funciona
         * http://localhost:8080/AndeSoft.web/api/Itinerarios/itinerarios
         */
        @GET
        @Path("/itinerarios")
        public String getPrueba() 
        {
            System.out.println("Llega tener itinerarios");
            return "llego";
        }
        
    
/**
         * 
         *  no se usa, no se necesita
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
    @Path("/perfil/{idP}/itinerariosTodos")
    public List<ItinerarioDTO> getItinerarios(@PathParam("idP") long id) 
    {
        System.out.println("Llega tener itinerarios");
        
        List<ItinerarioDTO> temp= ItinerarioConverter.listEntity2DTO(itinerarioLogic.getItinerarios());
     return temp;
        
    }

    /**
     * 
     * http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/itinerarios/0
     * 
     * Obtiene un itinerario
     * @param id identificador del itinerario
     * @return itinerario encontrado
     * @throws ItinerarioLogicException cuando la ciudad no existe
     */
    @GET
    @Path("/perfil/{idP}/itinerarios/{idI}")
    public ItinerarioDTO getItinerario(@PathParam("idP") long idP, @PathParam("idI") Long idI )
    {
        
        System.out.println("Llega tener 1 itinerario");
        ItinerarioEntity itinerari = itinerarioLogic.getItinerario(idP, idI);
        ItinerarioDTO  itinerario = ItinerarioConverter.refEntity2DTO(itinerari);
        System.out.println(itinerario.getNombreIt() + "    "+ itinerario.getId());
        return itinerario;
    }

    /**
     * Agrega un itinerario
     * http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/createIt
     * 
     * 
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregado
     * @throws ItinerarioLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    @Path("/perfil/{idP}/createIt/{idIt}/nombre/{nombre}/fechai/{fechai}/fechaf{fechaFin}")
    public  ItinerarioDTO createItinerario(@PathParam("idP") long idP,
                                           @PathParam("idIt") long idIt ,
                                           @PathParam("nombre") String nomb,
                                           @PathParam("fechai") Date fechai,
                                           @PathParam("fechaFin") Date fechaf)  
    {
        System.out.println("Llega crear itinerario");
        System.out.println(" llega el itinerario a ser creado = "+ nomb);
        UsuarioDTO user = new UsuarioDTO(idP, null, null, null,null,null);
        ItinerarioDTO itinerarioDTOO = new ItinerarioDTO(user, idIt, nomb, fechai,fechaf, null);
        ItinerarioDTO itinerarioDTO;
        ItinerarioEntity itinerarioN;
        try 
	{
               ItinerarioEntity itinerario = ItinerarioConverter.refDTO2Entity(itinerarioDTOO);
               System.out.println(" llega el itinerario a ser creado = "+ itinerario.getNombre());
               itinerarioN = itinerarioLogic.createActualizarItinerario(itinerario);
               itinerarioDTO = ItinerarioConverter.refEntity2DTO(itinerarioN);
        } 
	catch (Exception e) 
	{
            System.out.println(e.getMessage());
		return null;
	}
        return itinerarioDTO;
    }

    /**
     * Actualiza los datos de un itinerario
     * 
     *  http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/cambiarItinerario/0
     * 
     * @param id identificador del itinerario
     * @param itinerario  itinerario a modificar
     * @return datos del itineario modificado 
     * @throws ItinerarioLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("/perfil/{idP}/cambiarItinerario/{idI}")
    public ItinerarioDTO updateItinerario(@PathParam("idP") int idP,@PathParam("idI") int idI, ItinerarioDTO itNuevo)
    {
        System.out.println("Llega cambiar itinerario");
        return ItinerarioConverter.refEntity2DTO(itinerarioLogic.updateItinerario(ItinerarioConverter.refDTO2Entity(itNuevo)));
    }

    /**
     * 
     * http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/eliminarItinerario/0
     * 
     * 
     * Elimina los datos de un itinerario
     * @param idP identificador del usuario dueño del itinerario a eliminar
     * @param idI identificador del itinerario a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("/perfil/{idP}/eliminarItinerario/{idI}")
    public void deleteItinerario(@PathParam("idP") long idP, @PathParam("idI") long idI) 
    {
        System.out.println("Llega borrar itinerario");
        itinerarioLogic.deleteItinerario(idP, idI);
    }

}