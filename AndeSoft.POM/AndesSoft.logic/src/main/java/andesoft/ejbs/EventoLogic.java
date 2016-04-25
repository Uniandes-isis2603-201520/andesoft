package andesoft.ejbs;


import andesoft.api.IEventoLogic;
import andesoft.entities.EventoEntity;
import andesoft.persistence.EventoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EventoLogic implements IEventoLogic {

    private static final Logger logger = Logger.getLogger(PuntoInteresLogic.class.getName());

    
    @Inject
    private EventoPersistence persistence;
    
    @Override
    public EventoEntity getEvento(Long id) {
        logger.log(Level.INFO, "Inicia proceso de consultar evento con id={0}", id);
        EventoEntity evento = persistence.find(id);
        if (evento == null) {
            logger.log(Level.SEVERE, "El evento con el id {0} no existe", id);
            throw new IllegalArgumentException("El evento solicitado no existe");
        }
        logger.log(Level.INFO, "Termina proceso de consultar evento con id={0}", id);
        return evento;
    }

    @Override
    public EventoEntity createEvento(EventoEntity entity) {
        logger.info("Inicia proceso de creación de evento");
        persistence.create(entity);
        logger.info("Termina proceso de creación de evento");
        return entity;
    }

    @Override
    public EventoEntity updateEvento(EventoEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar evento con id={0}", entity.getId());
        EventoEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar el evento con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteEvento(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar evento con id={0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Termina proceso de borrar evento con id={0}", id);
    }

    @Override
    public List<EventoEntity> getEventos(){
        logger.info("Inicia proceso de consultar todos los eventos");
        List<EventoEntity> eventos = persistence.findAll();
        logger.info("Termina proceso de consultar todos los eventos");
        return eventos;
    }
   

}
