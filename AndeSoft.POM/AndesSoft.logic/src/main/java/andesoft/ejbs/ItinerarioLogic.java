package andesoft.ejbs;


import andesoft.api.IItinerarioLogic;
import andesoft.entities.ItinerarioEntity;
import andesoft.persistence.ItinerarioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ItinerarioLogic implements IItinerarioLogic 
{
    
    private static final Logger logger = Logger.getLogger(ItinerarioLogic.class.getName());
    // @Inject
    //private AuthorPersistence persistence;
    
    @Inject
    private ItinerarioPersistence persistence;
    
    @Override
    public ItinerarioEntity getItinerario( Long id) 
    {
        logger.log(Level.INFO, "Inicia proceso de consultar itinerario id={0}", id);
        ItinerarioEntity itinerario = persistence.find(id);
        if (itinerario == null) {
            logger.log(Level.SEVERE, "El itinerario con id no existe  id={0}", id);
            throw new IllegalArgumentException("El itinerario no existe");
        }
        
        logger.log(Level.INFO, "Termina proceso de consultar itinerario con id={0}", id);
        return itinerario;
    }
    @Override
    public Long getItinerarioId( String nombre) 
    {
        logger.log(Level.INFO, "Inicia proceso de consultar itinerario nombre ={0}", nombre);
        List<ItinerarioEntity>  lista  = persistence.findPorNombre(nombre);
        if (lista == null) 
        {
            logger.log(Level.SEVERE, "El itinerario con nombre no existe  id={0}", nombre);
            throw new IllegalArgumentException("El itinerario no existe");
        }
        ItinerarioEntity it = lista.get(0);
        Long itinerario = it.getId();
        logger.log(Level.INFO, "Termina proceso de consultar itinerario con id={0}", nombre);
        return itinerario;
    }
    
   
    @Override
    public ItinerarioEntity crearItinerario(ItinerarioEntity entity) 
    {
        logger.info("Inicia proceso de creación itinerario");
        persistence.create(entity);
        logger.info("Termina proceso de creación itinerario");
        return entity;
    }

    @Override
    public ItinerarioEntity updateItinerario (ItinerarioEntity entity) {
        logger.log(Level.INFO, "Inicia proceso de actualizar itinearario con id={0}", entity.getId());
        ItinerarioEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar itinerario id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteItinerario(Long idp, Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar itinerario con id={0}", id);
        persistence.delete(idp,id);
        logger.log(Level.INFO, "Termina proceso de borrar itinerario con id={0}", id);
    }
    
    @Override
    public List<ItinerarioEntity> getItinerarios(Long idUser) 
    {
        logger.info("Inicia proceso de consultar todos los itinerarios de un user");
        List<ItinerarioEntity> itinerarios = persistence.findAll(idUser);
        logger.info("Termina proceso de consultar todos los puntos de interes");
        return itinerarios;
    }
   

     public List<ItinerarioEntity> getItinerarios() {
        logger.info("Inicia proceso de consultar todos los puntos de interes");
        List<ItinerarioEntity> itinerarios = persistence.findAll();
        logger.info("Termina proceso de consultar todos los puntos de interes");
        return itinerarios;
    }

}
