package andesoft.api;


import andesoft.entities.ItinerarioEntity;
import java.util.List;


public interface IItinerarioLogic {
    
    public ItinerarioEntity getItinerario(int idUser, int id) ;

    public ItinerarioEntity createItinerario(ItinerarioEntity entity);

    public ItinerarioEntity updateItinerario(ItinerarioEntity entity);

    public void deleteItinerario(int id);

    
}