/*
 * CityResource.java
 * Clase que representa el recurso "/cities"
 * Implementa varios métodos para manipular las ciudades
 */
package AndeSoft.rest.resources;



import AndeSoft.rest.dtos.UsuarioDTO;
import AndeSoft.rest.mocks.UsuarioLogicMock;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso REST correspondiente a "cities".
 * 
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "cities". 
 * Al ejecutar la aplicación, el recurse será accesibe a través de la 
 * ruta "/api/cities" 
 * 
 * @author Asistente
 */
@Path("cities")
@Produces("application/json")
public class UsuarioResource {

	@Inject
	UsuarioLogicMock cityLogic;

	/**
	 * Obtiene el listado de ciudades. 
	 * @return lista de ciudades
	 * @throws CityLogicException excepción retornada por la lógica  
	 */
    @GET
    public List<UsuarioDTO> getCities() {
        return cityLogic.getCities();
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getCity(@PathParam("id") Long id)  {
        return cityLogic.getCity(id);
    }

    /**
     * Agrega una ciudad
     * @param city ciudad a agregar
     * @return datos de la ciudad a agregar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     */
    @POST
    public UsuarioDTO createCity(UsuarioDTO city)  {
        return cityLogic.createCity(city);
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada 
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateCity(@PathParam("id") Long id, UsuarioDTO city)  {
        return cityLogic.updateCity(id, city);
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id)  {
    	cityLogic.deleteCity(id);
    }

}
