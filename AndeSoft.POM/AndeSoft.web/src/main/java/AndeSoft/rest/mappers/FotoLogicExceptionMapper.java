/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AndeSoft.rest.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import AndeSoft.rest.exceptions.FotoLogicException;
/**
 * Convertidor de Excepciones CityLogicException a mensajes REST.
 * @author AndresFelipe
 */
@Provider
public class FotoLogicExceptionMapper implements ExceptionMapper<FotoLogicException> {
    
    /**
    * Generador de una respuesta a partir de una excepción
    * @param ex excecpión a convertir a una respuesta REST
    */
    
    @Override
    public Response toResponse (FotoLogicException ex){
        
        return Response
                        .status(Response.Status.NOT_FOUND)
                        .entity(ex.getMessage())
                        .type("text/plain")
                        .build();
    }
    
}
