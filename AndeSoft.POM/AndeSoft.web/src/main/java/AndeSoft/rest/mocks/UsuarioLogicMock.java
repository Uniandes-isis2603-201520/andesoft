package AndeSoft.rest.mocks;

/**
 * Mock del recurso Usuarios (Mock del servicio REST)
 * @author Asistente
 */
import AndeSoft.rest.dtos.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;




/**
 * Mock del recurso Usuarios (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class UsuarioLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(UsuarioLogicMock.class.getName());

    // listado de usuarios
    private static ArrayList<UsuarioDTO> usuarios;

    static ArrayList getItinerariosDeUsuario(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void setItinerariosDeUsuario(long id, ArrayList itinerarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Constructor. Crea los datos de ejemplo.
     */
    public UsuarioLogicMock() {

     
    	if (usuarios == null) {
            usuarios = new ArrayList<>();
            usuarios.add(new UsuarioDTO(Long.MAX_VALUE,"juan","perez","juan","j1","juan@algo"));
            //cities.add(new CityDTO(2L, "Cali"));
            //cities.add(new CityDTO(3L, "Medellin"));
        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de usuarios");
    	logger.info("usuarios" + usuarios );
    }

    /**
     * Obtiene el listado de personas.
     * @return lista de usuarios
     * @throws UsusarioLogicException cuando no existe la lista en memoria
     */
    public List<UsuarioDTO> getUsers() {
    	if (usuarios == null) {
    		logger.severe("Error interno: lista de usuarios no existe.");
    		//throw new UsusarioLogicException("Error interno: lista de ususarios no existe.");
    	}

    	logger.info("retornando todos los ususarios");
    	return usuarios;
    }

    /**
     * Obtiene un usuario
     * @param id identificador del usuario
     * @return usuario encontrado
     * @throws UsuarioLogicException cuando el usuario no existe
     */
    public UsuarioDTO getUser(Long id)  {
    	logger.info("recibiendo solicitud de usuario con id " + id);

    	// busca el usuario con el id suministrado
        for (UsuarioDTO user : usuarios) {
            if (Objects.equals(user.getId(), id)){
            	logger.info("retornando usuario " + user);
                return user;
            }
        }

        // si no encuentra el ususario
        logger.severe("No existe usuario con ese id");
        return  null;
        //throw new UsuarioLogicException("No existe ususario con ese id");
    }

    /**
     * Agrega un ususario a la lista.
     * @param usuario ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     * @return usuario agregado
     */
    public UsuarioDTO createUser(UsuarioDTO usuario)  {
    	logger.info("recibiendo solicitud de agregar usuario " + usuario);

    	// el nuevo usuario tiene id ?
    	if ( usuario.getId() == 0 ) {
	    	// busca el usuario con el id suministrado
	        for (UsuarioDTO user : usuarios) {
	        	// si existe un usuario con ese id
	            if (Objects.equals(user.getId(), usuario.getId())){
	            	logger.severe("Ya existe un usuario con ese id");
	               // throw new UsuarioLogicException("Ya existe un usuario con ese id");
	            }
	        }

	    // el nuevo usuario no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id para el nuevo usuario");
    		Long newId = Long.MAX_VALUE;
	        for (UsuarioDTO user : usuarios) {
	            if (newId <= user.getId()){
	                newId =  user.getId() + 1;
	            }
	        }
	        usuario.setId(newId);
    	}

        // agrega el usuario
    	logger.info("agregando usuario " + usuario);
        usuarios.add(usuario);
        return usuario;
    }

    /**
     * Actualiza los datos de un usuario
     * @param id identificador del usuario a modificar
     * @param user usuario a modificar
     * @return datos de usuario modificado
     * @throws UsuarioLogicException cuando no existe un usuario con el id suministrado
     */
    public UsuarioDTO updateUser(Long id, UsuarioDTO updatedUser) {
    	logger.info("recibiendo solictud de modificar usuario " + updatedUser);

    	// busca el usuario con el id suministrado
        for (UsuarioDTO user : usuarios) {
            if (Objects.equals(user.getId(), id)) {

            	// modifica el usuario
            	user.setId(updatedUser.getId());
                user.setName(updatedUser.getName());

                // retorna el usuario modificada
            	logger.info("Modificando ciudad " + user);
                return user;
            }
        }
        
        // no encontró usuario con ese id ?
        logger.severe("No existe usuario con ese id");
        return null;
       // throw new CityLogicException("No existe una ciudad con ese id");
    }

    /**
     * Elimina los datos de un usuario
     * @param id identificador del usuario a eliminar
     * @throws UsuarioLogicException cuando no existe un usuario con el id suministrado
     */
    public void deleteUser(Long id) {
    	logger.info("recibiendo solictud de eliminar usuario con id " + id);

    	// busca el usuario con el id suministrado
        for (UsuarioDTO user : usuarios) {
            if (Objects.equals(user.getId(), id)) {

            	// elimina el usuario
            	logger.info("eliminando usuario " + user);
                usuarios.remove(user);
                return;
            }
        }

        // no encontró el usuario con ese id ?
        logger.severe("No existe un usuario con ese id");
       // throw new CityLogicException("No existe una ciudad con ese id");
    }
}
