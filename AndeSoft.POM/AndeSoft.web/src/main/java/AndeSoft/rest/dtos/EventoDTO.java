package AndeSoft.rest.dtos;

/**
 *
 * @author mm.gomez10
 * EventoDTO
 * Objeto de transferencia de datos de Eventos.
 * Los DTO especifican los mensajes que se envían entre el cliente y el servidor.
 */
public class EventoDTO {

    private Long id;
    private int idItinerario;
    private String nombre;
    private String fechaInicio;
    private String fechaFinal;
    private String ciudad;

    /**
     * Constructor por defecto
     */
    public EventoDTO() {
	}

    /**
     * Constructor con parámetros.
     * @param pId 
     * @param pIdItinerario
     * @param pNombre 
     * @param pFechaInicio
     * @param pFechaFinal
     * @param pCiudad
     */
    public EventoDTO(Long pId, int pIdItinerario, String pNombre, String pFechaInicio, String pFechaFinal, String pCiudad ) {
		super();
		this.id = pId;
                this.idItinerario = pIdItinerario;
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

    public int getIdItinerario() {
        return idItinerario;
    }

  
    public void setIdItinerario(int pIdItinerario) {
        this.idItinerario = pIdItinerario;
    }
    
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String pNombre) {
        this.nombre = pNombre;
    }
    
     public String getFechaInicio(){
        return fechaInicio;
    }

    public void setFechaInicio(String pFechaInicio) {
        this.fechaInicio = pFechaInicio;
    }

    public String getFechaFinal(){
        return fechaFinal;
    }

    public void setFechaFinal(String pFechaFinal) {
        this.fechaFinal = pFechaFinal;
    }
    
    public String getCiudad(){
        return ciudad;
    }

    public void setCiudad(String pCiudad) {
        this.ciudad = pCiudad;
    }

   
    @Override
    public String toString() {
    	return "{ id : " + getId() + ", name : \"" + getNombre() + "\" }" ;
    }
}
