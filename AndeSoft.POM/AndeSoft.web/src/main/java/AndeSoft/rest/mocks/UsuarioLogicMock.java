package AndeSoft.rest.mocks;

/**
 * Mock del recurso Ciudades (Mock del servicio REST)
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
 * Mock del recurso Ciudades (Mock del servicio REST)
 */
@Named
@ApplicationScoped
public class UsuarioLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(UsuarioLogicMock.class.getName());

    // listado de ciudades
    private static ArrayList<UsuarioDTO> usuarios;

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
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + usuarios );
    }

    /**
     * Obtiene el listado de personas.
     * @return lista de ciudades
     * @throws CityLogicException cuando no existe la lista en memoria
     */
    public List<UsuarioDTO> getCities() {
    	if (usuarios == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		//throw new CityLogicException("Error interno: lista de ciudades no existe.");
    	}

    	logger.info("retornando todas las ciudades");
    	return usuarios;
    }

    /**
     * Obtiene una ciudad
     * @param id identificador de la ciudad
     * @return ciudad encontrada
     * @throws CityLogicException cuando la ciudad no existe
     */
    public UsuarioDTO getCity(Long id)  {
    	logger.info("recibiendo solicitud de ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (UsuarioDTO city : usuarios) {
            if (Objects.equals(city.getId(), id)){
            	logger.info("retornando ciudad " + city);
                return city;
            }
        }

        // si no encuentra la ciudad
        logger.severe("No existe ciudad con ese id");
        return  null;
        //throw new CityLogicException("No existe ciudad con ese id");
    }

    /**
     * Agrega una ciudad a la lista.
     * @param newCity ciudad a adicionar
     * @throws CityLogicException cuando ya existe una ciudad con el id suministrado
     * @return ciudad agregada
     */
    public UsuarioDTO createCity(UsuarioDTO usuario)  {
    	logger.info("recibiendo solicitud de agregar ciudad " + usuario);

    	// la nueva ciudad tiene id ?
    	if ( usuario.getId() == 0 ) {
	    	// busca la ciudad con el id suministrado
	        for (UsuarioDTO city : usuarios) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(city.getId(), usuario.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	               // throw new CityLogicException("Ya existe una ciudad con ese id");
	            }
	        }

	    // la nueva ciudad no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		Long newId = Long.MAX_VALUE;
	        for (UsuarioDTO city : usuarios) {
	            if (newId <= city.getId()){
	                newId =  city.getId() + 1;
	            }
	        }
	        usuario.setId(newId);
    	}

        // agrega la ciudad
    	logger.info("agregando ciudad " + usuario);
        usuarios.add(usuario);
        return usuario;
    }

    /**
     * Actualiza los datos de una ciudad
     * @param id identificador de la ciudad a modificar
     * @param city ciudad a modificar
     * @return datos de la ciudad modificada
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public UsuarioDTO updateCity(Long id, UsuarioDTO updatedCity) {
    	logger.info("recibiendo solictud de modificar ciudad " + updatedCity);

    	// busca la ciudad con el id suministrado
        for (UsuarioDTO city : usuarios) {
            if (Objects.equals(city.getId(), id)) {

            	// modifica la ciudad
            	city.setId(updatedCity.getId());
                city.setName(updatedCity.getName());

                // retorna la ciudad modificada
            	logger.info("Modificando ciudad " + city);
                return city;
            }
        }
        
        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        return null;
       // throw new CityLogicException("No existe una ciudad con ese id");
    }

    /**
     * Elimina los datos de una ciudad
     * @param id identificador de la ciudad a eliminar
     * @throws CityLogicException cuando no existe una ciudad con el id suministrado
     */
    public void deleteCity(Long id) {
    	logger.info("recibiendo solictud de eliminar ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (UsuarioDTO city : usuarios) {
            if (Objects.equals(city.getId(), id)) {

            	// elimina la ciudad
            	logger.info("eliminando ciudad " + city);
                usuarios.remove(city);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
       // throw new CityLogicException("No existe una ciudad con ese id");
    }
}
