package andesoft.api;


import andesoft.entities.ItinerarioEntity;
import java.util.List;


public interface IItinerarioLogic {
    
    public ItinerarioEntity getItinerario(Long idUser, Long id) ;

    public ItinerarioEntity createItinerario(ItinerarioEntity entity);

    public ItinerarioEntity updateItinerario(ItinerarioEntity entity);

    public void deleteItinerario(Long id);

    
}