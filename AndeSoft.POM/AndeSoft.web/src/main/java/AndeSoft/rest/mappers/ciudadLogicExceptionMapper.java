package AndeSoft.rest.mappers;

import AndeSoft.rest.exceptions.ciudadLogicException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



/**
 * Convertidor de Excepciones CityLogicException a mensajes REST.
 */
@Provider
public class ciudadLogicExceptionMapper implements ExceptionMapper<ciudadLogicException>
{

    @Override
    public Response toResponse(ciudadLogicException e) {
         return Response
				.status(Response.Status.NOT_FOUND)	// estado HTTP 404
				.entity(e.getMessage())			// mensaje adicional
				.type("text/plain")
				.build();
    }


}
