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
import andesoft.api.IUsarioLogic;
import andesoft.entities.ItinerarioEntity;
import andesoft.entities.UsuarioEntity;
import java.text.SimpleDateFormat;
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
import javax.ws.rs.QueryParam;
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
//@Produces("application/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/modI")
public class ItinerarioResource 
{

@Inject
IItinerarioLogic itinerarioLogic;
@Inject
IUsarioLogic usuarioLogic;
        
    /**@GET
    @Path("/perfil/itinerarios")
    public void getItinerariosPrueba() 
    {
        System.out.println("LLEGAAAAA");
        
    }*/ 
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
    @Path("/perfil/{idP}/itinerarios")
    public List<ItinerarioDTO> getItinerarios(@PathParam("idP") long id) 
    {
        System.out.println("Llega tener itinerarios");
        
        List<ItinerarioDTO> temp= ItinerarioConverter.listEntity2DTO(itinerarioLogic.getItinerarios(id));
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
    public ItinerarioDTO getItinerario(  @PathParam("idP") long idP,
                                        @PathParam("idI") String nombreIt )
    {
        
        System.out.println("Llega tener 1 itinerario" + nombreIt);
        
        Long idIt = itinerarioLogic.getItinerarioId(nombreIt);
        ItinerarioEntity itinerari = itinerarioLogic.getItinerario( idIt);
        ItinerarioDTO  itinerario = ItinerarioConverter.refEntity2DTO(itinerari);
        System.out.println(itinerario.getNombreIt() + "    "+ itinerario.getId());
        return itinerario;
    }

    /**
     * Agrega un itinerario
     * http://localhost:8080/AndeSoft.web/api/Itinerarios/perfil/0/createIt
     * 
     * @return datos del itinerario a agregado
     * @throws ItinerarioLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
     @Path("/perfil/{idP}/itinerario/nombre/{nombreIt}/fechai/{fechait}/fechaf/{fechaFin}")
    public  ItinerarioDTO createItinerario( @PathParam("idP") long idP,
                                            @PathParam("nombreIt") String nom,
                                            @PathParam("fechait") String fechaI,
                                            @PathParam("fechaFin") String fechaF)  
    {
        System.out.println("Llega crear itinerario");
        System.out.println(" llega el itinerario a ser creado = "+ nom);
        UsuarioEntity user = usuarioLogic.getUsuario(idP);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ItinerarioDTO itinerarioDTO;
        try 
	{
        Date fechaIn = formatter.parse(fechaI);
        Date fechaFi = formatter.parse(fechaF);
        ItinerarioDTO itinerarioDTOO = new ItinerarioDTO(null, -1, nom, fechaIn,fechaFi, null);
        
        ItinerarioEntity itinerarioN;
        
               ItinerarioEntity itinerario = ItinerarioConverter.refDTO2Entity(itinerarioDTOO);
               itinerario.setUsuario(user);
               System.out.println(" llega el itinerario a ser creado = "+ itinerario.getNombre() + "  "+ itinerario.getId() + "  "+ itinerario.getUsuario().getId());
               itinerarioN = itinerarioLogic.crearItinerario(itinerario);
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
    @Path("/perfil/{idP}/itinerario/nombre/{nombreIt}/fechai/{fechait}/fechaf/{fechaFin}/viejoIt/{idV}")
    public  ItinerarioDTO updateItinerario( @PathParam("idP") Long idP,
                                            @PathParam("nombreIt") String nom,
                                            @PathParam("fechait") String fechaI,
                                            @PathParam("fechaFin") String fechaF,
                                            @PathParam("idV") long viejoIt)  
    {
       System.out.println("Llega crear itinerario");
        System.out.println(" llega el itinerario a ser creado = "+ nom);
        UsuarioEntity user = usuarioLogic.getUsuario(idP);
        
        //UsuarioDTO user = new UsuarioDTO(idP, null, null, null,null,null);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ItinerarioDTO itinerarioDTO;
        try 
	{
        Date fechaIn = formatter.parse(fechaI);
        Date fechaFi = formatter.parse(fechaI);
        ItinerarioDTO itinerarioDTOO = new ItinerarioDTO(null, -1, nom, fechaIn,fechaFi, null);
        
        ItinerarioEntity itinerarioN;
        
               ItinerarioEntity itinerario = ItinerarioConverter.refDTO2Entity(itinerarioDTOO);
               itinerario.setUsuario(user);
               System.out.println(" llega el itinerario a ser creado = "+ itinerario.getNombre() + "  "+ itinerario.getId() + "  "+ itinerario.getUsuario().getId());
               itinerarioN = itinerarioLogic.updateItinerario(itinerario);
               itinerarioLogic.deleteItinerario(idP, viejoIt);
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
    public void deleteItinerario(@PathParam("idP") long idP, @PathParam("idI") String nombreI) 
    {
        Long idIt = itinerarioLogic.getItinerarioId(nombreI);
        System.out.println("Llega borrar itinerario");
        itinerarioLogic.deleteItinerario(idP, idIt);
    }
    
    
    // desde postman
    
    
    @POST
     @Path("/perfil/{idP}/itinerario")
    public  ItinerarioDTO createItinerarioP( @PathParam("idP") long idP,ItinerarioDTO itinerario)  
    {
        System.out.println("Llega crear itinerario");
        System.out.println(" llega el itinerario a ser creado = "+ itinerario.getNombreIt());
        UsuarioEntity user = usuarioLogic.getUsuario(idP);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ItinerarioDTO itinerarioDTO;
        try 
	{
        Date fechaIn = (itinerario.getFechaIni());
        Date fechaFi = itinerario.getFechaFin();
        ItinerarioDTO itinerarioDTOO = new ItinerarioDTO(null, -1, itinerario.getNombreIt(), fechaIn,fechaFi, null);
        
        ItinerarioEntity itinerarioN;
        
               ItinerarioEntity itinerarioE = ItinerarioConverter.refDTO2Entity(itinerarioDTOO);
               itinerarioE.setUsuario(user);
               System.out.println(" llega el itinerario a ser creado = "+ itinerarioE.getNombre() + "  "+ itinerario.getId() + "  "+ itinerarioE.getUsuario().getId());
               itinerarioN = itinerarioLogic.crearItinerario(itinerarioE);
               itinerarioDTO = ItinerarioConverter.refEntity2DTO(itinerarioN);
        } 
	catch (Exception e) 
	{
            System.out.println(e.getMessage());
		return null;
	}
        return itinerarioDTO;
    }

}