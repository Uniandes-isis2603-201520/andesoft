package andesoft.api;


import andesoft.entities.EventoEntity;
import java.util.List;


public interface IEventoLogic {

    public List<EventoEntity> getEventos();
    
    public EventoEntity getEvento(Long id) ;

    public EventoEntity createEvento(EventoEntity entity);

    public EventoEntity updateEvento(EventoEntity entity);

    public void deleteEvento(Long id);

    
}