/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.dtos;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.GET;

/**
 *
 * @author e.galvis10
 */

public class ciudadDTO {
     @Context
    private HttpServletResponse response;
    private Long ID;
    private String name;
    private String fechaInicio;
    private String fechaFinal;




    /**
     * Constructor por defecto
     */
    public ciudadDTO() {
	}

    /**
     * Constructor con parámetros.
     * identificador de la ciudad
     * @param name nombre de la ciudad
     */
    public ciudadDTO(Long id, String name, String fechaInicio, String fechaFinal) {
		super();
		this.ID = id;
		this.name = name;
                this.fechaInicio = fechaInicio;
                this.fechaFinal = fechaFinal;
	}

	/**
     * @return the id
     *
    public Long getId() {
        return id;
    }
*/


    /**
     * @param id the id to set
     *
    public void setId(Long id) {
        this.id = id;
    }
    * */


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

     /**
     * @return the name
     */
    public String getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param name the name to set
     */
    public void setFechaInicio(String fecha) {
        this.fechaInicio = fecha;
    }

     public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param name the name to set
     */
    public void setFechaFinal(String fecha) {
        this.fechaFinal = fecha;
    }

    public Long getID() {
        return ID;
    }

    /**
     * @param name the name to set
     */
    public void setID(Long id) {
        this.ID = id;
    }

    /**
     * Convierte el objeto a una cadena
     */
    @Override
    public String toString() {
    	return "{ id : " + getID() + ", name : \"" + getName() + "\" }" ;
    }

}
