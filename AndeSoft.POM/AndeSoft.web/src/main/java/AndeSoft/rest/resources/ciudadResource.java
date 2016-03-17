/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.resources;

import AndeSoft.rest.dtos.ciudadDTO;
import AndeSoft.rest.exceptions.ciudadLogicException;
import AndeSoft.rest.mocks.ciudadLogicMock;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Produces("application/json")
public class ciudadResource
{
    /* @Context
    private HttpServletResponse response;
    */

     @Inject
     ciudadLogicMock cityLogic;


    /**
	 * Obtiene el listado de ciudades.
	 * @return lista de ciudades
	 * @throws CityLogicException excepción retornada por la lógica
	 *///throws CityLogicException
    @GET
    public List<ciudadDTO> getCities()  throws ciudadLogicException {
        return cityLogic.getCiudades();
    }


    @GET
    @Path("{name: \\d+}")
    public ciudadDTO getCity(@PathParam("name") String name) throws ciudadLogicException {
        return cityLogic.getCity(name);
    }
   /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */

    /*
    @GET
    @Path("{id: \\d+}")
    public CityDTO getCity(@PathParam("id") Long id) throws CityLogicException {
        return cityLogic.getCity(id);
    }
*/

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
    }
}
