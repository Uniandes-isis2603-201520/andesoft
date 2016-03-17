/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.mocks;

import AndeSoft.rest.dtos.ciudadDTO;
import AndeSoft.rest.exceptions.ciudadLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import java.util.Objects;

/**
 *
 * @author e.galvis10
 */
@Named
@ApplicationScoped
public class ciudadLogicMock {

     // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(ciudadLogicMock.class.getName());

    // listado de ciudades
    private static ArrayList<ciudadDTO> cities;

     public ciudadLogicMock() {

    	if (cities == null) {
            cities = new ArrayList<>();
            cities.add(new ciudadDTO(666L, "Bogota", "fechatest","fechadostest"));
            cities.add(new ciudadDTO( 666L,"Cali","fechatest","fechadostest"));
            cities.add(new ciudadDTO( 666L, "Medellin","fechatest","fechadostest"));
        }
        // indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + cities );
        }

     /**
     * Obtiene el listado de personas.
     * @return lista de ciudades
     * @throws CityLogicException cuando no existe la lista en memoria
     *///
    public List<ciudadDTO> getCiudades() throws ciudadLogicException{
    	if (cities == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		throw new ciudadLogicException("Error interno: lista de ciudades no existe.");
    	}
        logger.info("retornando todas las ciudades");
    	return cities;
    }
public ciudadDTO createCity(ciudadDTO newCity) throws ciudadLogicException {
    	logger.info("recibiendo solicitud de agregar ciudad " + newCity);
        logger.info("recibiendo solicitud de agregar ciudad con  " + newCity.getID());

        /*
    	// la nueva ciudad tiene id ?
    	if ( newCity.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (ciudadDTO city : cities) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(city.getId(), newCity.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new ciudadLogicException("Ya existe una ciudad con ese id");
	            }
	        }

*/
        /*
	    // la nueva ciudad no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		long newId = 1;
	        for (ciudadDTO city : cities) {
	            if (newId <= city.getId()){
	                newId =  city.getId() + 1;
	            }
	        }
	        newCity.setId(newId);
    	}
*/
        // agrega la ciudad
    	logger.info("agregando ciudad " + newCity);
        cities.add(newCity);
        return newCity;
    }
 public void deleteCity(String name) throws ciudadLogicException {
    	logger.info("recibiendo solictud de eliminar ciudad con nombre " + name);

    	// busca la ciudad con el id suministrado
        for (ciudadDTO city : cities) {
            if (Objects.equals(city.getName(), name)) {

            	// elimina la ciudad
            	logger.info("eliminando ciudad " + city);
                cities.remove(city);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new ciudadLogicException("No existe una ciudad con ese id");
    }
 public ciudadDTO getCity(String name) throws ciudadLogicException {
    	logger.info("recibiendo solicitud de ciudad con name " + name);

    	// busca la ciudad con el id suministrado
        for (ciudadDTO city : cities) {
            if (Objects.equals(city.getName(), name)){
            	logger.info("retornando ciudad " + city);
                return city;
            }
        }
        throw new ciudadLogicException("no existe");
 }


}
