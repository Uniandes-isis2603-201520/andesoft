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
 * ruta "/api/users" 
 * 
 * @author Asistente
 */
@Path("users")
@Produces("application/json")
public class UsuarioResource {

	@Inject
	UsuarioLogicMock userLogic;

	/**
	 * Obtiene el listado de ciudades. 
	 * @return lista de usuarios
	 * @throws UsuarioLogicException excepción retornada por la lógica  
	 */
    @GET
    public List<UsuarioDTO> getUsers() {
        return userLogic.getUsers();
    }

    /**
     * Obtiene un ususario
     * @param id identificador del ususario
     * @return usuario encontrado
     * @throws UsuarioLogicException cuando el usuario no existe
     */
    @GET
    @Path("{id: \\d+}")
    public UsuarioDTO getUser(@PathParam("id") Long id)  {
        return userLogic.getUser(id);
    }

    /**
     * Agrega un usuario
     * @param user usuario a agregar
     * @return datos del usuario a agregar
     * @throws UsuarioLogicException cuando ya existe un usuario con el id suministrado
     */
    @POST
    public UsuarioDTO createUser(UsuarioDTO user)  {
        return userLogic.createUser(user);
    }

    /**
     * Actualiza los datos de un usuario
     * @param id identificador del usuario a modificar
     * @param user usuario a modificar
     * @return datos del ususario modificado 
     * @throws UsusarioLogicException cuando no existe un usuario con el id suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateUser(@PathParam("id") Long id, UsuarioDTO user)  {
        return userLogic.updateUser(id, user);
    }

    /**
     * Elimina los datos de un ususario
     * @param id identificador del ususario a eliminar
     * @throws UsuarioLogicException cuando no existe un ususario con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUser(@PathParam("id") Long id)  {
    	userLogic.deleteUser(id);
    }

}
