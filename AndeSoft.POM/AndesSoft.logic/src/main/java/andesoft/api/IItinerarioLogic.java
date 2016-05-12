package andesoft.api;


import andesoft.entities.ItinerarioEntity;
import java.util.List;


public interface IItinerarioLogic {
    
    public List<ItinerarioEntity> getItinerarios(Long id);
    
    public ItinerarioEntity getItinerario( Long id) ;
    
    public Long getItinerarioId(String nombre);

    public ItinerarioEntity crearItinerario(ItinerarioEntity entity);

    public ItinerarioEntity updateItinerario(ItinerarioEntity entity);

    public void deleteItinerario(Long idp, Long id);
    
    //public ItinerarioEntity createActualizarItinerario(ItinerarioEntity entity) ;

    
}