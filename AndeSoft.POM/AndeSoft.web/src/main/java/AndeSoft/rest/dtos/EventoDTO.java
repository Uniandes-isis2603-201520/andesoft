package AndeSoft.rest.dtos;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author mm.gomez10
 * EventoDTO
 * Objeto de transferencia de datos de Eventos.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */

@XmlRootElement
public class EventoDTO {

    private Long id;
    
    @PodamExclude
    private CiudadDTOf ciudad;
    
    private String nombre;
    
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaInicio;
    
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaFinal;
    /**
     * Constructor por defecto
     */
    public EventoDTO() {
    }

    /**
     * Constructor con parámetros.
     * @param pId 
     * @param pNombre 
     * @param pFechaInicio
     * @param pFechaFinal
     * @param pCiudad
     */
    public EventoDTO(Long pId, CiudadDTOf pCiudad, String pNombre, Date pFechaInicio, Date pFechaFinal) {
        super();
        this.id = pId;
        this.nombre = pNombre;
        this.fechaInicio = pFechaInicio;
        this.fechaFinal = pFechaFinal;
        this.ciudad = pCiudad;
    }


    public Long getId() {
        return id;
    }

  
    public void setId(Long id) {
        this.id = id;
    }

 
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }
    
     public Date getFechaInicio(){
        return fechaInicio;
    }

    public void setFechaInicio(Date pFechaInicio) {
        this.fechaInicio = pFechaInicio;
    }

    public Date getFechaFinal(){
        return fechaFinal;
    }

    public void setFechaFinal(Date pFechaFinal) {
        this.fechaFinal = pFechaFinal;
    }
    
    public CiudadDTOf getCiudad(){
        return ciudad;
    }

    public void setCiudad(CiudadDTOf pCiudad) {
        this.ciudad = pCiudad;
    }

   
    @Override
    public String toString() {
        String total = "{\"id\":"+id+",\"ciudad\":"+ciudad+",\"nombre\":\""+nombre+
                "\",\"fechaInicio\":\""+fechaInicio+"\",\"fechaFinal\":\""+fechaFinal
                    +"}";
        return total;
    }
}